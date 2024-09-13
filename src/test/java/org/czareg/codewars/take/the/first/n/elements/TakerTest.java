package org.czareg.codewars.take.the.first.n.elements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TakerTest {

    @Test
    void basicTests() {
        assertArrayEquals(new int[]{}, Taker.take(new int[]{}, 0));
        assertArrayEquals(new int[]{}, Taker.take(new int[]{1, 2, 3}, 0));
        assertArrayEquals(new int[]{1}, Taker.take(new int[]{1, 2, 3}, 1));
        assertArrayEquals(new int[]{1, 2}, Taker.take(new int[]{1, 2, 3}, 2));
        assertArrayEquals(new int[]{1, 2, 3}, Taker.take(new int[]{1, 2, 3}, 3));
        assertArrayEquals(new int[]{0, 1, 2}, Taker.take(new int[]{0, 1, 2, 3, 5, 8, 13}, 3));
        assertArrayEquals(new int[0], Taker.take(new int[0], 3));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 100; i++) {
            int n = (int) Math.floor(100 * Math.random());
            int[] randomArray = generateRandomArray();
            assertArrayEquals(solution(randomArray, n), Taker.take(randomArray, n));
        }
    }

    private int[] generateRandomArray() {
        int length = (int) Math.floor(100 * Math.random());
        int min = (int) Math.floor(-100 * Math.random());
        int max = (int) Math.floor(100 * Math.random());
        return new Random().ints(length, min, max).toArray();
    }

    private int[] solution(int[] arr, int n) {
        return arr.length > 0 && arr.length > n ? Arrays.copyOfRange(arr, 0, n) : arr;
    }
}