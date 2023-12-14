package org.czareg.codewars.narcissistic.num;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class NarcissisticNumberCheckerTest {

    private static final int[] NARCISSISTIC_NUMBERS = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634,
            8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818,
            9800817, 9926315, 24678050, 24678051, 88593477, 146511208,
            472335975, 534494836, 912985153
    };

    @Test
    void fixedTests() {
        assertTrue(NarcissisticNumberChecker.isNarcissistic(153), "153 is narcissistic");
        assertTrue(NarcissisticNumberChecker.isNarcissistic(1634), "1634 is narcissistic");
        assertFalse(NarcissisticNumberChecker.isNarcissistic(112), "112 is not narcissistic");
        assertFalse(NarcissisticNumberChecker.isNarcissistic(10), "10 is not narcissistic");
        assertTrue(NarcissisticNumberChecker.isNarcissistic(912985153), "912985153 is narcissistic");
        assertFalse(NarcissisticNumberChecker.isNarcissistic(999999999), "999999999 is not narcissistic");
        assertFalse(NarcissisticNumberChecker.isNarcissistic(Integer.MAX_VALUE), Integer.MAX_VALUE + " is not narcissistic");
    }

    @Test
    void randomTests() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        int nrTests = 100_000;
        int[] testCases = Arrays.copyOf(NARCISSISTIC_NUMBERS, nrTests);
        for (int i = NARCISSISTIC_NUMBERS.length; i < nrTests; i++)
            testCases[i] = rnd.nextInt(Integer.MAX_VALUE);
        for (int i = 0; i < nrTests; i++) {
            int idx = rnd.nextInt(nrTests);
            int tmp = testCases[i];
            testCases[i] = testCases[idx];
            testCases[idx] = tmp;
        }

        for (int n : testCases) {
            boolean expected = Arrays.binarySearch(NARCISSISTIC_NUMBERS, n) >= 0;
            assertEquals(expected, NarcissisticNumberChecker.isNarcissistic(n), String.format("%d is %s narcissistic", n, expected ? "" : "not "));
        }
    }
}