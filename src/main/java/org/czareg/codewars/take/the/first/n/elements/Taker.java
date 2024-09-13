package org.czareg.codewars.take.the.first.n.elements;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/*
//Create a function that accepts a list/array and a number n, and returns a list/array of the first n elements from the list/array.

If you need help, here's a reference:

https://docs.oracle.com/javase/6/docs/api/java/util/Arrays.html#copyOfRange(int[],%20int,%20int)
 */
@UtilityClass
public class Taker {

    public static int[] take(int[] arr, int n) {
        int endIndex = Math.min(n, arr.length);
        return Arrays.copyOfRange(arr, 0, endIndex);
    }
}
