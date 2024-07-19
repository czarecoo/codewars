package org.czareg.codewars.repeat.character;

import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

/*
Given a string, you have to return a string in which each character (case-sensitive) is repeated once.

Examples (Input -> Output):
* "String"      -> "SSttrriinngg"
* "Hello World" -> "HHeelllloo  WWoorrlldd"
* "1234!_ "     -> "11223344!!__  "
 */
@UtilityClass
public class Repeater {

    private static final int REPEAT_TIMES = 2;

    public static String doubleChar(String input) {
        return input.codePoints()
                .mapToObj(Character::toString)
                .map(string -> string.repeat(REPEAT_TIMES))
                .collect(Collectors.joining());
    }
}
