package org.czareg.codewars.odd.march.bits.eight.bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitMarchArrayTest {

    @Test
    void test1() {
        int[][] bits = {
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}

        };
        int[][] chosenBits = BitMarchArray.bitMarch(1);
        assertNotNull(chosenBits);
        assertEquals(8, chosenBits.length);
        assertEquals(1, chosenBits[5][2]);
        assertNotEquals(chosenBits[0], chosenBits[1]);
        assertNotEquals(chosenBits[4], chosenBits[6]);
        assertNotNull(chosenBits);
        assert2DArraysEquals(bits, chosenBits);
    }

    @Test
    void test2() {
        int[][] bits = {
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0},

        };
        int[][] chosenBits = BitMarchArray.bitMarch(2);
        assertNotNull(chosenBits);
        assertEquals(7, chosenBits.length);
        assertEquals(1, chosenBits[0][7]);
        assertNotEquals(chosenBits[0], chosenBits[1]);
        assertNotEquals(chosenBits[4], chosenBits[6]);
        assertNotNull(chosenBits);
        assert2DArraysEquals(bits, chosenBits);

    }

    @Test
    void test3() {
        int[][] bits = {
                {0, 0, 0, 0, 0, 1, 1, 1,},
                {0, 0, 0, 0, 1, 1, 1, 0,},
                {0, 0, 0, 1, 1, 1, 0, 0,},
                {0, 0, 1, 1, 1, 0, 0, 0,},
                {0, 1, 1, 1, 0, 0, 0, 0,},
                {1, 1, 1, 0, 0, 0, 0, 0,},

        };
        int[][] chosenBits = BitMarchArray.bitMarch(3);
        assertNotNull(chosenBits);
        assertEquals(6, chosenBits.length);
        assertEquals(1, chosenBits[3][2]);
        assertNotEquals(chosenBits[0], chosenBits[1]);
        assertNotEquals(chosenBits[4], chosenBits[5]);
        assertNotNull(chosenBits);
        assert2DArraysEquals(bits, chosenBits);
    }

    @Test
    void test4() {
        int[][] bits = {
                {0, 0, 0, 0, 1, 1, 1, 1,},
                {0, 0, 0, 1, 1, 1, 1, 0,},
                {0, 0, 1, 1, 1, 1, 0, 0,},
                {0, 1, 1, 1, 1, 0, 0, 0,},
                {1, 1, 1, 1, 0, 0, 0, 0,},

        };
        int[][] chosenBits = BitMarchArray.bitMarch(4);
        assertNotNull(chosenBits);
        assertEquals(5, chosenBits.length);
        assertEquals(1, chosenBits[2][4]);
        assertNotEquals(chosenBits[0], chosenBits[1]);
        assertNotEquals(chosenBits[4], chosenBits[3]);
        assertNotNull(chosenBits);
        assert2DArraysEquals(bits, chosenBits);
    }

    @Test
    void test5() {
        int[][] bits = {
                {0, 0, 0, 1, 1, 1, 1, 1,},
                {0, 0, 1, 1, 1, 1, 1, 0,},
                {0, 1, 1, 1, 1, 1, 0, 0,},
                {1, 1, 1, 1, 1, 0, 0, 0,},

        };
        int[][] chosenBits = BitMarchArray.bitMarch(5);
        assertNotNull(chosenBits);
        assertEquals(4, chosenBits.length);
        assertEquals(0, chosenBits[2][7]);
        assertNotEquals(chosenBits[0], chosenBits[1]);
        assertNotEquals(chosenBits[2], chosenBits[3]);
        assertNotNull(chosenBits);
        assert2DArraysEquals(bits, chosenBits);
    }

    @Test
    void test6() {
        int[][] bits = {
                {0, 0, 1, 1, 1, 1, 1, 1,},
                {0, 1, 1, 1, 1, 1, 1, 0,},
                {1, 1, 1, 1, 1, 1, 0, 0,},

        };
        int[][] chosenBits = BitMarchArray.bitMarch(6);
        assertNotNull(chosenBits);
        assertEquals(3, chosenBits.length);
        assertEquals(0, chosenBits[2][7]);
        assertNotEquals(chosenBits[0], chosenBits[1]);
        assertNotEquals(chosenBits[2], chosenBits[1]);
        assertNotNull(chosenBits);
        assert2DArraysEquals(bits, chosenBits);
    }

    @Test
    void test7() {
        int[][] bits = {
                {0, 1, 1, 1, 1, 1, 1, 1,},
                {1, 1, 1, 1, 1, 1, 1, 0,},
        };
        int[][] chosenBits = BitMarchArray.bitMarch(7);
        assertNotNull(chosenBits);
        assertEquals(2, chosenBits.length);
        assertEquals(0, chosenBits[1][7]);
        assertNotEquals(chosenBits[0], chosenBits[1]);
        assertNotNull(chosenBits);
        assert2DArraysEquals(bits, chosenBits);
    }

    @Test
    void test8() {
        int[][] bits = {
                {1, 1, 1, 1, 1, 1, 1, 1,},
        };
        int[][] chosenBits = BitMarchArray.bitMarch(8);
        assertNotNull(chosenBits);
        assertEquals(1, chosenBits.length);
        assertEquals(1, chosenBits[0][7]);
        assertNotNull(chosenBits);
        assert2DArraysEquals(bits, chosenBits);
    }

    private void assert2DArraysEquals(int[][] expected, int[][] actual) {
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }
}