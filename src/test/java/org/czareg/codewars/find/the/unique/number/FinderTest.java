package org.czareg.codewars.find.the.unique.number;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinderTest {

    private static final double PRECISION = 0.0000000000001;

    @Test
    void sampleTestCases() {
        assertEquals(1.0, Finder.findUniq(new double[]{0, 1, 0}), PRECISION);
        assertEquals(2.0, Finder.findUniq(new double[]{1, 1, 1, 2, 1, 1}), PRECISION);
    }

    @Test
    void test2() {
        // Basic tests (shuffled)
        assertEquals(3, Finder.findUniq(new double[]{4, 4, 4, 3, 4, 4, 4, 4}), PRECISION);
        assertEquals(4, Finder.findUniq(new double[]{5, 5, 5, 5, 4, 5, 5, 5}), PRECISION);
        assertEquals(5, Finder.findUniq(new double[]{6, 6, 6, 6, 6, 5, 6, 6}), PRECISION);
        assertEquals(6, Finder.findUniq(new double[]{7, 7, 7, 7, 7, 7, 6, 7}), PRECISION);
        // The last item
        assertEquals(7, Finder.findUniq(new double[]{8, 8, 8, 8, 8, 8, 8, 7}), PRECISION);
        assertEquals(2, Finder.findUniq(new double[]{3, 3, 2, 3, 3, 3, 3, 3}), PRECISION);
        assertEquals(1, Finder.findUniq(new double[]{2, 1, 2, 2, 2, 2, 2, 2}), PRECISION);
        // The first item
        assertEquals(0, Finder.findUniq(new double[]{0, 1, 1, 1, 1, 1, 1, 1}), PRECISION);
    }

    @Test
    void test3() {
        // Very big number
        assertEquals(
                Math.pow(2, 40),
                Finder.findUniq(generateTestArr(Math.pow(2, 40), Math.pow(2, 50), 100)),
                PRECISION
        );
        // Negative number
        assertEquals(
                -1,
                Finder.findUniq(generateTestArr(-1, 1, 1000)),
                PRECISION
        );
        // Float number
        assertEquals(
                0.0000001,
                Finder.findUniq(generateTestArr(0.0000001, 0.0010001, 1000)),
                PRECISION
        );
        // The first item but with random numbers
        Random rand = new Random();
        int number1 = rand.nextInt(100);
        int number2 = rand.nextInt(100);
        while (number1 == number2) {
            number2 = rand.nextInt(100);
        }
        assertEquals(number1, Finder.findUniq(new double[]{number1, number2, number2, number2, number2, number2, number2, number2}), PRECISION);
        // Very big array
        assertEquals(
                42,
                Finder.findUniq(generateTestArr(42, 24, Integer.MAX_VALUE / 100)),
                PRECISION
        );
    }

    static double[] generateTestArr(double answer, double mass, int length) {
        Random rand = new Random();
        int answerIndex = rand.nextInt(length);
        double[] arr = new double[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i == answerIndex ? answer : mass;
        }
        return arr;
    }
}