package org.czareg.codewars.rectangle.into.squares;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
The drawing below gives an idea of how to cut a given "true" rectangle into squares ("true" rectangle meaning that the two dimensions are different).
Can you translate this drawing into an algorithm?

You will be given two dimensions

a positive integer length
a positive integer width
You will return a collection or a string (depending on the language; Shell bash, PowerShell, Pascal and Fortran return a string) with the size of each of the squares.

Examples in general form:
(depending on the language)
sqInRect(5, 3) should return [3, 2, 1, 1]
sqInRect(3, 5) should return [3, 2, 1, 1]

You can see examples for your language in **"SAMPLE TESTS".**

Notes:
lng == wdth as a starting case would be an entirely different problem and the drawing is planned to be interpreted with lng != wdth.
(See kata, Square into Squares. Protect trees! http://www.codewars.com/kata/54eb33e5bc1a25440d000891 for this problem).

When the initial parameters are so that lng == wdth, the solution [lng] would be the most obvious but not in the spirit of this kata so, in that case, return empty list
 */
@UtilityClass
public class SqInRect {

    public static List<Integer> sqInRect(int lng, int wdth) {
        if (lng <= 0 || wdth <= 0 || lng == wdth) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        int shorterSide = Math.min(lng, wdth);
        int longerSide = Math.max(lng, wdth);
        do {
            int howManyWillFit = longerSide / shorterSide;
            for (int i = 0; i < howManyWillFit; i++) {
                result.add(shorterSide);
            }
            int temp = shorterSide;
            shorterSide = longerSide - howManyWillFit * shorterSide;
            longerSide = temp;
        } while (shorterSide > 0);
        return result;
    }
}