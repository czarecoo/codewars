package org.czareg.codewars.array.plus.array;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraysSumTest {

    @Test
    void sampleTests() {
        assertEquals(21, ArraysSum.arrayPlusArray(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        assertEquals(-21, ArraysSum.arrayPlusArray(new int[]{-1, -2, -3}, new int[]{-4, -5, -6}));
        assertEquals(15, ArraysSum.arrayPlusArray(new int[]{0, 0, 0}, new int[]{4, 5, 6}));
        assertEquals(2100, ArraysSum.arrayPlusArray(new int[]{100, 200, 300}, new int[]{400, 500, 600}));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 20; i++) {
            int[] arr1 = new int[5];
            int[] arr2 = new int[5];
            for (int j = 0; j < 5; j++) {
                arr1[j] = randomInt(-10000, 10000);
                arr2[j] = randomInt(-100, 100);
            }

            assertEquals(check(arr1, arr2), ArraysSum.arrayPlusArray(arr1, arr2));
        }
    }

    private int check(int[] arr1, int[] arr2) {
        return IntStream.of(arr1).sum() + IntStream.of(arr2).sum();
    }

    private int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}