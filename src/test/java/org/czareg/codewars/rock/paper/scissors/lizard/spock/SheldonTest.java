package org.czareg.codewars.rock.paper.scissors.lizard.spock;

import org.junit.jupiter.api.Test;

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
}