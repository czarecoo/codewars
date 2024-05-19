package org.czareg.codewars.digitize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumberToArrayConverterTest {

    @Test
    void fixedTests() {
        assertArrayEquals(new int[]{1, 2, 3}, NumberToArrayConverter.digitize(123));
        assertArrayEquals(new int[]{1}, NumberToArrayConverter.digitize(1));
        assertArrayEquals(new int[]{0}, NumberToArrayConverter.digitize(0));
        assertArrayEquals(new int[]{1, 2, 3, 0}, NumberToArrayConverter.digitize(1230));
        assertArrayEquals(new int[]{8, 6, 7, 5, 3, 0, 9}, NumberToArrayConverter.digitize(8675309));
    }

    @Test
    void randomTest() {
        for (int i = 0; i < 100; i++) {
            int num = randint(0, (int) Math.pow(10, randint(1, 6)));
            int[] exp = solution(num);
            assertArrayEquals(exp, NumberToArrayConverter.digitize(num));
        }
    }

    private int randint(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    private static int[] solution(int n) {
        String s = Integer.toString(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        return arr;
    }
}