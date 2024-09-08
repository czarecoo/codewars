package org.czareg.codewars.convert.anumber.to.reversed.array.of.digits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConverterTest {

    @Test
    void basicTests() {
        assertArrayEquals(new int[]{1, 3, 2, 5, 3}, Converter.digitize(35231));
        assertArrayEquals(new int[]{0}, Converter.digitize(0));
        assertArrayEquals(new int[]{7, 5, 3, 2, 8, 5, 3, 2}, Converter.digitize(23582357));
        assertArrayEquals(new int[]{8, 3, 7, 4, 6, 7, 4, 8, 9}, Converter.digitize(984764738));
        assertArrayEquals(new int[]{0, 2, 9, 3, 9, 8, 2, 6, 7, 5, 4}, Converter.digitize(45762893920L));
        assertArrayEquals(new int[]{4, 9, 3, 8, 3, 8, 2, 0, 7, 8, 4, 5}, Converter.digitize(548702838394L));
    }

    @Test
    void randomTests() {
        int i, x;
        for (i = x = 1; i <= 37; x = ++i) {
            long input = (long) (10 + Math.ceil((9 * Math.pow(1.7, x) - 10) * Math.random()));
            assertArrayEquals(solution(input), Converter.digitize(input));
        }
    }

    private int[] solution(long n) {
        String numStr = Long.toString(n);
        int[] numArr = new int[numStr.length()];
        for (int i = numStr.length() - 1; i >= 0; i--) {
            numArr[numStr.length() - 1 - i] = Integer.parseInt(numStr.substring(i, i + 1));
        }
        return numArr;
    }
}