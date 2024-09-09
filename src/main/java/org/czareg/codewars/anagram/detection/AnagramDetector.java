package org.czareg.codewars.anagram.detection;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/*
An anagram is the result of rearranging the letters of a word to produce a new word (see wikipedia).
Note: anagrams are case insensitive
Complete the function to return true if the two arguments given are anagrams of each other; return false otherwise.

Examples
"foefet" is an anagram of "toffee"
"Buckethead" is an anagram of "DeathCubeK"
 */
@UtilityClass
class AnagramDetector {

    static boolean isAnagram(@NonNull String test, @NonNull String original) {
        Map<Character, Long> originalCharacterCount = groupCharacterByCount(original.toLowerCase());
        Map<Character, Long> testCharacterCount = groupCharacterByCount(test.toLowerCase());
        return originalCharacterCount.equals(testCharacterCount);
    }

    private static Map<Character, Long> groupCharacterByCount(String string) {
        return string.chars()
                .mapToObj(i -> (char) i)
                .collect(groupingBy(identity(), counting()));
    }
}
