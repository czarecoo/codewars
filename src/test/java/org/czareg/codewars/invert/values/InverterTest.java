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
            assertEquals(Arrays.toString(solution(input)), Arrays.toString(Inverter.invert(input)));
        }
    }

    public static int[] solution(int[] array) {
        int[] ints = Arrays.copyOf(array, array.length);
        for (int i = 0; i < ints.length; i++) {
            ints[i] *= -1;
        }
        return ints;
    }

    public static int[] getRandomArray() {
        int[] ranArray = new int[rand(5, 1000)];
        for (int x = 0; x < ranArray.length; x++) {
            ranArray[x] = rand(-100, 100);
        }
        return ranArray;
    }

    public static int rand(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}