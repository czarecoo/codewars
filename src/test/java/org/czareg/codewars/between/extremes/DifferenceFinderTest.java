package org.czareg.codewars.between.extremes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferenceFinderTest {

    @Test
    void fixedTest() {
        assertEquals(42, DifferenceFinder.betweenExtremes(new int[]{21, 34, 54, 43, 26, 12}));
        assertEquals(99, DifferenceFinder.betweenExtremes(new int[]{-1, -41, -77, -100}));
    }

    private static final Random rnd = new Random();

    @Test
    void randomTest() {
        for (int i = 0; i < 100; ++i) {
            int[] numbers = generateArray(rnd.nextInt(100) + 2);
            assertEquals(solution(numbers),
                    DifferenceFinder.betweenExtremes(numbers));
        }
    }

    private static int solution(int[] numbers) {
        return Arrays.stream(numbers).max().getAsInt() - Arrays.stream(numbers).min().getAsInt();
    }

    private static int[] generateArray(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; ++i) {
            numbers[i] = rnd.nextInt(1000) - 500 + 1;
        }
        return numbers;
    }
}