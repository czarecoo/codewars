package org.czareg.codewars.continued.fraction;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FracterTest {

    @Test
    @Order(1)
    @DisplayName("Basic tests")
    void basicTests() {
        int[] numerators = new int[]{311, 761, 1721};
        int[] denominators = new int[]{144, 327, 9};
        int[][] expecteds = new int[][]{
                new int[]{2, 6, 3, 1, 5},
                new int[]{2, 3, 17, 1, 5},
                new int[]{191, 4, 2},
        };
        for (int i = 0; i < numerators.length; i++) {
            int[] actual = Fracter.continuedFraction(numerators[i], denominators[i]);
            String msg = String.format("Input : numerator=%s, denominator=%s. Actual %s should equal expected %s", numerators[i], denominators[i], Arrays.toString(actual), Arrays.toString(expecteds[i]));
            assertArrayEquals(expecteds[i], actual, msg);
        }
    }

    @Test
    @Order(1)
    @DisplayName("Tests for divisors")
    void divTests() {
        int[] numerators = new int[]{1089, 11011, 1173};
        int[] denominators = new int[]{9, 13, 17};
        int[][] expecteds = new int[][]{
                new int[]{121},
                new int[]{847},
                new int[]{69},
        };
        for (int i = 0; i < numerators.length; i++) {
            int[] actual = Fracter.continuedFraction(numerators[i], denominators[i]);
            String msg = String.format("Input : numerator=%s, denominator=%s. Actual %s should equal expected %s", numerators[i], denominators[i], Arrays.toString(actual), Arrays.toString(expecteds[i]));
            assertArrayEquals(expecteds[i], actual, msg);
        }
    }

    @Test
    @Order(1)
    @DisplayName("Test for zero")
    void zeroTest() {
        int[] actual = Fracter.continuedFraction(0, 15);
        String msg = String.format("Input : numerator=0, denominator=15. Actual %s should equal expected []", Arrays.toString(actual));
        assertArrayEquals(new int[0], actual, msg);
    }

    @Test
    @Order(2)
    @DisplayName("100 random tests")
    void randomTests() {
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            int numerator = random.nextInt(100 * i);
            int denominator = random.nextInt(100 * i) + 1;
            int[] expected = solution(numerator, denominator);
            int[] actual = Fracter.continuedFraction(numerator, denominator);
            String msg = String.format("Input : numerator=%s, denominator=%s. Actual %s should equal expected %s", numerator, denominator, Arrays.toString(actual), Arrays.toString(expected));
            assertArrayEquals(expected, actual, msg);
        }
    }

    public static int[] solution(int numerator, int denominator) {
        List<Integer> parts = new ArrayList<>();
        while (numerator != 0 && denominator != 0) {
            parts.add(numerator / denominator);
            int temp = denominator;
            denominator = numerator % temp;
            numerator = temp;
        }
        return parts.stream().mapToInt(i -> i).toArray();
    }
}