package org.czareg.codewars.longest.mountain.pass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestMountainPassCalculatorTest {

    @Test
    void basicTests() {
        assertEquals(new Result(10, 0), LongestMountainPassCalculator.calculate(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 3}, 1));
        assertEquals(new Result(7, 0), LongestMountainPassCalculator.calculate(new int[]{9, 1, 2, 3, 4, 5, 6, 9}, 7));
        assertEquals(new Result(9, 1), LongestMountainPassCalculator.calculate(new int[]{1, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 7));
    }

    @Test
    void edgeCaseTests() {
        assertEquals(new Result(0, 0), LongestMountainPassCalculator.calculate(new int[]{}, 0));
        assertEquals(new Result(3, 0), LongestMountainPassCalculator.calculate(new int[]{10, 10, 10}, 0));
        assertEquals(new Result(1, 0), LongestMountainPassCalculator.calculate(new int[]{1, 2, 3, 4, 5}, 0));
    }
}