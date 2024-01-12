package org.czareg.codewars.sum.without.highest.and.lowest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraysUtilTest {

    @Test
    void sumOnlyOneElement() {
        assertEquals(0, ArraysUtil.sum(new int[]{6}));
    }

    @Test
    void sumOnlyTwoElements() {
        assertEquals(0, ArraysUtil.sum(new int[]{6, 7}));
    }

    @Test
    void sumPositives() {
        assertEquals(16, ArraysUtil.sum(new int[]{6, 2, 1, 8, 10}));
    }

    @Test
    void sumPositivesWithDoubleMax() {
        assertEquals(17, ArraysUtil.sum(new int[]{6, 0, 1, 10, 10}));
    }

    @Test
    void sumNegatives() {
        assertEquals(-28, ArraysUtil.sum(new int[]{-6, -20, -1, -10, -12}));
    }

    @Test
    void sumMixed() {
        assertEquals(3, ArraysUtil.sum(new int[]{-6, 20, -1, 10, -12}));
    }

    @Test
    void sumEmptyArray() {
        assertEquals(0, ArraysUtil.sum(new int[0]));
    }

    @Test
    void sumNullArray() {
        assertEquals(0, ArraysUtil.sum(null));
    }

    @Test
    void sumRandom() {
        for (int r = 0; r < 20; r++) {
            int[] numbers = new int[6];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int) Math.floor(Math.random() * 1100 - 500);
            }

            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }

            int min = Arrays.stream(numbers).min().getAsInt();
            int max = Arrays.stream(numbers).max().getAsInt();

            int expected = sum - min - max;

            assertEquals(expected, ArraysUtil.sum(numbers));
        }
    }
}