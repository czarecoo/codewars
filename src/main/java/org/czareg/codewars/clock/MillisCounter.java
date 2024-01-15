package org.czareg.codewars.clock;

import lombok.experimental.UtilityClass;

import java.time.Duration;
import java.time.LocalTime;

/*
Clock shows h hours, m minutes and s seconds after midnight.

Your task is to write a function which returns the time since midnight in milliseconds.

Example:
h = 0
m = 1
s = 1

result = 61000
Input constraints:

0 <= h <= 23
0 <= m <= 59
0 <= s <= 59

 */
@UtilityClass
public class MillisCounter {

    public static int past(int h, int m, int s) {
        if (h < 0 || h > 23 || m < 0 || m > 59 || s < 0 || s > 59) {
            throw new IllegalArgumentException();
        }
        return (int) Duration.between(LocalTime.MIDNIGHT, LocalTime.of(h, m, s, 0)).toMillis();
    }
}
