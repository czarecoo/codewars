package org.czareg.codewars.odder.than.the.rest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OddIndexFinderTest {

    @DisplayName("Fixed Tests")
    @Order(1)
    @ParameterizedTest(name = "arr = {0}")
    @MethodSource("argsFixed")
    void fixedTests(int[] testCase, int expected) {
        int actual = OddIndexFinder.oddOne(testCase.clone());
        assertEquals(expected, actual, getErrorMsg(expected, actual, testCase));
    }

    @DisplayName("Random Tests")
    @Order(2)
    @Test
    void randomTests() {
        final int NUM_TESTCASES = 50;
        final int MIN_VAL = -100, MAX_VAL = 100;
        final int MIN_SIZE = 1, MAX_SIZE = 100;
        Random rand = ThreadLocalRandom.current();
        int trueCount = rand.nextInt(NUM_TESTCASES / 4, 3 * NUM_TESTCASES / 4);
        List<Boolean> existsOdds = Stream.concat(
                Stream.generate(() -> true).limit(trueCount),
                Stream.generate(() -> false).limit(NUM_TESTCASES - trueCount)
        ).collect(Collectors.toList());
        Collections.shuffle(existsOdds);
        for (boolean existsOdd : existsOdds) {
            int size = rand.nextInt(MIN_SIZE, MAX_SIZE + 1);
            int expected = -1;
            int[] testCase = rand.ints(MIN_VAL, MAX_VAL).limit(size).map(i -> i << 1).toArray();
            if (existsOdd) {
                expected = rand.nextInt(0, size);
                testCase[expected] += 1;
            }
            int actual = OddIndexFinder.oddOne(testCase.clone());
            assertEquals(expected, actual, getErrorMsg(expected, actual, testCase));
        }
    }

    private static Stream<Arguments> argsFixed() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 6, 7, 10}, 3),
                Arguments.of(new int[]{2, 16, 98, 10, 13, 78}, 4),
                Arguments.of(new int[]{4, -8, 98, -12, -7, 90, 100}, 4),
                Arguments.of(new int[]{2, 4, 6, 8}, -1),
                Arguments.of(new int[]{2, 12, 0, -12, 24, -2}, -1)
        );
    }

    private String getErrorMsg(int expected, int actual, int[] values) {
        String arrayString = Arrays.toString(values);
        String[] elems = arrayString.substring(1, arrayString.length() - 1).split(",");
        if (expected != -1)
            elems[expected] = "[" + elems[expected] + "]";
        return String.format("Expected %d but got %d in {%s}", expected, actual, String.join(",", elems));
    }
}