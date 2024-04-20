package org.czareg.codewars.sort.array.by.value.and.index;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SorterTest {

    @Test
    void exampleTests() {
        int[] actual = Sorter.sortByValueAndIndex(new int[]{1, 2, 3, 4, 5});
        int[] expected = new int[]{1, 2, 3, 4, 5};
        assertEquals(arrayToString(expected), arrayToString(actual));

        actual = Sorter.sortByValueAndIndex(new int[]{23, 2, 3, 4, 5});
        expected = new int[]{2, 3, 4, 23, 5};
        assertEquals(arrayToString(expected), arrayToString(actual));

        actual = Sorter.sortByValueAndIndex(new int[]{26, 2, 3, 4, 5});
        expected = new int[]{2, 3, 4, 5, 26};
        assertEquals(arrayToString(expected), arrayToString(actual));

        actual = Sorter.sortByValueAndIndex(new int[]{9, 5, 1, 4, 3});
        expected = new int[]{1, 9, 5, 3, 4};
        assertEquals(arrayToString(expected), arrayToString(actual));
    }

    @Test
    void randomTests() {
        for (int r = 0; r < 20; r++) {
            int n = (int) (Math.random() * 20 + 1);
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = (int) (Math.random() * 60 - 30);
            }

            int[][] arrayWithProd = new int[array.length][];
            for (int i = 0; i < array.length; i++) {
                arrayWithProd[i] = new int[2];
                arrayWithProd[i][0] = array[i];
                arrayWithProd[i][1] = (i + 1) * array[i];
            }

            for (int h = 0; h < arrayWithProd.length; h++) {
                for (int i = 0; i < arrayWithProd.length - 1; i++) {
                    if (arrayWithProd[i][1] > arrayWithProd[i + 1][1]) {
                        int[] temp = arrayWithProd[i];
                        arrayWithProd[i] = arrayWithProd[i + 1];
                        arrayWithProd[i + 1] = temp;
                    }
                }
            }

            int[] expected = new int[array.length];
            for (int i = 0; i < arrayWithProd.length; i++) {
                expected[i] = arrayWithProd[i][0];
            }

            int[] actual = Sorter.sortByValueAndIndex(array);
            assertEquals(arrayToString(expected), arrayToString(actual));
        }
    }

    private String arrayToString(int[] array) {
        return Arrays.toString(array);
    }
}