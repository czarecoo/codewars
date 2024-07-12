package org.czareg.codewars.sum.of.angles

/*
Find the total sum of internal angles (in degrees) in an n-sided simple polygon. N will be greater than 2.
 */

class Angler {

    static def angle(n) {
        if (n <= 2) {
            throw new IllegalArgumentException("Number of sides must be greater than 2")
        }
        (n - 2) * 180
    }
}
