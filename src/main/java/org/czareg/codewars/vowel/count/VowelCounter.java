package org.czareg.codewars.vowel.count;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

/*
Return the number (count) of vowels in the given string.

We will consider a, e, i, o, u as vowels for this Kata (but not y).

The input string will only consist of lower case letters and/or spaces.
 */
@UtilityClass
public class VowelCounter {

    public static int getCount(@NonNull String str) {
        return (int) str.chars()
                .mapToObj(i -> (char) i)
                .filter(VowelCounter::isVowel)
                .count();
    }

    private static boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
}
