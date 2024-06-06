package org.czareg.codewars.every.other;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DoublerTest {

    @Test
    void basicTest() {
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] a1s = new int[]{1, 4, 3, 8};
        int[] a2 = new int[]{1, 19, 6, 2, 12, -3};
        int[] a2s = new int[]{1, 38, 6, 4, 12, -6};
        int[] a3 = new int[]{-1000, 1653, 210, 0, 1};
        int[] a3s = new int[]{-1000, 3306, 210, 0, 1};
        assertArrayEquals(a1s, Doubler.doubleEveryOther(a1));
        assertArrayEquals(a2s, Doubler.doubleEveryOther(a2));
        assertArrayEquals(a3s, Doubler.doubleEveryOther(a3));
    }

    @Test
    void randomTest() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int nrOfElements = rand.nextInt(15) + 1;
            final int[] eles = new int[nrOfElements];
            for (int j = 0; j < nrOfElements; j++) {
                int ele = rand.nextInt(100000);
                eles[j] = ele;
            }
            int[] expected = IntStream
                    .range(0, nrOfElements)
                    .map(ind -> ind % 2 == 0 ? eles[ind] : eles[ind] * 2)
                    .toArray();
            int[] result = Doubler.doubleEveryOther(eles);
            assertArrayEquals(expected, result);
        }
    }
}