package org.czareg.codewars.split.strings;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

/*
Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of
characters then it should replace the missing second character of the final pair with an underscore ('_').

Examples:

* 'abc' =>  ['ab', 'c_']
* 'abcdef' => ['ab', 'cd', 'ef']
 */
@UtilityClass
public class StringSplit {

    public static String[] solution(@NonNull String input) {
        String[] twoCharacterStrings = input.split("(?<=\\G..)");
        if (input.length() % 2 == 1) {
            int lastIndex = twoCharacterStrings.length - 1;
            twoCharacterStrings[lastIndex] += "_";
        }
        return twoCharacterStrings;
    }
}
