package org.czareg.codewars.from.a.to.z;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
Given a string indicating a range of letters, return a string which includes all the letters in that range, including the last letter.
Note that if the range is given in capital letters, return the string in capitals also!

Examples
"a-z" ➞ "abcdefghijklmnopqrstuvwxyz"
"h-o" ➞ "hijklmno"
"Q-Z" ➞ "QRSTUVWXYZ"
"J-J" ➞ "J"
Notes
A hyphen will separate the two letters in the string.
You don't need to worry about error handling in this kata (i.e. both letters will be the same case and the second letter will not be before the first alphabetically).
 */
@UtilityClass
public class LetterSequencer {

    public static String gimmeTheLetters(String s) {
        int start = s.charAt(0);
        int end = s.charAt(2);
        return IntStream.rangeClosed(start, end)
                .mapToObj(i -> (char) i)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
