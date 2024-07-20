package org.czareg.codewars.sum.no.duplicates;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Please write a function that sums a list, but ignores any duplicated items in the list.

For instance, for the list [3, 4, 3, 6] the function should return 10,
and for the list [1, 10, 3, 10, 10] the function should return 4.
 */
@UtilityClass
public class Summer {

    public static int sumNoDuplicates(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .mapToInt(Map.Entry::getKey)
                .sum();
    }
}
