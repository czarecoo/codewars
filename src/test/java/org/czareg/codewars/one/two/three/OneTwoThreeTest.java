package org.czareg.codewars.one.two.three;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OneTwoThreeTest {

    String[] oneTwoThree(int n) {
        StringBuilder sb = new StringBuilder();
        String[] result = new String[]{"0", "0"};
        if (n == 0) {
            return result;
        }
        int nines = n / 9;
        int ones = n % 9;
        sb.append("9".repeat(nines));
        if (ones > 0) {
            sb.append(ones);
        }
        result[0] = sb.toString();
        result[1] = "1".repeat(n);
        return result;
    }

    void doTest(int n) {
        String[] actual = OneTwoThree.oneTwoThree(n);
        String[] expected = oneTwoThree(n);

        String message = "oneTwoThree(" + n + ") should return [\"" + expected[0] + "\", \"" + expected[1] + "\"]," + " but returned [\"" + actual[0] + "\",\"" + actual[1] + "\"].";

        assertArrayEquals(expected, actual, message);
    }

    @Test
    void basicTests() {
        for (int i : new int[]{0, 1, 2, 3, 19}) {
            doTest(i);
        }
    }


    @Test
    void randomTests() {
        Random random = new Random();
        for (int i : random.ints(100, 10, 251).toArray()) {
            doTest(i);
        }
    }
}