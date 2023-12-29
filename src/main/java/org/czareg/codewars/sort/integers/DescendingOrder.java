package org.czareg.codewars.sort.integers;

import lombok.experimental.UtilityClass;

import java.util.Comparator;

/*
Your task is to make a function that can take any non-negative integer as an argument and return it with its digits in descending order.
Essentially, rearrange the digits to create the highest possible number.

Examples:
Input: 42145 Output: 54421
Input: 145263 Output: 654321
Input: 123456789 Output: 987654321
 */
@UtilityClass
public class DescendingOrder {

    public static int sortDesc(final int num) {
        String reversedNumber = String.valueOf(num)
                .chars()
                .mapToObj(i -> (char) i)
                .sorted(Comparator.reverseOrder())
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return Integer.parseInt(reversedNumber);
    }
}
