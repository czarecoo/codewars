package org.czareg.codewars.square.sum;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/*
Complete the square sum function so that it squares each number passed into it and then sums the results together.

For example, for [1, 2, 2] it should return 9 because
1^2+2^2+2^2=9
 */
@UtilityClass
public class SquareSummer {

    public static int squareSum(int[] n) {
        return Arrays.stream(n)
                .map(number -> number * number)
                .sum();
    }
}
