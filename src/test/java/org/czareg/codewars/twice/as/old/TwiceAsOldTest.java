package org.czareg.codewars.twice.as.old;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwiceAsOldTest {

    protected int localTwiceAsOld(int dadYears, int sonYears) {
        int difference = dadYears - sonYears * 2;
        if (difference > 0) {
            return difference;
        }
        return difference * -1;
    }

    @Test
    void fixedTests() {
        assertEquals(30, TwiceAsOld.calculate(30, 0));
        assertEquals(16, TwiceAsOld.calculate(30, 7));
        assertEquals(15, TwiceAsOld.calculate(45, 30));
        assertEquals(22, TwiceAsOld.calculate(36, 7));
        assertEquals(5, TwiceAsOld.calculate(55, 30));
        assertEquals(0, TwiceAsOld.calculate(42, 21));
        assertEquals(20, TwiceAsOld.calculate(22, 1));
        assertEquals(29, TwiceAsOld.calculate(29, 0));
    }

    @Test
    void randomTests() {
        Random rand = new Random();
        for (int i = 50; i > 0; i--) {
            int dad = rand.nextInt(82) + 18;
            int son = dad - (rand.nextInt(22) + 18);
            if (son < 0) {
                son = 0;
            }
            assertEquals(localTwiceAsOld(dad, son), TwiceAsOld.calculate(dad, son));
        }
    }
}