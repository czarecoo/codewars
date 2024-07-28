package org.czareg.codewars.find.the.parity.outlier;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.

Examples
[2, 4, 0, 100, 4, 11, 2602, 36] -->  11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21] --> 160 (the only even number)
 */
@UtilityClass
public class FindOutlier {

    static int find(int[] integers) {
        Map<Boolean, List<Integer>> evenOdds = Arrays.stream(integers)
                .boxed()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        List<Integer> evens = evenOdds.get(Boolean.TRUE);
        List<Integer> odds = evenOdds.get(Boolean.FALSE);
        return evens.size() < odds.size() ? evens.getFirst() : odds.getFirst();
    }
}
