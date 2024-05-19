package org.czareg.codewars.powers.of.two;

import lombok.experimental.UtilityClass;

import java.util.stream.LongStream;

/*
Complete the function that takes a non-negative integer n as input, and returns a list of all the powers of 2 with the exponent ranging from 0 to n ( inclusive ).

Examples
n = 0  ==> [1]        # [2^0]
n = 1  ==> [1, 2]     # [2^0, 2^1]
n = 2  ==> [1, 2, 4]  # [2^0, 2^1, 2^2]
 */
@UtilityClass
public class PowerOfTwo {

    public static long[] powersOfTwo(int input) {
        return LongStream.iterate(1, current -> current * 2).limit(input + 1L).toArray();
    }
}
