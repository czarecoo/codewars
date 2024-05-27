package org.czareg.codewars.abbreviate.a.two.word.name;

import lombok.experimental.UtilityClass;

/*
Write a function to convert a name into initials. This kata strictly takes two words with one space in between them.
The output should be two capital letters with a dot separating them.

It should look like this:
Sam Harris => S.H
patrick feeney => P.F
 */
@UtilityClass
public class AbbreviateTwoWords {

    public static String abbrevName(String name) {
        String[] split = name.split(" ");
        char nameLetter = split[0].charAt(0);
        char surNameLetter = split[1].charAt(0);
        return "%C.%C".formatted(nameLetter, surNameLetter);
    }
}
