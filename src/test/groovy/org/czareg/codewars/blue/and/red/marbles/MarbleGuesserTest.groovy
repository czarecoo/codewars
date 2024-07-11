package org.czareg.codewars.blue.and.red.marbles

import org.junit.jupiter.api.Test

class MarbleGuesserTest {

    @Test
    void "Example Tests"() {
        assert MarbleGuesser.guessBlue(5, 5, 2, 3) == 0.6
        assert MarbleGuesser.guessBlue(5, 7, 4, 3) == 0.2
        assert MarbleGuesser.guessBlue(12, 18, 4, 6) == 0.4
    }

    @Test
    void "Random Tests"() {
        def random = new Random()
        random.with {
            (1..100).each {
                def blueStart = 1 + nextInt(99)
                def redStart = 1 + nextInt(99)
                def bluePulled = blueStart == 1 ? 0 : nextInt(blueStart)
                def redPulled = redStart == 1 ? 0 : nextInt(redStart)

                def actual = MarbleGuesser.guessBlue(blueStart, redStart, bluePulled, redPulled)
                def expected = solution(blueStart, redStart, bluePulled, redPulled)

                assert Math.abs(actual - expected) < 1e-6
            }
        }
    }

    private static def solution(blueStart, redStart, bluePulled, redPulled) {
        (blueStart - bluePulled) / (blueStart - bluePulled + redStart - redPulled)
    }
}