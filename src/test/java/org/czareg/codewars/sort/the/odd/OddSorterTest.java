package org.czareg.codewars.sort.the.odd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OddSorterTest {

    @Test
    void exampleTest1() {
        assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4}, OddSorter.sortArray(new int[]{5, 3, 2, 8, 1, 4}));
    }

    @Test
    void exampleTest2() {
        assertArrayEquals(new int[]{1, 3, 5, 8, 0}, OddSorter.sortArray(new int[]{5, 3, 1, 8, 0}));
    }

    @Test
    void exampleTest3() {
        assertArrayEquals(new int[]{}, OddSorter.sortArray(new int[]{}));
    }

    @Test
    void extendedTest1() {
        assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4, 11}, OddSorter.sortArray(new int[]{5, 3, 2, 8, 1, 4, 11}));
    }

    @Test
    void extendedTest2() {
        assertArrayEquals(new int[]{2, 22, 1, 5, 4, 11, 37, 0}, OddSorter.sortArray(new int[]{2, 22, 37, 11, 4, 1, 5, 0}));
    }

    @Test
    void extendedTest3() {
        assertArrayEquals(new int[]{1, 1, 5, 11, 2, 11, 111, 0}, OddSorter.sortArray(new int[]{1, 111, 11, 11, 2, 1, 5, 0}));
    }

    @Test
    void extendedTest4() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, OddSorter.sortArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    @Test
    void extendedTest5() {
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, OddSorter.sortArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    void extendedTest6() {
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 8, 7, 6, 9}, OddSorter.sortArray(new int[]{0, 1, 2, 3, 4, 9, 8, 7, 6, 5}));
    }

    @Test
    void randomTests() {
        Random random = new Random();
        for (int t = 0; t < 10; ++t) {
            int oddCount = random.nextInt(20);
            int minInputSize = oddCount + random.nextInt(20);

            List<Integer> odds = new ArrayList<>(oddCount);
            for (int i = 0; i < oddCount; ++i) {
                odds.add(random.nextInt(100) / 2 * 2 + 1); // odd
            }

            List<Integer> sortedOdds = new ArrayList<>(odds);
            Collections.sort(sortedOdds);

            List<Integer> input = new ArrayList<>(minInputSize);
            List<Integer> solution = new ArrayList<>(minInputSize);

            while (!odds.isEmpty()) {
                if (random.nextBoolean()) {
                    input.add(odds.removeFirst());
                    solution.add(sortedOdds.removeFirst());
                } else {
                    int even = random.nextInt(50) * 2;
                    input.add(even);
                    solution.add(even);
                }
            }

            while (input.size() < minInputSize) {
                int even = random.nextInt(50) * 2;
                input.add(even);
                solution.add(even);
            }

            int[] expected = solution.stream().mapToInt(Integer::intValue).toArray();
            int[] actual = OddSorter.sortArray(input.stream().mapToInt(Integer::intValue).toArray());

            assertArrayEquals(expected, actual);
        }
    }
}