package org.czareg.codewars.two.to.one;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
Take 2 strings s1 and s2 including only letters from a to z. Return a new sorted string (alphabetical ascending),
the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.

Examples:
a = "xyaabbbccccdefww"
b = "xxxxyyyyabklmopq"
longest(a, b) -> "abcdefklmopqwxy"

a = "abcdefghijklmnopqrstuvwxyz"
longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
 */
@UtilityClass
class TwoToOne {

    static String longest(String s1, String s2) {
        return IntStream.concat(s1.chars(), s2.chars())
                .distinct()
                .mapToObj(i -> (char) i)
                .sorted()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
