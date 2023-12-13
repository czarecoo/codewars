package org.czareg.codewars.reversed.sequence;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
Build a function that returns an array of integers from n to 1 where n>0.

Example : n=5 --> [5,4,3,2,1]
 */
@UtilityClass
public class Sequence {

    public static int[] reverse(int n) {
        return IntStream.iterate(n, i -> i - 1).limit(n).toArray();
    }
}
