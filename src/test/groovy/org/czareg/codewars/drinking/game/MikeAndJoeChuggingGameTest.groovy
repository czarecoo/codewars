package org.czareg.codewars.drinking.game

import org.junit.jupiter.api.Test

class MikeAndJoeChuggingGameTest {

    @Test
    void "Basic tests"() {
        assert MikeAndJoeChuggingGame.play(3, 2) == "Joe"
        assert MikeAndJoeChuggingGame.play(4, 2) == "Mike"
        assert MikeAndJoeChuggingGame.play(9, 1000) == "Joe"
        assert MikeAndJoeChuggingGame.play(0, 1) == "Non-drinkers can't play"
    }

    @Test
    void "Random tests"() {
        def r = new Random()
        50.times {
            def A = r.nextInt(10)
            def B = r.nextInt(10)
            assert MikeAndJoeChuggingGame.play(A, B) == solution(A, B)
        }
    }

    private static String solution(A, B) {
        if (A < 1 || B < 1) {
            return "Non-drinkers can't play"
        }
        int i = 1
        int mike = 0
        int joe = 0
        while (true) {
            mike += i
            if (mike > A) {
                return "Joe"
            }
            i++
            joe += i
            if (joe > B) {
                return "Mike"
            }
            i++
        }
    }
}