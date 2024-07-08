package org.czareg.codewars.count.the.digit

import org.junit.jupiter.api.Test

class DigitCounterTest {

    @Test
    void basicTests() {
        assert DigitCounter.nbDig(10, 1) == 4
        assert DigitCounter.nbDig(25, 1) == 11
        assert DigitCounter.nbDig(5750, 0) == 4700
        assert DigitCounter.nbDig(11011, 2) == 9481
        assert DigitCounter.nbDig(12224, 8) == 7733
        assert DigitCounter.nbDig(11549, 1) == 11905
        assert DigitCounter.nbDig(14550, 7) == 8014
        assert DigitCounter.nbDig(8304, 7) == 3927
        assert DigitCounter.nbDig(10576, 9) == 7860
        assert DigitCounter.nbDig(12526, 1) == 13558
        assert DigitCounter.nbDig(7856, 4) == 7132
        assert DigitCounter.nbDig(14956, 1) == 17267
    }

    private def r = new Random()

    private rand(int a, int b) { r.nextInt(b - a + 1) + a }

    private static solution(int n, int d) { (0..n).sum { (it * it).toString().count(d.toString()) } }

    @Test
    void randomTests() {
        100.times {
            def n = rand(2000, 15000)
            def d = rand(0, 9)
            assert DigitCounter.nbDig(n, d) == solution(n, d)
        }
    }
}