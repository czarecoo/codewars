package org.czareg.codewars.num.to.digit.tiers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StringNumToArraysTest {

    @Test
    void basicTests() {
        int[] input = new int[]{0, 6, 420, 2017, 2010, 4020, 80200};
        String[][] expected = new String[][]{
                {"0"},
                {"6"},
                {"4", "42", "420"},
                {"2", "20", "201", "2017"},
                {"2", "20", "201", "2010"},
                {"4", "40", "402", "4020"},
                {"8", "80", "802", "8020", "80200"}
        };
        for (int i = 0; i < input.length; i++) {
            test(input[i], expected[i]);
        }
    }

    @Test
    void randomTests() {
        var rnd = ThreadLocalRandom.current();
        rnd.ints(1000L, 5, 21)
                .map(i -> Math.min(1 << i, 1000001))
                .map(rnd::nextInt)
                .forEach(num -> test(num, solution(num)));
    }

    private void test(int num, String[] expected) {
        String[] actual = StringNumToArrays.createArrayOfTiers(num);
        String msg = "For num = " + num + "\nExpected: " + Arrays.toString(expected) + "\nActual:   " + Arrays.toString(actual) + "\n";
        assertArrayEquals(expected, actual, msg);
    }

    private String[] solution(int num) {
        String s = String.valueOf(num);
        return IntStream.range(0, s.length())
                .mapToObj(pos -> s.substring(0, pos + 1))
                .toArray(String[]::new);
    }
}