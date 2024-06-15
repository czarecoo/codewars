package org.czareg.codewars.get.character.from.ascii.value;

import lombok.experimental.UtilityClass;

/*
Write a function which takes a number and returns the corresponding ASCII char for that value.

Example:

65 --> 'A'
97 --> 'a'
48 --> '0
For ASCII table, you can refer to http://www.asciitable.com/
 */
@UtilityClass
public class Ascii {

    public static char getChar(int c) {
        return (char) c;
    }
}
