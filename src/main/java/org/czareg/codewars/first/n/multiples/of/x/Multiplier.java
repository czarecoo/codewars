package org.czareg.codewars.first.n.multiples.of.x;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
Create a function with two arguments that will return an array of the first n multiples of x.

Assume both the given number and the number of times to count will be positive numbers greater than 0.

Return the results as an array or list ( depending on language ).

Examples
1,10 -> 1,2,3,4,5,6,7,8,9,10
2,5 -> 2,4,6,8,10
 */
@UtilityClass
public class Multiplier {

    public static int[] countBy(int x, int n) {
        return IntStream.iterate(x, i -> i + x).limit(n).toArray();
    }
}
