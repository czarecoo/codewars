package org.czareg.codewars.invert.values;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InverterTest {

    @Test
    void testSomething() {
        int[] input = new int[]{-1, -2, -3, -4, -5};
        int[] expected = new int[]{1, 2, 3, 4, 5};
        assertEquals(Arrays.toString(expected), Arrays.toString(Inverter.invert(input)));

        input = new int[]{-1, 2, -3, 4, -5};
        expected = new int[]{1, -2, 3, -4, 5};
        assertEquals(Arrays.toString(expected), Arrays.toString(Inverter.invert(input)));

        input = new int[]{};
        expected = new int[]{};
        assertEquals(Arrays.toString(expected), Arrays.toString(Inverter.invert(input)));

        input = new int[]{0};
        expected = new int[]{0};
        assertEquals(Arrays.toString(expected), Arrays.toString(Inverter.invert(input)));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 50; i++) {
            int[] input = getRandomArray();
            int[] expected = solution(input);
            assertEquals(Arrays.toString(expected), Arrays.toString(Inverter.invert(input)));
        }
    }

    public static int[] solution(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= -1;
        }
        return array;
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public static int getRandomInt() {
        int ranNum = (int) (Math.random() * 100);
        return getRandomBoolean() ? ranNum : -ranNum;
    }

    public static int[] getRandomArray() {
        int[] ranArray = new int[getRandomInt()];
        for (int x = 0; x < ranArray.length; x++) {
            ranArray[x] = getRandomInt();
        }
        return ranArray;
    }
}