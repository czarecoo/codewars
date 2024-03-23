package org.czareg.codewars.more.than.zero;

import lombok.experimental.UtilityClass;

/*
Correct this code so that it takes one argument, x, and returns "x is more than zero" if x is positive (and nonzero),
and otherwise, returns "x is equal to or less than zero." In both cases, replace x with the actual value of x.
 */
@UtilityClass
public class MoreThanZero {

    public static String corrections(int x) {
        if (x > 0) {
            return "%s is more than zero.".formatted(x);
        }
        return "%s is equal to or less than zero.".formatted(x);
    }
}
