package org.czareg.codewars.simple.missing.sum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingSumFinderTest {

    private static final Random RANDOM = new Random();

    @Test
    void basicTests() {
        assertEquals(4, MissingSumFinder.solve(new int[]{1, 2, 8, 7}));
        assertEquals(7, MissingSumFinder.solve(new int[]{2, 12, 3, 1}));
        assertEquals(19, MissingSumFinder.solve(new int[]{4, 2, 8, 3, 1}));
        assertEquals(1, MissingSumFinder.solve(new int[]{4, 2, 12, 3}));
        assertEquals(8, MissingSumFinder.solve(new int[]{1, 2, 4}));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 200; i++) {
            int len = random(5, 50);
            int[] arr = new int[len];
            int t = random(0, 5);
            if (t > 0) {
                arr[1] = 1;
                arr[2] = 2;
                arr[0] = 4;
                if (random(0, 4) > 0) arr[3] = 8;
                if (random(0, 4) > 0) arr[4] = 16;
            }
            len = arr.length - 1;
            for (int j = len; j >= 0; j--) {
                arr[j] = random(2, 300);
            }
            int expected = solution(arr);
            assertEquals(expected, MissingSumFinder.solve(arr));
        }
    }

    private static int solution(int[] arr) {
        int t = 0;
        Arrays.sort(arr);
        for (int e : arr) {
            if (e > t + 1) break;
            t += e;
        }
        return t + 1;
    }

    private static int random(int start, int end) {
        return RANDOM.nextInt(end - start) + start;
    }
}