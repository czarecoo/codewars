package org.czareg.codewars.possibilities.arr;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class PossibilitiesArrayTest {

    public static int[][] randomTestCases = new int[][]{
            {3, 2, 10, 4, 1, 6, 9}, {0, 1, 3, -2, 5, 4}, {3, 2, 10, 4, 1, 6}, {6, 2, 4, 2, 2, 2, 1, 5, 0, 0}, {6, 2, 4, 2, 2, 2, 1, 5, 0, -100}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, -2, -1}, {-6, -3, -3, 8, -5, -4},
            {-6, -3, -3, 8, -10, -4}, {3, 1, 2, 4, 0}, {0, 1}, {1, 1, 8, 3, 1, 1}, {9, 0, 6}, {1, 1, 15, -1, -1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {6, 2, 4, 2, 2, 2, 1, 5, 0, 0, -12, 13, -5, 4, 6}, {-2, 5, 0, 5, 12}, {2}, {0}, {1, 3, 9, 8}, {}, {1, 2, 3, 4, 0}, {6, 2, 4, 2, 2, 2, 1, 5, 0, 0, -12, 13, -5, 4, 1}, {25}, {1, 2, 0, 4, 3}
    };

    // Reference implementation for random tests
    public static boolean _isAllPossibilities(int[] arg) {
        return arg.length > 0 && IntStream
                .range(0, arg.length)
                .allMatch(x ->
                        IntStream.of(arg).boxed().toList().contains(x));
    }

    @Test
    void simpleTests() {
        assertTrue(PossibilitiesArray.isAllPossibilities(new int[]{0, 1, 2, 3}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{1, 2, 3, 4}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{6, 0, 4}));
    }

    @Test
    void randomTests() {
        for (int i = 100; i > 0; i--) {
            int[] test = randomTestCases[(int) (Math.random() * randomTestCases.length)];
            boolean expected = _isAllPossibilities(test);
            boolean actual = PossibilitiesArray.isAllPossibilities(test);

            assertEquals(expected, actual);
        }
    }

    @Test
    void edgeCases() {
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{0, 2, 19, 4, 4}));
        assertTrue(PossibilitiesArray.isAllPossibilities(new int[]{3, 2, 1, 0}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{3, 2, 10, 4, 1, 6}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{1, 1, 8, 3, 1, 1}));
        assertTrue(PossibilitiesArray.isAllPossibilities(new int[]{0, 1, 2, 3}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{1, 2, 3, 4}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{0, -1, 2, 3}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{0, 2, 3}));
        assertTrue(PossibilitiesArray.isAllPossibilities(new int[]{0}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{}));
        assertTrue(PossibilitiesArray.isAllPossibilities(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{0, 1, 3, -2, 5, 4}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{0, -1, -2, -3, 4}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{1, -1, 3}));
        assertFalse(PossibilitiesArray.isAllPossibilities(new int[]{1, -1, 2, -2, 3, -3, 6}));
    }
}