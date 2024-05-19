package org.czareg.codewars.powers.of.two;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PowerOfTwoTest {

    @Test
    void testSomething() {
        assertArrayEquals(new long[]{1}, PowerOfTwo.powersOfTwo(0));
        assertArrayEquals(new long[]{1, 2}, PowerOfTwo.powersOfTwo(1));
        assertArrayEquals(new long[]{1, 2, 4, 8, 16}, PowerOfTwo.powersOfTwo(4));
    }

    @Test
    void randomTests() {
        long[] ref = LongStream.iterate(1, n -> n << 1).limit(64).toArray();

        List<Integer> inputs = IntStream.range(0, 125).map(n -> n / 2).boxed().collect(Collectors.toList());
        Collections.shuffle(inputs);

        for (Integer input : inputs) {
            long[] expected = LongStream.of(ref).limit(input + 1).toArray();
            assertArrayEquals(expected, PowerOfTwo.powersOfTwo(input));
        }
    }
}