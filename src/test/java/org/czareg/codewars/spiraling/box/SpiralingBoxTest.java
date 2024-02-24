package org.czareg.codewars.spiraling.box;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static java.lang.Math.min;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpiralingBoxTest {

    @Test
    void fixedTests() {
        final int[][] box_5_8 = {{1, 1, 1, 1, 1}, {1, 2, 2, 2, 1}, {1, 2, 3, 2, 1},
                {1, 2, 3, 2, 1}, {1, 2, 3, 2, 1}, {1, 2, 3, 2, 1},
                {1, 2, 2, 2, 1}, {1, 1, 1, 1, 1}};
        assertArrayEquals(box_5_8, SpiralingBox.createBox(5, 8));

        final int[][] box_10_9 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 3, 3, 3, 3, 3, 3, 2, 1}, {1, 2, 3, 4, 4, 4, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 5, 4, 3, 2, 1}, {1, 2, 3, 4, 4, 4, 4, 3, 2, 1},
                {1, 2, 3, 3, 3, 3, 3, 3, 2, 1}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        assertArrayEquals(box_10_9, SpiralingBox.createBox(10, 9));

        final int[][] box_12_15 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1}, {1, 2, 3, 4, 4, 4, 4, 4, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 5, 5, 5, 4, 3, 2, 1}, {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1}, {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1}, {1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 5, 5, 5, 4, 3, 2, 1}, {1, 2, 3, 4, 4, 4, 4, 4, 4, 3, 2, 1},
                {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1}, {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        assertArrayEquals(box_12_15, SpiralingBox.createBox(12, 15));

        final int[][] box_21_11 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1},
                {1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 2, 1},
                {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        assertArrayEquals(box_21_11, SpiralingBox.createBox(21, 11));

        final int[][] box_19_19 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1},
                {1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 7, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 7, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 7, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4, 3, 2, 1},
                {1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 2, 1},
                {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        assertArrayEquals(box_19_19, SpiralingBox.createBox(19, 19));

        final int[][] box_2_20 = {{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1},
                {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1},
                {1, 1}, {1, 1}, {1, 1}, {1, 1}};
        assertArrayEquals(box_2_20, SpiralingBox.createBox(2, 20));

        final int[][] box_2_2 = {{1, 1}, {1, 1}};
        assertArrayEquals(box_2_2, SpiralingBox.createBox(2, 2));
    }

    @Test
    void edgeCases() {
        final int[][] box_1_6 = {{1}, {1}, {1}, {1}, {1}, {1}};
        final int[][] box_10_1 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        final int[][] box_1_1 = {{1}};

        assertArrayEquals(box_1_6, SpiralingBox.createBox(1, 6));
        assertArrayEquals(box_10_1, SpiralingBox.createBox(10, 1));
        assertArrayEquals(box_1_1, SpiralingBox.createBox(1, 1));
    }

    @Test
    public void randomTests() {

        final Random random = new Random();

        for (int i = 0; i < 50; i++) {
            final int m = random.nextInt(100) + 2;
            final int n = random.nextInt(100) + 2;
            final int[][] userSolution = SpiralingBox.createBox(m, n);
            assertTrue(verify(userSolution, m, n));
        }
    }

    private static boolean verify(int[][] box, int m, int n) {
        boolean valid = true;

        final int actualLength = box.length;
        final int actualWidth = box[0].length;

        if (actualLength != n) valid = false;
        else if (actualWidth != m) valid = false;
        else {
            for (int i = 0; i < actualLength; i++)
                for (int j = 0; j < actualWidth; j++) {
                    final int min1 = min(i + 1, actualLength - i);
                    final int min2 = min(j + 1, actualWidth - j);
                    final int min = min(min1, min2);
                    if (box[i][j] != min) valid = false;
                }
        }

        return valid;
    }
}