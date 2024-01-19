package org.czareg.codewars.reverse.words;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the string should be retained.

Examples
"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps"
 */
@UtilityClass
public class WordsReverser {

    private static final String EMPTY_SPACE = " ";
    /*
    ^: Asserts the start of the string.
    \s*: Matches zero or more whitespace characters.
    $: Anchors the match at the end of the string.
     */
    private static final String ONLY_WHITESPACES_REGEX = "^\\s*$";

    public static String reverseWords(final String original) {
        if (original.matches(ONLY_WHITESPACES_REGEX)) {
            return original;
        }
        return Arrays.stream(original.split(EMPTY_SPACE))
                .map(WordsReverser::reverse)
                .collect(Collectors.joining(EMPTY_SPACE));
    }

    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
