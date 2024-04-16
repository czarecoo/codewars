package org.czareg.codewars.currying.functions;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.function.Function;

/*
To complete this Kata you need to make a function multiplyAll/multiply_all which takes an array of integers as an argument. This function must return another function, which takes a single integer as an argument and returns a new array.

The returned array should consist of each of the elements from the first array multiplied by the integer.

You must not mutate the original array.
 */
@UtilityClass
public class ArrayElementsMultiplier {

    public static Function<Integer, int[]> multiplyAll(int[] array) {
        return integer -> Arrays.stream(array)
                .map(elem -> elem * integer)
                .toArray();
    }
}
