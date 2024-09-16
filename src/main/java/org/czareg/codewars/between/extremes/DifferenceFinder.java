package org.czareg.codewars.between.extremes;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/*
Given an array of numbers, return the difference between the largest and smallest values.

For example:
[23, 3, 19, 21, 16] should return 20 (i.e., 23 - 3).
[1, 434, 555, 34, 112] should return 554 (i.e., 555 - 1).

The array will contain a minimum of two elements. Input data range guarantees that max-min will cause no integer overflow.
 */
@UtilityClass
class DifferenceFinder {

    static int betweenExtremes(int[] numbers) {
        var statistics = Arrays.stream(numbers).summaryStatistics();
        return statistics.getMax() - statistics.getMin();
    }
}
