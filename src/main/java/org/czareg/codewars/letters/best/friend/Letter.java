package org.czareg.codewars.letters.best.friend;

import lombok.experimental.UtilityClass;

/*
Task
Given a string, return if all occurrences of a given letter are always immediately followed by the other given letter.

Worked Example
("he headed to the store", "h", "e") ➞ True

# All occurences of "h": ["he", "headed", "the"]
# All occurences of "h" have an "e" after it.
# Return True

('abcdee', 'e', 'e') ➞ False

# For first "e" we can get "ee"
# For second "e" we cannot have "ee"
# Return False
Examples
("i found an ounce with my hound", "o", "u") ➞ True

("we found your dynamite", "d", "y") ➞ False
Notes
All sentences will be given in lowercase.
 */
@UtilityClass
public class Letter {

    public static boolean bestFriend(String text, char letterToFind, char requiredNextLetter) {
        int lastFoundIndex = 0;
        for (; ; ) {
            int indexOfLetterToFind = text.indexOf(letterToFind, lastFoundIndex);
            if (indexOfLetterToFind == -1) {
                return true;
            } else {
                int indexOfRequiredNextLetter = indexOfLetterToFind + 1;
                if (indexOfRequiredNextLetter >= text.length()) {
                    return false;
                }
                if (text.charAt(indexOfRequiredNextLetter) != requiredNextLetter) {
                    return false;
                }
                lastFoundIndex = indexOfRequiredNextLetter;
            }
        }
    }
}
