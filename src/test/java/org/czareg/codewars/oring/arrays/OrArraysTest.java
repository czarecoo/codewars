package org.czareg.codewars.oring.arrays;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OrArraysTest {

    @Test
    void example1() {
        assertArrayEquals(new int[]{1, 2, 3},
                OrArrays.orArrays(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    @Test
    void example2() {
        assertArrayEquals(new int[]{5, 7, 7},
                OrArrays.orArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }

    @Test
    void example3() {
        assertArrayEquals(new int[]{1, 2, 3},
                OrArrays.orArrays(new int[]{1, 2, 3}, new int[]{1, 2}));
    }

    @Test
    void example4() {
        assertArrayEquals(new int[]{1, 2, 3},
                OrArrays.orArrays(new int[]{1, 0}, new int[]{1, 2, 3}));
    }

    @Test
    void example5() {
        assertArrayEquals(new int[]{1, 2, 3},
                OrArrays.orArrays(new int[]{1, 0, 3}, new int[]{1, 2, 3}, 3));
    }

    Random rand = new Random();
    private static final int maxInt = 255;

    @Test
    void testSameLength() {
        int repeat = 10;
        for (int r = 0; r < repeat; r++) {
            int len = rand.nextInt(20);
            int[] arr1 = new int[len],
                    arr2 = new int[len],
                    res = new int[len];

            for (int i = 0; i < len; i++) {
                arr1[i] = randomInt();
                arr2[i] = randomInt();
                res[i] = arr1[i] | arr2[i];
            }

            if (r < repeat / 2)
                assertArrayEquals(res, OrArrays.orArrays(arr1, arr2));
            else
                assertArrayEquals(res, OrArrays.orArrays(arr1, arr2, rand.nextInt()));
        }
    }

    @Test
    void testDifferentLengthDefault() {
        int repeat = 10;
        for (int r = 0; r < repeat; r++) {
            int[] arr1 = new int[rand.nextInt(10)],
                    arr2 = new int[rand.nextInt(10) + 10];
            int[] res = new int[arr2.length];

            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = randomInt();
                arr2[i] = randomInt();
                res[i] = arr1[i] | arr2[i];
            }
            for (int i = arr1.length; i < arr2.length; i++) {
                arr2[i] = randomInt();
                res[i] = arr2[i];
            }

            if (r < repeat / 2)
                assertArrayEquals(res, OrArrays.orArrays(arr1, arr2));
            else
                assertArrayEquals(res, OrArrays.orArrays(arr2, arr1));
        }
    }

    @Test
    void testDifferentLengthRandom() {
        int repeat = 10;
        for (int r = 0; r < repeat; r++) {
            int[] arr1 = new int[rand.nextInt(10)],
                    arr2 = new int[rand.nextInt(10) + 10];
            int[] res = new int[arr2.length];
            int parameter = randomInt();

            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = randomInt();
                arr2[i] = randomInt();
                res[i] = arr1[i] | arr2[i];
            }
            for (int i = arr1.length; i < arr2.length; i++) {
                arr2[i] = randomInt();
                res[i] = arr2[i] | parameter;
            }

            if (r < repeat / 2)
                assertArrayEquals(res, OrArrays.orArrays(arr1, arr2, parameter));
            else
                assertArrayEquals(res, OrArrays.orArrays(arr2, arr1, parameter));
        }
    }

    private int randomInt() {
        return rand.nextInt(maxInt * 2 + 1) - maxInt;
    }
}