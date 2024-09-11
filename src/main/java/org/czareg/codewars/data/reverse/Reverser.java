package org.czareg.codewars.data.reverse;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

/*
A stream of data is received and needs to be reversed.

Each segment is 8 bits long, meaning the order of these segments needs to be reversed, for example:

11111111  00000000  00001111  10101010
 (byte1)   (byte2)   (byte3)   (byte4)
should become:

10101010  00001111  00000000  11111111
 (byte4)   (byte3)   (byte2)   (byte1)
The total number of bits will always be a multiple of 8.

The data is given in an array as such:

[1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0]
Note: In the C and NASM languages you are given the third parameter which is the number of segment blocks.
 */
@UtilityClass
public class Reverser {

    private static final int BITS = 8;

    public static int[] dataReverse(int[] data) {
        int blocks = data.length / 8;
        return IntStream.range(0, blocks)
                .mapToObj(chunkIndex -> {
                    int start = chunkIndex * BITS;
                    int end = start + BITS;
                    return Arrays.stream(data, start, end);
                }).toList()
                .reversed()
                .stream()
                .flatMapToInt(Function.identity())
                .toArray();
    }
}
