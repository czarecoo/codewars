package org.czareg.codewars.reduce.but.grow;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
Given a non-empty array of integers, return the result of multiplying the values together in order. Example:

[1, 2, 3, 4] => 1 * 2 * 3 * 4 = 24
 */
@UtilityClass
public class ArrayMultiplier {

    public static int grow(int[] x) {
        return IntStream.of(x).reduce((i, j) -> i * j).orElseThrow();
    }
}
