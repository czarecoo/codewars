package org.czareg.codewars.find.the.parity.outlier;

import org.junit.jupiter.api.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FindOutlierTest {

    @Test
    @DisplayName("Fixed tests")
    @Order(1)
    void fixedTests() {
        int[] ints1 = {2, 6, 8, 10, 3};
        int[] ints2 = {2, 6, 8, 200, 700, 1, 84, 10, 4};
        int[] ints3 = {17, 6, 8, 10, 6, 12, 24, 36};
        int[] ints4 = {2, 1, 7, 17, 19, 211, 7};
        int[] ints5 = {1, 1, 1, 1, 1, 44, 7, 7, 7, 7, 7, 7, 7, 7};
        int[] ints6 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 35, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 7, 7, 7, 1000};
        int[] ints7 = {2, -6, 8, -10, -3};
        int[] ints8 = {2, 6, 8, 2, -66, 34, -35, 66, 700, 1002, -84, 10, 4};
        int[] ints9 = {-1 * Integer.MAX_VALUE, -18, 6, -8, -10, 6, 12, -24, 36};
        int[] ints10 = {-20, 1, 7, 17, 19, 211, 7};
        int[] ints11 = {1, 1, -1, 1, 1, -44, 7, 7, 7, 7, 7, 7, 7, 7};
        int[] ints12 = {1, 0, 0};
        int[] ints13 = {3, 7, -99, 81, 90211, 0, 7};
        int[] ints14 = {-5, -6, -7, -3, -11, -3, -9};

        assertEquals(3, FindOutlier.find(ints1));
        assertEquals(1, FindOutlier.find(ints2));
        assertEquals(17, FindOutlier.find(ints3));
        assertEquals(2, FindOutlier.find(ints4));
        assertEquals(44, FindOutlier.find(ints5));
        assertEquals(1000, FindOutlier.find(ints6));
        assertEquals(-3, FindOutlier.find(ints7));
        assertEquals(-35, FindOutlier.find(ints8));
        assertEquals(-1 * Integer.MAX_VALUE, FindOutlier.find(ints9));
        assertEquals(-20, FindOutlier.find(ints10));
        assertEquals(-44, FindOutlier.find(ints11));
        assertEquals(1, FindOutlier.find(ints12));
        assertEquals(0, FindOutlier.find(ints13));
        assertEquals(-6, FindOutlier.find(ints14));
    }

    @Test
    @DisplayName("Small random tests")
    @Order(2)
    void randomTests1() {
        for (int run = 0; run < 50; ++run)
            randomTest(50, 3, 10);
    }

    @Test
    @DisplayName("Medium random tests")
    @Order(3)
    void randomTests2() {
        for (int run = 0; run < 30; ++run)
            randomTest(50000, 300, 400);
    }

    @Test
    @DisplayName("Big random tests")
    @Order(4)
    void randomTests3() {
        for (int run = 0; run < 10; ++run) {
            randomTest(5_000_000, 9_000_000, 10_000_000);
        }
    }

    private void randomTest(int valueRange, int minSize, int maxSize) {
        var rnd = ThreadLocalRandom.current();
        int parity = rnd.nextBoolean() ? 1 : 0;
        var input = IntStream.generate(() -> 2 * rnd.nextInt(-valueRange, valueRange) + parity).limit(rnd.nextLong(minSize, maxSize)).toArray();
        int expected = 2 * rnd.nextInt(-valueRange, valueRange) + 1 + parity;
        input[rnd.nextInt(input.length)] = expected;
        assertEquals(expected, FindOutlier.find(input));
    }
}