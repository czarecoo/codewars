package org.czareg.codewars.invert.values;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/*
Given a set of numbers, return the additive inverse of each. Each positive becomes negatives, and the negatives become positives.

[1, 2, 3, 4, 5] --> [-1, -2, -3, -4, -5]
[1, -2, 3, -4, 5] --> [-1, 2, -3, 4, -5]
[] --> []
 */
@UtilityClass
public class Inverter {

    public static int[] invert(int[] array) {
        return Arrays.stream(array).map(num -> -num).toArray();
    }
}
