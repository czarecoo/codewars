package org.czareg.codewars.bowling.pins;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Mount the Bowling Pins!
Task:
Did you ever play Bowling? Short: You have to throw a bowl into 10 Pins arranged like this:

I I I I  # each Pin has a Number:    7 8 9 10
 I I I                                4 5 6
  I I                                  2 3
   I                                    1
You will get an array of integers between 1 and 10, e.g. [3, 5, 9], and have to remove them from the field like this:

I I   I
 I   I
  I
   I
Return a string with the current field.

Note that:
The pins rows are separated by a newline (\n)
Each Line must be 7 chars long
Fill the missing pins with a space character ( )
 */
class Bowling {

    private static final String PINS = "7 8 9 0\n 4 5 6 \n  2 3  \n   1   ";

    String bowlingPins(int[] arr) {
        List<Integer> missing = IntStream.of(arr).boxed().collect(Collectors.toList());
        if (missing.contains(10)) {
            missing.set(missing.indexOf(10), 0);
        }
        StringBuilder result = new StringBuilder(PINS);
        for (int i = 0; i < 10; i++) {
            char replacement = missing.contains(i) ? ' ' : 'I';
            int index = PINS.indexOf(Integer.toString(i));
            result.setCharAt(index, replacement);
        }
        return result.toString();
    }
}
