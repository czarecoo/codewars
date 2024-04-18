package org.czareg.codewars.rock.paper.scissors.lizard.spock;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SheldonTest {

    @Test
    void player1Wins() {
        assertEquals("Player 1 Won!", Sheldon.rpsls("rock", "lizard"));
        assertEquals("Player 1 Won!", Sheldon.rpsls("paper", "rock"));
        assertEquals("Player 1 Won!", Sheldon.rpsls("scissors", "lizard"));
        assertEquals("Player 1 Won!", Sheldon.rpsls("lizard", "paper"));
        assertEquals("Player 1 Won!", Sheldon.rpsls("spock", "rock"));
    }

    @Test
    void player2Wins() {
        assertEquals("Player 2 Won!", Sheldon.rpsls("lizard", "scissors"));
        assertEquals("Player 2 Won!", Sheldon.rpsls("spock", "lizard"));
        assertEquals("Player 2 Won!", Sheldon.rpsls("paper", "lizard"));
        assertEquals("Player 2 Won!", Sheldon.rpsls("scissors", "spock"));
        assertEquals("Player 2 Won!", Sheldon.rpsls("rock", "spock"));
    }

    @Test
    void draws() {
        assertEquals("Draw!", Sheldon.rpsls("rock", "rock"));
        assertEquals("Draw!", Sheldon.rpsls("spock", "spock"));
    }

    private static final Map<String, String> OUTCOME = Map.of(
            "scissors", "paper lizard",
            "paper", "rock spock",
            "rock", "lizard scissors",
            "lizard", "spock paper",
            "spock", "scissors rock"
    );

    @Test
    void randomTests() {
        for (int i = 0; i < 100; i++) {
            String a = choice();
            String b = choice();
            assertEquals(solution(a, b), Sheldon.rpsls(a, b));
        }
    }

    private static final Random R = new Random();

    private static final String[] CNDS = {"scissors", "paper", "rock", "lizard", "spock"};

    private static String choice() {
        return CNDS[R.nextInt(CNDS.length)];
    }

    private static String solution(String a, String b) {
        int cmp = outcome(a, b) - outcome(b, a);
        return cmp == 0 ? "Draw!" : String.format("Player %d Won!", cmp > 0 ? 1 : 2);
    }

    private static int outcome(String a, String b) {
        return OUTCOME.get(a).contains(b) ? 1 : 0;
    }

}