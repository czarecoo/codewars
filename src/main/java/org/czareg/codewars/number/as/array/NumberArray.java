package org.czareg.codewars.number.as.array;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
Given an array of integers of any length, return an array that has 1 added to the value represented by the array.

the array can't be empty
only non-negative, single digit integers are allowed
Return nil (or your language's equivalent) for invalid inputs.

Examples
Valid arrays

[4, 3, 2, 5] would return [4, 3, 2, 6]
[1, 2, 3, 9] would return [1, 2, 4, 0]
[9, 9, 9, 9] would return [1, 0, 0, 0, 0]
[0, 1, 3, 7] would return [0, 1, 3, 8]

Invalid arrays

[1, -9] is invalid because -9 is not a non-negative integer

[1, 2, 33] is invalid because 33 is not a single-digit integer
 */
@UtilityClass
public class NumberArray {

    public static int[] upArray(final int[] arr) {
        if (arr == null || arr.length == 0 || Arrays.stream(arr).anyMatch(digit -> digit < 0 || digit > 9)) {
            return null;
        }
        String number = convertToString(arr);
        BigInteger incrementedNumber = new BigInteger(number).add(BigInteger.ONE);
        return convertToArray(incrementedNumber);
    }

    private static String convertToString(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    private static int[] convertToArray(BigInteger incrementedNumber) {
        return incrementedNumber.toString()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}
