package org.czareg.codewars.reversed.strings;

import lombok.experimental.UtilityClass;

/*
Complete the solution so that it reverses the string passed into it.

'world'  =>  'dlrow'
'word'   =>  'drow'
 */
@UtilityClass
public class ReversedStrings {

    public static String solution(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
