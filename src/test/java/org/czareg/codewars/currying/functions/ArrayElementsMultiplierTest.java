package org.czareg.codewars.currying.functions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayElementsMultiplierTest {

    @Test
    void isArray() {
        assertEquals(int[].class, ArrayElementsMultiplier.multiplyAll(new int[]{1}).apply(1).getClass());
    }

    @Test
    void hasCorrectLength() {
        assertEquals(2, ArrayElementsMultiplier.multiplyAll(new int[]{1, 2}).apply(1).length);
    }

    @Test
    void basicTests() {
        assertArrayEquals(new int[]{1, 2, 3}, ArrayElementsMultiplier.multiplyAll(new int[]{1, 2, 3}).apply(1));
        assertArrayEquals(new int[]{2, 4, 6}, ArrayElementsMultiplier.multiplyAll(new int[]{1, 2, 3}).apply(2));
        assertArrayEquals(new int[]{0, 0, 0}, ArrayElementsMultiplier.multiplyAll(new int[]{1, 2, 3}).apply(0));
        assertArrayEquals(new int[0], ArrayElementsMultiplier.multiplyAll(new int[0]).apply(10), "should return an empty array");
    }

    @Test
    void randomTests() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();

        for (int i = 0; i < 200; ++i) {
            int l = rnd.nextInt(10);
            int[] array = rnd.ints(0, 100).limit(l).toArray();
            int n = rnd.nextInt(100);
            int[] expected = Arrays.stream(array).map(v -> v * n).toArray();
            assertArrayEquals(expected, ArrayElementsMultiplier.multiplyAll(array).apply(n));
        }
    }
}