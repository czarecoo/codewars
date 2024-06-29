package org.czareg.codewars.sum.of.positives

import org.junit.jupiter.api.Test

class PositivesSumTest {

    @Test
    void "works for some examples"() {
        assert PositivesSum.positiveSum([1, 2, 3, 4, 5]) == 15
        assert PositivesSum.positiveSum([1, -2, 3, 4, 5]) == 13
        assert PositivesSum.positiveSum([-1, 2, 3, 4, -5]) == 9
    }

    @Test
    void "returns 0 when list is empty"() {
        assert PositivesSum.positiveSum([]) == 0
    }

    @Test
    void "returns 0 when all elements are negative"() {
        assert PositivesSum.positiveSum([-1, -2, -3, -4, -5]) == 0
    }

    @Test
    void "works for random arrays"() {
        def sol = { it.findAll { it > 0 }.sum() }
        def rand = new Random()
        40.times {
            def a = (1..rand.nextInt(115) + 5).collect { rand.nextInt(200) - 100 }
            assert sol(a) == PositivesSum.positiveSum(a)
        }
    }
}
