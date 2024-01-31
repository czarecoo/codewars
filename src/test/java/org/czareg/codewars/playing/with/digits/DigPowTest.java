package org.czareg.codewars.playing.with.digits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigPowTest {

    @Test
    void test1() {
        assertEquals(1, DigPow.digPow(89, 1));
    }

    @Test
    void test2() {
        assertEquals(-1, DigPow.digPow(92, 1));
    }

    @Test
    void test3() {
        assertEquals(51, DigPow.digPow(46288, 3));
    }

    @Test
    void test4() {
        assertEquals(9, DigPow.digPow(114, 3));
    }

    @Test
    void test5() {
        assertEquals(-1, DigPow.digPow(46288, 5));
    }

    @Test
    void test6() {
        assertEquals(1, DigPow.digPow(135, 1));
    }

    @Test
    void test7() {
        assertEquals(1, DigPow.digPow(175, 1));
    }

    @Test
    void test8() {
        assertEquals(1, DigPow.digPow(518, 1));
    }

    @Test
    void test9() {
        assertEquals(1, DigPow.digPow(63761, 3));
    }

    @Test
    void test10() {
        assertEquals(1, DigPow.digPow(598, 1));
    }

    @Test
    void test11() {
        assertEquals(1, DigPow.digPow(1306, 1));
    }

    @Test
    void test12() {
        assertEquals(1, DigPow.digPow(2427, 1));
    }

    @Test
    void test13() {
        assertEquals(1, DigPow.digPow(2646798, 1));
    }

    @Test
    void test14() {
        assertEquals(-1, DigPow.digPow(3456789, 1));
    }

    @Test
    void test15() {
        assertEquals(-1, DigPow.digPow(3456789, 5));
    }

    @Test
    void test16() {
        assertEquals(3, DigPow.digPow(198, 1));
    }

    @Test
    void test17() {
        assertEquals(3, DigPow.digPow(249, 1));
    }

    @Test
    void test18() {
        assertEquals(2, DigPow.digPow(1377, 1));
    }

    @Test
    void test19() {
        assertEquals(1, DigPow.digPow(1676, 1));
    }

    @Test
    void test20() {
        assertEquals(2, DigPow.digPow(695, 2));
    }

    @Test
    void test21() {
        assertEquals(19, DigPow.digPow(1878, 2));
    }

    @Test
    void test22() {
        assertEquals(5, DigPow.digPow(7388, 2));
    }

    @Test
    void test23() {
        assertEquals(1, DigPow.digPow(47016, 2));
    }

    @Test
    void test24() {
        assertEquals(1, DigPow.digPow(542186, 2));
    }

    @Test
    void test25() {
        assertEquals(5, DigPow.digPow(261, 3));
    }

    @Test
    void test26() {
        assertEquals(35, DigPow.digPow(1385, 3));
    }

    @Test
    void test27() {
        assertEquals(66, DigPow.digPow(2697, 3));
    }

    @Test
    void test28() {
        assertEquals(10, DigPow.digPow(6376, 3));
    }

    @Test
    void test29() {
        assertEquals(1, DigPow.digPow(6714, 3));
    }

    @Test
    void test30() {
        assertEquals(1, DigPow.digPow(63760, 3));
    }

    @Test
    void test31() {
        assertEquals(4, DigPow.digPow(132921, 3));
    }

    @Test
    void test32() {
        assertEquals(12933, DigPow.digPow(10383, 6));
    }
}