package org.czareg.codewars.array.plus.array;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
I'm new to coding and now I want to get the sum of two arrays... Actually the sum of all their elements. I'll appreciate for your help.

P.S. Each array includes only integer numbers. Output is a number too.
 */
@UtilityClass
class ArraysSum {

    static int arrayPlusArray(int[] arr1, int[] arr2) {
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .sum();
    }
}
