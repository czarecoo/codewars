package org.czareg.codewars.sort.the.odd;

import lombok.experimental.UtilityClass;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

/*
You will be given an array of numbers. You have to sort the odd numbers in ascending order while leaving the even numbers at their original positions.

Examples
[7, 1]  =>  [1, 7]
[5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */
@UtilityClass
public class OddSorter {

    public static int[] sortArray(int[] array) {
        Deque<Integer> sortedOdds = Arrays.stream(array)
                .filter(OddSorter::isOdd)
                .sorted()
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        return Arrays.stream(array)
                .map(num -> {
                    if (isOdd(num)) {
                        return sortedOdds.removeFirst();
                    }
                    return num;
                }).toArray();
    }

    private static boolean isOdd(int num) {
        return num % 2 == 1;
    }
}
