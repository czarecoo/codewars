package org.czareg.codewars.frog.jumping;

import lombok.experimental.UtilityClass;

/*
You have an array of integers and have a frog at the first position

[Frog, int, int, int, ..., int]

The integer itself may tell you the length and the direction of the jump

For instance:
 2 = jump two indices to the right
-3 = jump three indices to the left
 0 = stay at the same position
Your objective is to find how many jumps are needed to jump out of the array.

Return -1 if Frog can't jump out of the array

Example:
array: [1, 2, 1, 5]
jumps = 3  (1 -> 2 -> 5 -> <jump out>)
All tests for this Kata are randomly generated.
 */
@UtilityClass
public class FrogJumping {

    public static int solution(int[] a) {
        int frogCurrentPosition = 0;
        int jumps = 0;
        boolean[] seen = new boolean[a.length];
        for (; ; ) {
            frogCurrentPosition += a[frogCurrentPosition];
            jumps++;
            if (frogCurrentPosition < 0 || frogCurrentPosition >= a.length) {
                return jumps;
            }
            if (seen[frogCurrentPosition]) {
                return -1;
            } else {
                seen[frogCurrentPosition] = true;
            }
        }
    }
}
