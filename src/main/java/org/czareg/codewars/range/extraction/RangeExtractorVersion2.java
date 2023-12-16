package org.czareg.codewars.range.extraction;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Different version of RangeExtractor. In this one I separated processing of int[] arr into list of deques from creation of List<String> which holds results.
 */
@UtilityClass
public class RangeExtractorVersion2 {

    private static final int HOW_MANY_ELEMENTS_TO_CONSIDER_IT_RANGE = 3;
    private static final String RANGE_SEPARATOR = "-";

    public static String rangeExtraction(int[] arr) {
        if (arr.length == 0) {
            return "";
        }
        List<Deque<Integer>> dequeList = createDequeList(arr);
        List<String> result = mergeDeques(dequeList);
        return String.join(",", result);
    }

    private static List<Deque<Integer>> createDequeList(int[] arr) {
        List<Deque<Integer>> dequeList = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int current : arr) {
            if (!deque.isEmpty() && deque.getLast() + 1 != current) {
                dequeList.add(deque);
                deque = new LinkedList<>();
            }
            deque.add(current);
        }

        dequeList.add(deque);
        return dequeList;
    }

    private static List<String> mergeDeques(List<Deque<Integer>> dequeList) {
        List<String> result = new ArrayList<>();

        for (Deque<Integer> deque : dequeList) {
            if (deque.size() < HOW_MANY_ELEMENTS_TO_CONSIDER_IT_RANGE) {
                for (int num : deque) {
                    result.add(String.valueOf(num));
                }
            } else {
                result.add(deque.getFirst() + RANGE_SEPARATOR + deque.getLast());
            }
        }

        return result;
    }
}
