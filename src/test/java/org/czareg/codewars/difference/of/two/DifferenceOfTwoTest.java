package org.czareg.codewars.difference.of.two;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DifferenceOfTwoTest {

    @Test
    void fixedTests() {
        assertArrayEquals(
                new int[][]{{1, 3}, {2, 4}},
                DifferenceOfTwo.twosDifference(new int[]{1, 2, 3, 4})
        );

        assertArrayEquals(
                new int[][]{{1, 3}, {4, 6}},
                DifferenceOfTwo.twosDifference(new int[]{1, 3, 4, 6})
        );

        assertArrayEquals(
                new int[][]{{1, 3}},
                DifferenceOfTwo.twosDifference(new int[]{0, 3, 1, 4})
        );

        assertArrayEquals(
                new int[][]{{1, 3}, {2, 4}},
                DifferenceOfTwo.twosDifference(new int[]{4, 1, 2, 3})
        );

        assertArrayEquals(
                new int[][]{{1, 3}, {3, 5}, {4, 6}},
                DifferenceOfTwo.twosDifference(new int[]{6, 3, 4, 1, 5})
        );

        assertArrayEquals(
                new int[][]{{1, 3}, {4, 6}},
                DifferenceOfTwo.twosDifference(new int[]{3, 1, 6, 4})
        );

        assertArrayEquals(
                new int[][]{{1, 3}, {3, 5}, {6, 8}, {8, 10}, {10, 12}, {12, 14}},
                DifferenceOfTwo.twosDifference(new int[]{1, 3, 5, 6, 8, 10, 15, 32, 12, 14, 56})
        );
    }

    @Test
    void randomTests() {
        var base = new int[1001];
        for (int i = 0; i <= 1000; i++) {
            base[i] = i;
        }
        for (int i = 0; i < 100; i++) {
            shuffle(base);
            var a = Arrays.copyOfRange(base, 0, rand.nextInt(201));
            var result = solution(a);
            assertArrayEquals(result, DifferenceOfTwo.twosDifference(a));
        }
    }

    static private final Random rand = new Random();

    private static void shuffle(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1), temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
    }

    private static int[][] solution(int[] a) {
        var s = Arrays.stream(a).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).boxed().filter(x -> s.contains(x + 2)).sorted().map(x -> new int[]{x, x + 2}).toArray(int[][]::new);
    }
}