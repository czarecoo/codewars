package org.czareg.codewars.frog.jumping;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrogJumpingTest {

    @ParameterizedTest
    @MethodSource("data")
    void should_test_solution(int[] input, int expected) {
        assertEquals(expected, FrogJumping.solution(input));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, -1}, 4),
                Arguments.of(new int[]{1, 2, 1, 5}, 3),
                Arguments.of(new int[]{1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1}, 9),
                Arguments.of(new int[]{1, 2, 3, 1, -2, 1}, 6),
                Arguments.of(new int[]{1, 1, 1, 1}, 4),
                Arguments.of(new int[]{-1, -1, -2}, 1),
                Arguments.of(new int[]{-3}, 1),
                Arguments.of(new int[]{1, -1}, -1),
                Arguments.of(new int[]{1, 2, 1, 2, -3, -4}, -1),
                Arguments.of(new int[]{1, 0, 2}, -1)
        );
    }

    public static int check(int[] a) {
        if (a.length == 0)
            return -1;

        int pos = 0, steps = 0;
        while (pos >= 0 && pos < a.length && steps++ >= 0) {
            if (a[pos] == 0)
                return -1;

            pos += a[pos] | (a[pos] = 0);
        }
        return steps;
    }

    @Test
    void should_test_100_randomized() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int n = 1 + random.nextInt(30);
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = random.nextInt(19) - 9;
            }
            assertEquals(check(arr.clone()), FrogJumping.solution(arr.clone()));
        }
    }
}