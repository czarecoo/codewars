package org.czareg.codewars.remove.duplicates.from.list;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/*
Define a function that removes duplicates from an array of non negative numbers and returns it as a result.

The order of the sequence has to stay the same.

Examples:

Input -> Output
[1, 1, 2] -> [1, 2]
[1, 2, 1, 1, 3, 2] -> [1, 2, 3]
 */
@UtilityClass
public class DuplicatesRemover {

    public static int[] distinct(int[] array) {
        return Arrays.stream(array)
                .distinct()
                .toArray();
    }
}
