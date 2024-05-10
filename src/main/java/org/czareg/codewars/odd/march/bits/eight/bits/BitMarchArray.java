package org.czareg.codewars.odd.march.bits.eight.bits;

import lombok.experimental.UtilityClass;

import java.util.Deque;
import java.util.LinkedList;

/*
Odd bits are getting ready for Bits Battles.

Therefore the n bits march from right to left along an 8 bits path. Once the most-significant bit reaches the left
their march is done. Each step will be saved as an array of 8 integers.

Return an array of all the steps.

1 <= n <= 8

NOTE: n != 0, because n represents the number of 1s.

Examples
This resembles a simple 8 LED chaser:

n = 3

00000111
00001110
00011100
00111000
01110000
11100000
n = 7

01111111
11111110
 */
@UtilityClass
public class BitMarchArray {

    private static final int PATH_LENGTH = 8;

    public static int[][] bitMarch(int ones) {
        Deque<Deque<Integer>> results = new LinkedList<>();
        results.addLast(createFirstStep(ones));
        while (results.getLast().getFirst() != 1) {
            results.addLast(shiftLeft(results.getLast()));
        }
        return toArray(results);
    }

    private static Deque<Integer> createFirstStep(int ones) {
        Deque<Integer> step = new LinkedList<>();
        int zeros = PATH_LENGTH - ones;
        for (int i = 1; i <= PATH_LENGTH; i++) {
            if (i <= zeros) {
                step.addLast(0);
            } else {
                step.addLast(1);
            }
        }
        return step;
    }

    private static Deque<Integer> shiftLeft(Deque<Integer> last) {
        Deque<Integer> step = new LinkedList<>(last);
        step.removeFirst();
        step.addLast(0);
        return step;
    }

    private static int[][] toArray(Deque<Deque<Integer>> results) {
        return results.stream()
                .map(subDeque -> subDeque.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
    }
}
