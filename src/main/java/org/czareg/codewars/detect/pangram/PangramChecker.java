package org.czareg.codewars.detect.pangram;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

/*
A pangram is a sentence that contains every single letter of the alphabet at least once.
For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).

Given a string, detect whether it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
 */
@UtilityClass
public class PangramChecker {

    public static boolean check(@NonNull String sentence) {
        long count = sentence
                .toLowerCase()
                .replaceAll("[^a-z]", "")
                .chars()
                .distinct()
                .count();
        return count >= 26;
    }
}
