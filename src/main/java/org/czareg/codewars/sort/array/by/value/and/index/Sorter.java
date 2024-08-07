package org.czareg.codewars.sort.array.by.value.and.index;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
Sort an array by value and sortingValue
Your task is to sort an array of integer numbers by the product of the value and the sortingValue of the positions.

For sorting the sortingValue starts at 1, NOT at 0!
The sorting has to be ascending.
The array will never be null and will always contain numbers.

Example:

Input: 23, 2, 3, 4, 5
Product of value and sortingValue:
23 => 23 * 1 = 23  -> Output-Pos 4
 2 =>  2 * 2 = 4   -> Output-Pos 1
 3 =>  3 * 3 = 9   -> Output-Pos 2
 4 =>  4 * 4 = 16  -> Output-Pos 3
 5 =>  5 * 5 = 25  -> Output-Pos 5

Output: 2, 3, 4, 23, 5
 */
@UtilityClass
public class Sorter {

    public static int[] sortByValueAndIndex(int[] array) {
        return IntStream.rangeClosed(1, array.length)
                .mapToObj(sortingValue -> {
                    int value = array[sortingValue - 1];
                    return new Pair(value, sortingValue);
                })
                .sorted()
                .mapToInt(Pair::value)
                .toArray();
    }

    record Pair(Integer value, Integer sortingValue) implements Comparable<Pair> {
        @Override
        public int compareTo(Pair o) {
            return Integer.compare(getProduct(), o.getProduct());
        }

        int getProduct() {
            return value * sortingValue;
        }
    }
}
