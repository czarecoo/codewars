package org.czareg.codewars.cat.years.dog.years;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AnimalYearsCalculatorTest {

    @Test
    void one() {
        assertArrayEquals(new int[]{1, 15, 15}, AnimalYearsCalculator.humanYearsCatYearsDogYears(1));
    }

    @Test
    void two() {
        assertArrayEquals(new int[]{2, 24, 24}, AnimalYearsCalculator.humanYearsCatYearsDogYears(2));
    }

    @Test
    void ten() {
        assertArrayEquals(new int[]{10, 56, 64}, AnimalYearsCalculator.humanYearsCatYearsDogYears(10));
    }

    private static class Solution {
        static int[] humanYearsCatYearsDogYears(final int h) {
            return new int[]{h, h == 1 ? 15 : h == 2 ? 24 : 24 + 4 * (h - 2), h == 1 ? 15 : h == 2 ? 24 : 24 + 5 * (h - 2)};
        }
    }

    @Test
    void random() {
        for (int r = 0; r < 100; r++) {
            final int humanYears = (int) (Math.random() * 25) + 1;
            final int[] expected = Solution.humanYearsCatYearsDogYears(humanYears);
            final int[] actual = AnimalYearsCalculator.humanYearsCatYearsDogYears(humanYears);
            assertArrayEquals(expected, actual);
        }
    }
}