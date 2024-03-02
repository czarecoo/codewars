package org.czareg.codewars.sort.frequency;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/*
In this kata, you will sort elements in an array by decreasing frequency of elements. If two elements have the same frequency, sort them by increasing value.

[2, 3, 5, 3, 7, 9, 5, 3, 7] -> [3, 3, 3, 5, 5, 7, 7, 2, 9]
// We sort by highest frequency to the lowest frequency.
// If two elements have same frequency, we sort by increasing value.
 */
@UtilityClass
public class FrequencySort {

    public static int[] sortByFrequency(int[] array) {
        return IntStream.of(array)
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .sorted(compareByReverseValueThenByKey())
                .flatMap(FrequencySort::entryToStreamOfIntegers)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static Comparator<Map.Entry<Integer, Long>> compareByReverseValueThenByKey() {
        return Comparator
                .comparing(Map.Entry<Integer, Long>::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }

    private static Stream<Integer> entryToStreamOfIntegers(Map.Entry<Integer, Long> entry) {
        return Stream.generate(entry::getKey)
                .limit(entry.getValue());
    }
}
