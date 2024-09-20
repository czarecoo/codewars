package org.czareg.codewars.removing.elements;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
Take an array and remove every second element from the array. Always keep the first element and start removing with the next element.

Example:
["Keep", "Remove", "Keep", "Remove", "Keep", ...] --> ["Keep", "Keep", "Keep", ...]

None of the arrays will be empty, so you don't have to worry about that!
 */
@UtilityClass
public class ArrUtil {

    public static Object[] removeEveryOther(Object[] arr) {
        return IntStream.iterate(0, i -> i < arr.length, i -> i + 2)
                .mapToObj(i -> arr[i])
                .toArray();
    }
}
