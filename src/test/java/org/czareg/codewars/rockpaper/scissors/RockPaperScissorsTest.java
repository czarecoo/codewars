package org.czareg.codewars.rockpaper.scissors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsTest {

    @Test
    void test1() {
        assertEquals("Player 1 won!", RockPaperScissors.rps("rock", "scissors"));
        assertEquals("Player 1 won!", RockPaperScissors.rps("scissors", "paper"));
        assertEquals("Player 1 won!", RockPaperScissors.rps("paper", "rock"));
    }

    @Test
    void test2() {
        assertEquals("Player 2 won!", RockPaperScissors.rps("scissors", "rock"));
        assertEquals("Player 2 won!", RockPaperScissors.rps("paper", "scissors"));
        assertEquals("Player 2 won!", RockPaperScissors.rps("rock", "paper"));
    }

    @Test
    void test3() {
        assertEquals("Draw!", RockPaperScissors.rps("scissors", "scissors"));
        assertEquals("Draw!", RockPaperScissors.rps("paper", "paper"));
        assertEquals("Draw!", RockPaperScissors.rps("rock", "rock"));
    }
}