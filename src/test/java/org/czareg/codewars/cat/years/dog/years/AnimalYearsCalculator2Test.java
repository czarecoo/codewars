package org.czareg.codewars.cat.years.dog.years;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AnimalYearsCalculator2Test {

    @Test
    void zero() {
        assertArrayEquals(new int[]{0, 0}, AnimalYearsCalculator2.ownedCatAndDog(9, 7));
    }

    @Test
    void one() {
        assertArrayEquals(new int[]{1, 1}, AnimalYearsCalculator2.ownedCatAndDog(15, 15));
        assertArrayEquals(new int[]{1, 1}, AnimalYearsCalculator2.ownedCatAndDog(18, 21));
        assertArrayEquals(new int[]{1, 1}, AnimalYearsCalculator2.ownedCatAndDog(19, 17));
    }

    @Test
    void two() {
        assertArrayEquals(new int[]{2, 2}, AnimalYearsCalculator2.ownedCatAndDog(24, 24));
        assertArrayEquals(new int[]{2, 2}, AnimalYearsCalculator2.ownedCatAndDog(25, 25));
        assertArrayEquals(new int[]{2, 2}, AnimalYearsCalculator2.ownedCatAndDog(26, 26));
        assertArrayEquals(new int[]{2, 2}, AnimalYearsCalculator2.ownedCatAndDog(27, 27));
    }

    @Test
    void ten() {
        assertArrayEquals(new int[]{10, 10}, AnimalYearsCalculator2.ownedCatAndDog(56, 64));
    }

    private static class Solution {
        private static int[] ownedCatAndDog(final int catYears, final int dogYears) {
            final int ownedCat = catYears < 15 ? 0 : catYears < 24 ? 1 : 2 + (catYears - 24) / 4;
            final int ownedDog = dogYears < 15 ? 0 : dogYears < 24 ? 1 : 2 + (dogYears - 24) / 5;
            return new int[]{ownedCat, ownedDog};
        }
    }

    @Test
    void random() {
        for (int r = 0; r < 100; r++) {
            final int catYears = (int) (Math.random() * 100) + 1;
            final int dogYears = (int) (Math.random() * 100) + 1;
            final int[] expected = Solution.ownedCatAndDog(catYears, dogYears);
            final int[] actual = AnimalYearsCalculator2.ownedCatAndDog(catYears, dogYears);
            assertArrayEquals(expected, actual);
        }
    }
}