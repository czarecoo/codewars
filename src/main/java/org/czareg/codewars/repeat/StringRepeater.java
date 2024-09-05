package org.czareg.codewars.repeat;

import lombok.experimental.UtilityClass;

/*
Write a function that accepts an integer n and a string s as parameters, and returns a string of s repeated exactly n times.

Examples (input -> output)
6, "I"     -> "IIIIII"
5, "Hello" -> "HelloHelloHelloHelloHello"
 */
@UtilityClass
public class StringRepeater {

    public static String repeatStr(final int repeat, final String string) {
        return string.repeat(repeat);
    }
}
