package org.czareg.codewars.longest.mountain.pass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestMountainPassCalculatorTest {

    @Test
    void edgeCaseTests() {
        assertEquals(new Result(0, 0), LongestMountainPassCalculator.calculate(new int[]{}, 0));
        assertEquals(new Result(3, 0), LongestMountainPassCalculator.calculate(new int[]{10, 10, 10}, 0));
        assertEquals(new Result(1, 0), LongestMountainPassCalculator.calculate(new int[]{1, 2, 3, 4, 5}, 0));
    }

    @Test
    void basicTests() {
        assertEquals(new Result(10, 0), LongestMountainPassCalculator.calculate(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 3}, 1));
        assertEquals(new Result(7, 0), LongestMountainPassCalculator.calculate(new int[]{9, 1, 2, 3, 4, 5, 6, 9}, 7));
        assertEquals(new Result(9, 1), LongestMountainPassCalculator.calculate(new int[]{1, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 7));
    }

    @Test
    void fixedCases() {
        assertEquals(new Result(6, 0), LongestMountainPassCalculator.calculate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        assertEquals(new Result(10, 0), LongestMountainPassCalculator.calculate(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 100));
        assertEquals(new Result(10, 0), LongestMountainPassCalculator.calculate(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 0));
        assertEquals(new Result(8, 6), LongestMountainPassCalculator.calculate(new int[]{10, 9, 8, 7, 6, 5, 10, 9, 8, 7, 6, 5, 4, 3}, 4));
    }

    @Test
    void randomTests() {
        // Small random tests
        for (int i = 0; i < 50; i++) {
            var randomCase = LongestMountainPassCalculatorHelper.generateRandomTestCase((int) 1e4);
            var expected = LongestMountainPassCalculatorHelper.solution(randomCase.mountains, randomCase.E);
            assertEquals(expected, LongestMountainPassCalculator.calculate(randomCase.mountains, randomCase.E));
        }

        // Large random tests
        for (int i = 0; i < 3; i++) {
            var randomCase = LongestMountainPassCalculatorHelper.generateRandomTestCase((int) 1e7);
            var expected = LongestMountainPassCalculatorHelper.solution(randomCase.mountains, randomCase.E);
            assertEquals(expected, LongestMountainPassCalculator.calculate(randomCase.mountains, randomCase.E));
        }
    }
}

class LongestMountainPassCalculatorHelper {
    static class RandomCase {
        int[] mountains;
        int E;

        RandomCase(int[] mountains, int E) {
            this.mountains = mountains;
            this.E = E;
        }
    }

    public static Result solution(int[] mountains, int E) {
        int n = mountains.length;
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int startIdx = 0;
        int energy = E;

        while (right < n) {
            if (right > 0) {
                int requiredEnergy = Math.max(0, mountains[right] - mountains[right - 1]);
                while (energy < requiredEnergy) {
                    energy += Math.max(0, mountains[left + 1] - mountains[left]);
                    left += 1;
                }
                energy -= requiredEnergy;
            }

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIdx = left;
            }

            right += 1;
        }

        return new Result(maxLength, startIdx);
    }

    public static RandomCase generateRandomTestCase(int upperBound) {
        int n = (int) (Math.random() * (upperBound - 10) + 10); // Length of the mountain array
        int[] mountains = new int[n];
        for (int i = 0; i < n; i++) {
            mountains[i] = (int) (Math.random() * 1e6);
        }
        int E = (int) (Math.random() * (1e9 - 10) + 10); // Initial energy level
        return new RandomCase(mountains, E);
    }
}