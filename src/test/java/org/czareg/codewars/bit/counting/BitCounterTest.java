package org.czareg.codewars.bit.counting;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitCounterTest {

    @Test
    void testGame() {
        assertEquals(0, BitCounter.count(0));
        assertEquals(5, BitCounter.count(1234));
        assertEquals(1, BitCounter.count(4));
        assertEquals(3, BitCounter.count(7));
        assertEquals(3, BitCounter.count(26));
        assertEquals(2, BitCounter.count(9));
        assertEquals(2, BitCounter.count(10));
        assertEquals(14, BitCounter.count(77231418));
        assertEquals(11, BitCounter.count(12525589));
        assertEquals(8, BitCounter.count(3811));
        assertEquals(17, BitCounter.count(392902058));
        assertEquals(3, BitCounter.count(1044));
        assertEquals(10, BitCounter.count(10030245));
        assertEquals(16, BitCounter.count(183337941));
        assertEquals(14, BitCounter.count(20478766));
        assertEquals(9, BitCounter.count(103021));
        assertEquals(6, BitCounter.count(287));
        assertEquals(15, BitCounter.count(115370965));
        assertEquals(5, BitCounter.count(31));
        assertEquals(7, BitCounter.count(417862));
        assertEquals(12, BitCounter.count(626031));
        assertEquals(4, BitCounter.count(89));
        assertEquals(10, BitCounter.count(674259));
    }

    @Test
    void randomTests() {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int n = r.nextInt(100_000_000);
            assertEquals(Integer.bitCount(n), BitCounter.count(n));
        }
    }
}