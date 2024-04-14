package org.czareg.codewars.pyramid.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PyramidArrayTest {

    @Test
    void fixedTests() {
        test(-1, new int[][]{});
        test(0, new int[][]{});
        test(1, new int[][]{{1}});
        test(2, new int[][]{{1}, {1, 1}});
        test(3, new int[][]{{1}, {1, 1}, {1, 1, 1}});
    }

    @Test
    void randomTests() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int n = rnd.nextInt(20);
            test(n, solution(n));
        }
    }

    private void test(int n, int[][] expected) {
        int[][] actual = PyramidArray.pyramid(n);
        assertArrayEquals(expected, actual);
    }


    private static int[][] solution(int n) {
        int[][] p = new int[n][];
        for (int i = 0; i < n; i++) {
            p[i] = new int[i + 1];
            Arrays.fill(p[i], 1);
        }
        return p;
    }
}