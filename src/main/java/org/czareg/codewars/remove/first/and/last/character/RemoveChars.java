package org.czareg.codewars.remove.first.and.last.character;

import lombok.experimental.UtilityClass;

/*
It's pretty straightforward. Your goal is to create a function that removes the first and last characters of a string.
You're given one parameter, the original string.
 */
@UtilityClass
class RemoveChars {

    static String remove(String str) {
        if (str == null || str.length() < 2) {
            throw new IllegalArgumentException();
        }
        return str.substring(1, str.length() - 1);
    }
}
