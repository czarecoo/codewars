package org.czareg.codewars.sum.of.angles

import org.junit.jupiter.api.Test

class AnglerTest {

    @Test
    void "Fixed Tests"() {
        assert Angler.angle(3) == 180
        assert Angler.angle(4) == 360
    }

    @Test
    void "Random Tests"() {
        def rnd = new Random()
        def ri
        (1..100).each { _ ->
            ri = 3 + rnd.nextInt(100)
            assert Angler.angle(ri) == solution(ri)
        }
    }

    private static def solution(n) {
        (n - 2) * 180
    }
}