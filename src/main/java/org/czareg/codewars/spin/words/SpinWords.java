package org.czareg.codewars.spin.words;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Write a function that takes in a string of one or more words, and returns the same string,
but with all words that have five or more letters reversed (Just like the name of this Kata).
Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.

Examples:

"Hey fellow warriors"  --> "Hey wollef sroirraw"
"This is a test        --> "This is a test"
"This is another test" --> "This is rehtona test"
 */

public class SpinWords {

    private static final int LONG_WORD_LENGTH = 5;
    private static final String EMPTY_SPACE = " ";

    public String spinWords(String sentence) {
        return Arrays.stream(sentence.split(EMPTY_SPACE))
                .map(SpinWords::reverseIfLong)
                .collect(Collectors.joining(EMPTY_SPACE));
    }

    private static String reverseIfLong(String word) {
        if (word.length() >= LONG_WORD_LENGTH) {
            return reverse(word);
        }
        return word;
    }

    private static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
