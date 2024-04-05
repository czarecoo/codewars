package org.czareg.codewars.how.many.smaller;

import lombok.experimental.UtilityClass;

/*
Write
function smaller(arr)
that given an array arr, you have to return the amount of numbers that are smaller than arr[i] to the right.

For example:

smaller([5, 4, 3, 2, 1]) === [4, 3, 2, 1, 0]
smaller([1, 2, 0]) === [1, 1, 0]
 */
@UtilityClass
public class Smaller {

    public static int[] smaller(int[] unsorted) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int num : unsorted) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        BinaryIndexedTree tree = new BinaryIndexedTree(maxVal - minVal + 2);

        int[] results = new int[unsorted.length];

        for (int i = unsorted.length - 1; i >= 0; i--) {
            int current = unsorted[i] - minVal + 1;
            results[i] = tree.query(current - 1);
            tree.update(current);
        }

        return results;
    }
}

class BinaryIndexedTree {
    private final int[] bit;

    public BinaryIndexedTree(int size) {
        this.bit = new int[size];
    }

    public void update(int index) {
        while (index < bit.length) {
            bit[index]++;
            index += index & -index;
        }
    }

    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }
}