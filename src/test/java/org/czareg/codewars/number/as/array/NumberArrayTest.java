package org.czareg.codewars.number.as.array;

import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NumberArrayTest {

    @Test
    @DisplayName("Example Tests")
    @Order(1)
    void exampleTests() {
        doTest(new int[]{2, 3, 9}, new int[]{2, 4, 0});
        doTest(new int[]{4, 3, 2, 5}, new int[]{4, 3, 2, 6});
    }

    @Test
    @DisplayName("Basic Tests")
    @Order(2)
    void basicTests() {
        doTest(new int[]{5, 7, 4}, new int[]{5, 7, 5});
        doTest(new int[]{9, 9, 9}, new int[]{1, 0, 0, 0});
        doTest(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 7}, new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 8});
    }

    @Test
    @DisplayName("Testing for invalid arrays")
    @Order(3)
    void invalidsArray() {
        doTest(new int[]{1, -9}, null);
        doTest(new int[]{1, 2, 33}, null);
        doTest(new int[]{1, 2, -1}, null);
        doTest(new int[]{}, null);
    }

    @Test
    @DisplayName("Testing for big arrays")
    @Order(4)
    void bigArray() {
        doTest(new int[]{9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7}, new int[]{9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 8});
        doTest(new int[]{9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7, 5, 3, 2, 6, 7, 8, 4, 2, 4, 2, 6, 7, 8, 7, 4, 5, 2, 1}, new int[]{9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7, 5, 3, 2, 6, 7, 8, 4, 2, 4, 2, 6, 7, 8, 7, 4, 5, 2, 2});
    }

    @Test
    @DisplayName("Random Tests")
    @Order(5)
    void randomTests() {
        Random rand = new Random();
        for (int trial = 1; trial <= 40; trial++) {
            int[] arr = new int[rand.nextInt(30) + 1], expected = null;
            arr[0] = rand.nextInt(9) + 1;
            for (int i = 1; i < arr.length; i++) {
                arr[i] = rand.nextInt(10);
            }
            if (rand.nextInt(4) == 0) {
                int badIdx = rand.nextInt(arr.length);
                arr[badIdx] = 0 < arr[badIdx] && rand.nextInt(10) < 5 ? -arr[badIdx] : 10 + rand.nextInt(10);
            } else {
                expected = stringToDigits(new BigInteger(digitsToString(arr)).add(BigInteger.ONE).toString());
            }
            doTest(arr, expected);
        }
    }

    private String digitsToString(final int[] arr) {
        char[] digits = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            digits[i] = "0123456789".charAt(arr[i]);
        }
        return new String(digits);
    }

    private int[] stringToDigits(final String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "0123456789".indexOf(s.charAt(i));
        }
        return arr;
    }

    private static void doTest(final int[] arr, final int[] expected) {
        int[] actual = NumberArray.upArray(arr);
        String arrAsString = Arrays.toString(arr);
        assertArrayEquals(expected, actual, "Incorrect answer for arr = " + arrAsString);
    }
}