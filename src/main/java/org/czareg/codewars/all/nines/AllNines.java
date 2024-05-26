package org.czareg.codewars.all.nines;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;

/*
Given any positive integer x ≤ 4000, find the smallest positive integer m such that mx consists of all 9's. Return -1 if no such m exists.

Examples:
NOTE: Although x ≤ 4000, m can be very very LARGE. Where necessary, the way of handling big integers appropriate to the language should be used.
 */
@UtilityClass
public class AllNines {

    private static final BigInteger NINE = BigInteger.valueOf(9);

    public static BigInteger allNines(BigInteger x) {
        int maxDigits = Math.max(2, x.intValue());
        BigInteger xm = NINE;
        for (int i = 1; i < maxDigits; i++) {
            BigInteger reminder = xm.remainder(x);
            if (reminder.equals(BigInteger.ZERO)) {
                return xm.divide(x);
            }
            xm = xm.multiply(BigInteger.TEN).add(NINE);
        }
        return BigInteger.valueOf(-1);
    }
}
