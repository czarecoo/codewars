package org.czareg.codewars.square.sum;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareSummerTest {

    @Test
    void testBasic() {
        assertEquals(9, SquareSummer.squareSum(new int[]{1, 2, 2}));
        assertEquals(5, SquareSummer.squareSum(new int[]{1, 2}));
        assertEquals(50, SquareSummer.squareSum(new int[]{5, -3, 4}));
        assertEquals(0, SquareSummer.squareSum(new int[]{}));
    }

    @Test
    void testRandom() {
        Random rnd = new Random();
        for (int t = 0; t < 100; ++t) {
            int[] array = IntStream.generate(() -> rnd.nextInt(100) - 50).limit(rnd.nextInt(20) + 30).toArray();
            int sum = IntStream.of(array).map(i -> i * i).sum();
            assertEquals(sum, SquareSummer.squareSum(array));
        }
    }
}