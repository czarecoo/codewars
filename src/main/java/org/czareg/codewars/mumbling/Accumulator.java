package org.czareg.codewars.mumbling;

import lombok.experimental.UtilityClass;

/*
This time no story, no theory. The examples below show you how to write function accum:

Examples:
accum("abcd") -> "A-Bb-Ccc-Dddd"
accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
accum("cwAt") -> "C-Ww-Aaa-Tttt"
The parameter of accum is a string which includes only letters from a..z and A..Z.
 */
@UtilityClass
class Accumulator {

    static String accum(String s) {
        String lowercaseInput = s.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < lowercaseInput.length(); index++) {
            char c = lowercaseInput.charAt(index);
            int repetitions = index + 1;
            String segment = String.valueOf(c).repeat(repetitions);
            String capitalizedSegment = capitalize(segment);
            result.append(capitalizedSegment);
            result.append('-');
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}
