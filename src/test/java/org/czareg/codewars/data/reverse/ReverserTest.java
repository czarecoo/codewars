package org.czareg.codewars.data.reverse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverserTest {

    @Test
    void fixedTests() {
        doTest(
                new int[]{0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0},
                new int[]{1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1}
        );
        doTest(
                new int[]{1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
        );
        doTest(new int[0], new int[0]);
        doTest(new int[]{1, 0, 1, 0, 0, 1, 0, 1}, new int[]{1, 0, 1, 0, 0, 1, 0, 1});
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 100; i++) {
            int[][] arrays = genBytes();
            doTest(arrays[0], arrays[1]);
        }
    }

    private static final Random RANDOM = new Random();

    private static int[][] genBytes() {
        final int n = RANDOM.nextInt(0, 10);
        int[] array = new int[n * 8], reversed = new int[n * 8];

        for (int byteNo = 0; byteNo < n; byteNo++) {
            int left = byteNo * 8, right = 8 * (n - 1 - byteNo);
            for (int bitNo = 0; bitNo < 8; bitNo++)
                array[left + bitNo] = reversed[right + bitNo] = RANDOM.nextInt(0, 2);
        }
        return new int[][]{array, reversed};
    }

    private static void doTest(int[] input, int[] expected) {
        assertArrayEquals(expected, Reverser.dataReverse(input), () -> "for input = %s%n".formatted(Arrays.toString(input)));
    }
}