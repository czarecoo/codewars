package org.czareg.codewars.range.extraction;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
A format for expressing an ordered list of integers is to use a comma separated list of either:
-individual integers
-a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'.
The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17"
Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.

Example:
[-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20] -> "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
 */
@UtilityClass
public class RangeExtractor {

    private static final int HOW_MANY_ELEMENTS_TO_CONSIDER_IT_RANGE = 3;
    private static final String RANGE_SEPARATOR = "-";

    public static String rangeExtraction(int[] arr) {
        if (arr.length == 0) {
            return "";
        }
        List<String> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        deque.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int prev = arr[i - 1];
            int curr = arr[i];
            if (prev + 1 != curr) {
                dequeToResult(deque, result);
            }
            deque.add(curr);
        }
        dequeToResult(deque, result);
        return String.join(",", result);
    }

    private static void dequeToResult(Deque<Integer> deque, List<String> result) {
        if (deque.isEmpty()) {
            return;
        }
        if (deque.size() < HOW_MANY_ELEMENTS_TO_CONSIDER_IT_RANGE) {
            for (int num : deque) {
                result.add(String.valueOf(num));
            }
        } else {
            result.add(deque.getFirst() + RANGE_SEPARATOR + deque.getLast());
        }
        deque.clear();
    }
}
