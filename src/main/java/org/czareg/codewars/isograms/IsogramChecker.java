package org.czareg.codewars.isograms;

import lombok.experimental.UtilityClass;

/*
An isogram is a word that has no repeating letters, consecutive or non-consecutive. Implement a function that determines whether a string that contains only letters is an isogram. Assume the empty string is an isogram. Ignore letter case.

Example: (Input --> Output)

"Dermatoglyphics" --> true
"aba" --> false
"moOse" --> false (ignore letter case)
 */
@UtilityClass
class IsogramChecker {

    static boolean isIsogram(String str) {
        long uniqueChars = str.toLowerCase().chars().distinct().count();
        int allChars = str.length();
        return uniqueChars == allChars;
    }
}
