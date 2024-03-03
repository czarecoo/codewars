package org.czareg.codewars.twice.as.old;

import lombok.experimental.UtilityClass;

/*
Your function takes two arguments:

current father's age (years)
current age of his son (years)
Calculate how many years ago the father was twice as old as his son (or in how many years he will be twice as old).
The answer is always greater or equal to 0, no matter if it was in the past or it is in the future.
 */
@UtilityClass
public class TwiceAsOld {

    public static int calculate(int dadYears, int sonYears) {
        return Math.abs(2 * sonYears - dadYears);
    }
}
