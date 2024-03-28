package org.czareg.codewars.odd.even.sort;

import lombok.experimental.UtilityClass;

/*
Given a string s, your task is to return another string such that even-indexed and odd-indexed characters of s are grouped and the groups are space-separated. Even-indexed group comes as first, followed by a space, and then by the odd-indexed part.

Examples
input:    "CodeWars" => "CdWr oeas"
           ||||||||      |||| ||||
indices:   01234567      0246 1357
Even indices 0, 2, 4, 6, so we have "CdWr" as the first group.
Odd indices are 1, 3, 5, 7, so the second group is "oeas".
And the final string to return is "Cdwr oeas".

Notes
Tested strings are at least 8 characters long.
 */
@UtilityClass
public class OddEvenSort {

    public static String sortMyString(String s) {
        StringBuilder evens = new StringBuilder();
        StringBuilder odds = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (i % 2 == 0) {
                evens.append(aChar);
            } else {
                odds.append(aChar);
            }
        }
        return evens.append(" ").append(odds).toString();
    }
}
