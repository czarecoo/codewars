package org.czareg.codewars.sort.frequency;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FrequencySortTest {

    @Test
    void basicTests() {
        assertArrayEquals(new int[]{3, 3, 3, 5, 5, 7, 7, 2, 9}, FrequencySort.sortByFrequency(new int[]{2, 3, 5, 3, 7, 9, 5, 3, 7}));
        assertArrayEquals(new int[]{1, 1, 1, 0, 0, 6, 6, 8, 8, 2, 3, 5, 9}, FrequencySort.sortByFrequency(new int[]{1, 2, 3, 0, 5, 0, 1, 6, 8, 8, 6, 9, 1}));
        assertArrayEquals(new int[]{9, 9, 9, 9, 4, 4, 5, 5, 6, 6}, FrequencySort.sortByFrequency(new int[]{5, 9, 6, 9, 6, 5, 9, 9, 4, 4}));
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 8}, FrequencySort.sortByFrequency(new int[]{4, 4, 2, 5, 1, 1, 3, 3, 2, 8}));
        assertArrayEquals(new int[]{0, 0, 4, 4, 9, 9, 3, 5, 7, 8}, FrequencySort.sortByFrequency(new int[]{4, 9, 5, 0, 7, 3, 8, 4, 9, 0}));
    }

    @Test
    void randomTests() {
        UnaryOperator<int[]> answer = array -> {
            Map<Integer, Integer> frequencies = IntStream.of(array).boxed().collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum));
            return IntStream.of(array).boxed().sorted(Comparator.<Integer, Integer>comparing(frequencies::get, Comparator.reverseOrder()).thenComparingInt(Integer::intValue)).mapToInt(Integer::intValue).toArray();
        };
        for (int i = 0; i < 100; i++) {
            int length = (int) (Math.random() * 41 + 10);
            int[] array = new int[length];
            for (int j = 0; j < length; j++) {
                array[j] = (int) (Math.random() * 51);
            }
            assertArrayEquals(answer.apply(array), FrequencySort.sortByFrequency(array));
        }
    }
}