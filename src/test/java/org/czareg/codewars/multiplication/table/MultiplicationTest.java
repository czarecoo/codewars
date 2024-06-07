package org.czareg.codewars.multiplication.table;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MultiplicationTest {

    @DisplayName("n = 1")
    @Test
    void test1() {
        int[][] test1 = {{1}};
        assertArrayEquals(test1, Multiplication.multiplicationTable(1));
    }

    @DisplayName("n = 2")
    @Test
    void test2() {
        int[][] test2 = {{1, 2}, {2, 4}};
        assertArrayEquals(test2, Multiplication.multiplicationTable(2));
    }

    @DisplayName("n = 3")
    @Test
    void test3() {
        int[][] test3 = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertArrayEquals(test3, Multiplication.multiplicationTable(3));
    }

    @DisplayName("n = 4")
    @Test
    void test4() {
        int[][] test4 = {{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        assertArrayEquals(test4, Multiplication.multiplicationTable(4));
    }

    @DisplayName("n = 5")
    @Test
    void test5() {
        int[][] test5 = {{1, 2, 3, 4, 5}, {2, 4, 6, 8, 10}, {3, 6, 9, 12, 15}, {4, 8, 12, 16, 20}, {5, 10, 15, 20, 25}};
        assertArrayEquals(test5, Multiplication.multiplicationTable(5));
    }

    @DisplayName("Random Tests")
    @Test
    void randomtests() {
        Random rnd = ThreadLocalRandom.current();
        for (int run = 0; run < 20; run++) {
            int size = rnd.nextInt(1, 100);
            int[][] expected = solution(size);
            assertArrayEquals(expected, Multiplication.multiplicationTable(size), "n = " + size);
        }
    }

    private static int[][] solution(int size) {
        return IntStream.rangeClosed(1, size)
                .mapToObj(i -> IntStream.rangeClosed(1, size)
                        .map(j -> i * j)
                        .toArray())
                .toArray(int[][]::new);
    }
}