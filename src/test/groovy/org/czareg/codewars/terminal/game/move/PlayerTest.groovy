package org.czareg.codewars.terminal.game.move

import org.junit.jupiter.api.Test

class PlayerTest {

    @Test
    void basicTests() {
        assert Player.move(0, 4) == 8
        assert Player.move(3, 6) == 15
        assert Player.move(2, 5) == 12
    }

    @Test
    void randomTests() {
        def rand = new Random()
        100.times {
            def pos = rand.nextInt(20) + 1
            def roll = rand.nextInt(6) + 1
            assert Player.move(pos, roll) == solution(pos, roll)
        }
    }

    private static def solution(pos, roll) {
        pos + roll * 2
    }
}