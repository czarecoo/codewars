package org.czareg.codewars.multiply;

import lombok.experimental.UtilityClass;

/*
This code does not execute properly. Try to figure out why.
 */
@UtilityClass
public class Multiply {

    public static Double multiply(Double a, Double b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        return a * b;
    }
}
