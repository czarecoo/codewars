package org.czareg.codewars.overflowing.with.longing;

import lombok.experimental.UtilityClass;

import java.math.BigInteger;

@UtilityClass
public class Multiplier {

    public static long multiply(long a, long b) {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).longValueExact();
    }
}
