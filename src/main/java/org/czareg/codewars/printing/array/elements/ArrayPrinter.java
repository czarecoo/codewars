package org.czareg.codewars.printing.array.elements;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Input: Array of elements
["h","o","l","a"]

Output: String with comma delimited elements of the array in th same order.
"h,o,l,a"

Note: if this seems too simple for you try the next level
Note2: the input data can be: boolean array, array of objects, array of string arrays, array of number arrays... 😕
 */
@UtilityClass
class ArrayPrinter {

    static String printArray(Object[] array) {
        return Arrays.stream(array)
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }
}
