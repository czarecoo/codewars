package org.czareg.codewars.pyramid.array;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
Write a function that when given a number >= 0, returns an Array of ascending length subarrays.

pyramid(0) => [ ]
pyramid(1) => [ [1] ]
pyramid(2) => [ [1], [1, 1] ]
pyramid(3) => [ [1], [1, 1], [1, 1, 1] ]
Note: the subarrays should be filled with 1s
 */
@UtilityClass
public class PyramidArray {

    public static int[][] pyramid(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(PyramidArray::buildArrayOfOnes)
                .toArray(int[][]::new);
    }

    private static int[] buildArrayOfOnes(int size) {
        return IntStream.generate(() -> 1)
                .limit(size)
                .toArray();
    }
}
