package org.czareg.codewars.simple.card.game;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CardGameTest {

    private final CardGame cardGame = new CardGame();

    @Order(1)
    @DisplayName("Small decks")
    @Test
    void smallDecks() {
        assertEquals("Steve wins 2 to 1",
                cardGame.winner(new String[]{"A", "7", "8"}, new String[]{"K", "5", "9"}),
                "deckSteve = [\"A\", \"7\", \"8\"], deckJosh = [\"K\", \"5\", \"9\"]");

        assertEquals("Tie",
                cardGame.winner(new String[]{"T"}, new String[]{"T"}),
                "deckSteve = [\"T\"], deckJosh = [\"T\"]");

        assertEquals("Josh wins 1 to 0",
                cardGame.winner(new String[]{"T", "8"}, new String[]{"T", "9"}),
                "deckSteve = [\"T\", \"8\"], deckJosh = [\"T\", \"9\"]");
    }

    @Order(2)
    @DisplayName("Medium decks")
    @Test
    void mediumDecks() {
        assertEquals("Josh wins 4 to 3",
                cardGame.winner(
                        new String[]{"K", "2", "4", "5", "4", "3", "2", "K", "A", "T"},
                        new String[]{"Q", "3", "4", "6", "4", "3", "5", "A", "8", "7"}
                ),
                "deckSteve = [\"K\", \"2\", \"4\", \"5\", \"4\", \"3\", \"2\", \"K\", \"A\", \"T\"], deckJosh = [\"Q\", \"3\", \"4\", \"6\", \"4\", \"3\", \"5\", \"A\", \"8\", \"7\"]"
        );

        assertEquals("Tie",
                cardGame.winner(
                        new String[]{"A", "K", "2", "3", "A", "8", "5", "5", "7", "T"},
                        new String[]{"K", "A", "5", "9", "A", "3", "2", "6", "3", "T"}
                ),
                "deckSteve = [\"A\", \"K\", \"2\", \"3\", \"A\", \"8\", \"5\", \"5\", \"7\", \"T\"], deckJosh = [\"K\", \"A\", \"5\", \"9\", \"A\", \"3\", \"2\", \"6\", \"3\", \"T\"]"
        );
    }

    @Order(3)
    @DisplayName("Large deck")
    @Test
    void largeDeck() {
        assertEquals("Steve wins 10 to 8",
                cardGame.winner(
                        new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A", "5", "6", "8", "T", "3", "T", "J"},
                        new String[]{"A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2", "2", "2", "T", "T", "9", "4", "3"}
                ),
                "deckSteve = [\"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"T\", \"J\", \"Q\", \"K\", \"A\", \"5\", \"6\", \"8\", \"T\", \"3\", \"T\", \"J\"], " +
                        "deckJosh = [\"A\", \"K\", \"Q\", \"J\", \"T\", \"9\", \"8\", \"7\", \"6\", \"5\", \"4\", \"3\", \"2\", \"2\", \"2\", \"T\", \"T\", \"9\", \"4\", \"3\"]"
        );
    }

    private static final String CARDS = "23456789TJQKA";

    @Order(4)
    @DisplayName("Random tests")
    @Test
    void randomTests() {
        var rnd = ThreadLocalRandom.current();
        for (int run = 0; run < 100; ++run) {
            int deckSize = rnd.nextInt(1, 50);
            String[] deckSteve = rnd.ints(deckSize, 0, CARDS.length()).mapToObj(i -> String.valueOf(CARDS.charAt(i))).toArray(String[]::new);
            String[] deckJosh = rnd.ints(deckSize, 0, CARDS.length()).mapToObj(i -> String.valueOf(CARDS.charAt(i))).toArray(String[]::new);

            String expected = refSol(deckSteve, deckJosh);
            String msg = "deckSteve = [%s], deckJosh = [%s]".formatted(
                    Arrays.stream(deckSteve).map(s -> "\"" + s + "\"").collect(joining(", ")),
                    Arrays.stream(deckJosh).map(s -> "\"" + s + "\"").collect(joining(", ")));
            assertEquals(expected, cardGame.winner(deckSteve, deckJosh), msg);
        }
    }

    private String refSol(String[] deckSteve, String[] deckJosh) {
        int steve = 0, josh = 0;
        for (int i = 0; i < deckSteve.length; ++i) {
            int s = CARDS.indexOf(deckSteve[i]);
            int j = CARDS.indexOf(deckJosh[i]);
            if (s > j) ++steve;
            else if (j > s) ++josh;
        }
        if (steve == josh) return "Tie";
        if (steve > josh) return "Steve wins " + steve + " to " + josh;
        return "Josh wins " + josh + " to " + steve;
    }
}