package org.czareg.codewars.find.the.parity.outlier;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/*
You are given an array (which will have a length of at least 3, but could be very large) containing integers.
The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N.
Write a method that takes the array as an argument and returns this "outlier" N.

Examples
[2, 4, 0, 100, 4, 11, 2602, 36] -->  11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21] --> 160 (the only even number)
 */
@UtilityClass
public class FindOutlier {

    static int find(int[] integers) {
        boolean areEven = Arrays.stream(integers)
                .limit(3)
                .boxed()
                .collect(Collectors.partitioningBy(FindOutlier::isEven, Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
        return Arrays.stream(integers)
                .filter(areEven ? FindOutlier::isEven : FindOutlier::isOdd)
                .findFirst()
                .orElseThrow();
    }

    private static boolean isOdd(int number) {
        return !isEven(number);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
