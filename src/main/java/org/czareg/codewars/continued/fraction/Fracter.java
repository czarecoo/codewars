package org.czareg.codewars.continued.fraction;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
In this kata, you will have to return the continued fraction of a fraction.
https://en.wikipedia.org/wiki/Continued_fraction
For example, if the numerator is 311 and the denominator is 144, then you would have to return [2, 6, 3, 1, 5], because:
311/144 -> 2 and 23/144
144/23 -> 6 and 6/23
23/6 -> 3 and 5/6
6/5 -> 1 and 1/5
5/1 -> 5
If the numerator is 0, you should return [].
 */
@UtilityClass
public class Fracter {

    public static int[] continuedFraction(int numerator, int denominator) {
        if (numerator == 0) {
            return new int[]{};
        }
        IntStream.Builder builder = IntStream.builder();
        do {
            int wholes = numerator / denominator;
            builder.accept(wholes);
            int rest = numerator % denominator;
            numerator = denominator;
            denominator = rest;
        } while (denominator != 0);
        return builder.build().toArray();
    }
}
