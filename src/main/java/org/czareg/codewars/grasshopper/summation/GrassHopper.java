package org.czareg.codewars.grasshopper.summation;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
Summation
Write a program that finds the summation of every number from 1 to num. The number will always be a positive integer greater than 0.
Your function only needs to return the result, what is shown between parentheses in the example below is how you reach that result and it's not part of it, see the sample tests.

For example (Input -> Output):

2 -> 3 (1 + 2)
8 -> 36 (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8)
 */
@UtilityClass
public class GrassHopper {

    public static int summation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Integer has to be bigger than 0");
        }
        return IntStream.rangeClosed(1, n).sum();
    }
}
