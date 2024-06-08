package org.czareg.codewars.find.the.unique.number;

import lombok.experimental.UtilityClass;

/*
There is an array with some numbers. All numbers are equal except for one. Try to find it!

findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
It’s guaranteed that array contains at least 3 numbers.

The tests contain some very huge arrays, so think about performance.
 */
@UtilityClass
public class Finder {

    public static double findUniq(double[] array) {
        if (array.length < 3) {
            throw new IllegalArgumentException("Array has to have at least 3 elements");
        }
        double repeatingElement = array[array[0] == array[1] ? 0 : 2];
        for (double current : array) {
            if (current != repeatingElement) {
                return current;
            }
        }
        throw new IllegalStateException("No unique element found");
    }
}
