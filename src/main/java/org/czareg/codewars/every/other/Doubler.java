package org.czareg.codewars.every.other;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/*
Write a function that doubles every second integer in a list, starting from the left.

Example:
For input array/list :
[1,2,3,4]
the function should return :
[1,4,3,8]
 */
@UtilityClass
public class Doubler {

    public static int[] doubleEveryOther(int[] array) {
        int[] copiedArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copiedArray.length; i++) {
            if (i % 2 == 1) {
                copiedArray[i] *= 2;
            }
        }
        return copiedArray;
    }
}
