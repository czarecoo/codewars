package org.czareg.codewars.str.end.with;

import lombok.experimental.UtilityClass;

/*
Complete the solution so that it returns true if the first argument(string) passed in ends with the 2nd argument (also a string).

Examples:

solution('abc', 'bc') // returns true
solution('abc', 'd') // returns false
 */
@UtilityClass
public class StringUtil {

    public static boolean endsWith(String input, String ending) {
        if (input.length() < ending.length()) {
            return false;
        }
        for (int endingIndex = ending.length() - 1, stringIndex = input.length() - 1; endingIndex >= 0; endingIndex--, stringIndex--) {
            char endingChar = ending.charAt(endingIndex);
            char inputChar = input.charAt(stringIndex);
            if (endingChar != inputChar) {
                return false;
            }
        }
        return true;
    }
}
