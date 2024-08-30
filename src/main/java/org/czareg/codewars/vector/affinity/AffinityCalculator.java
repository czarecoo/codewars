package org.czareg.codewars.vector.affinity;

import lombok.experimental.UtilityClass;

import java.util.OptionalInt;

/*
Calculate the number of items in a vector that appear at the same index in each vector, with the same value.

  ([1 2 3 4 5], [1 2 2 4 3]) => 0.6
  ([1 2 3], [1 2 3]) => 1.0
Affinity value should be realized on a scale of 0.0 to 1.0, with 1.0 being absolutely identical.
Two identical sets should always be evaluated as having an affinity of 1.0.

Hint: The last example test case holds a significant clue to calculating the affinity correctly.
 */
@UtilityClass
public class AffinityCalculator {

    public static double vectorAffinity(int[] xs, int[] ys) {
        if (xs.length == 0 && ys.length == 0) {
            return 1.0;
        }
        if (xs.length == 0 || ys.length == 0) {
            return 0.0;
        }
        double maxLength = Math.max(xs.length, ys.length);
        double matching = maxLength;
        for (int index = 0; index < maxLength; index++) {
            OptionalInt x = getValue(xs, index);
            OptionalInt y = getValue(ys, index);
            if (!x.equals(y)) {
                matching--;
            }
        }
        return matching / maxLength;
    }

    private static OptionalInt getValue(int[] arr, int index) {
        if (index >= arr.length) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(arr[index]);
    }
}
