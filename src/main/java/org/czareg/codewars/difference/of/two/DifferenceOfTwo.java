package org.czareg.codewars.difference.of.two;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.stream.Stream;

/*
The objective is to return all pairs of integers from a given array of integers that have a difference of 2.

The result array should be sorted in ascending order of values.

Assume there are no duplicate integers in the array. The order of the integers in the input array should not matter.

Examples
[1, 2, 3, 4]  should return [[1, 3], [2, 4]]

[4, 1, 2, 3]  should also return [[1, 3], [2, 4]]

[1, 23, 3, 4, 7] should return [[1, 3]]

[4, 3, 1, 5, 6] should return [[1, 3], [3, 5], [4, 6]]
 */
@UtilityClass
public class DifferenceOfTwo {

    public static int[][] twosDifference(int[] array) {
        Stream.Builder<int[]> pairs = Stream.builder();
        for (int first : array) {
            for (int second : array) {
                if (first >= second || second - first != 2) {
                    continue;
                }
                pairs.accept(new int[]{first, second});
            }
        }
        return pairs.build()
                .sorted(Comparator.comparingInt(arr -> arr[0]))
                .toArray(int[][]::new);
    }
}
