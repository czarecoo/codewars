package org.czareg.codewars.simple.pig.latin;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.

Example
Pig latin is cool -> igPay atinlay siay oolcay
Hello world ! -> elloHay orldway !
 */
@UtilityClass
public class PigLatin {

    private static final String DELIMITER = " ";

    public static String pigIt(@NonNull String str) {
        return Arrays.stream(str.split(DELIMITER))
                .map(PigLatin::toPigLatin)
                .collect(Collectors.joining(DELIMITER));
    }

    private static String toPigLatin(@NonNull String word) {
        if (word.isBlank()) {
            return word;
        }
        char firstLetter = word.charAt(0);
        if (!Character.isAlphabetic(firstLetter)) {
            return word;
        }
        if (word.length() == 1) {
            return word + "ay";
        }

        return word.substring(1) + firstLetter + "ay";
    }
}
