package org.czareg.codewars.array.diff;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Set;
import java.util.function.IntPredicate;

import static java.util.stream.Collectors.toSet;

/*
Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.

It should remove all values from list A, which are present in list B keeping their order.

(1, 2), (1) => (2)
If a value is present in b, all of its occurrences must be removed from the other:

(1, 2, 2, 2, 3), (2) => (1, 3)
 */
@UtilityClass
public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {
        Set<Integer> toRemove = Arrays.stream(b)
                .boxed()
                .collect(toSet());
        IntPredicate notContained = toRemove::contains;
        return Arrays.stream(a)
                .filter(notContained.negate())
                .toArray();
    }
}
