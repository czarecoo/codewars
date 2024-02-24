package org.czareg.codewars.spiraling.box;

import lombok.experimental.UtilityClass;

/*
Given two positive integers m (width) and n (height), fill a two-dimensional list (or array) of size m-by-n in the following way:

(1) All the elements in the first and last row and column are 1.

(2) All the elements in the second and second-last row and column are 2, excluding the elements from step 1.

(3) All the elements in the third and third-last row and column are 3, excluding the elements from the previous steps.

And so on ...

Examples
Given m = 5, n = 8, your function should return

[[1, 1, 1, 1, 1],
 [1, 2, 2, 2, 1],
 [1, 2, 3, 2, 1],
 [1, 2, 3, 2, 1],
 [1, 2, 3, 2, 1],
 [1, 2, 3, 2, 1],
 [1, 2, 2, 2, 1],
 [1, 1, 1, 1, 1]]
Given m = 10, n = 9, your function should return

[[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
 [1, 2, 2, 2, 2, 2, 2, 2, 2, 1],
 [1, 2, 3, 3, 3, 3, 3, 3, 2, 1],
 [1, 2, 3, 4, 4, 4, 4, 3, 2, 1],
 [1, 2, 3, 4, 5, 5, 4, 3, 2, 1],
 [1, 2, 3, 4, 4, 4, 4, 3, 2, 1],
 [1, 2, 3, 3, 3, 3, 3, 3, 2, 1],
 [1, 2, 2, 2, 2, 2, 2, 2, 2, 1],
 [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]]
 */
@UtilityClass
public class SpiralingBox {

    public static int[][] createBox(int width, int height) {
        int[][] ints = new int[height][width];
        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            for (int columnIndex = 0; columnIndex < width; columnIndex++) {
                ints[rowIndex][columnIndex] = distanceToEdge(rowIndex, height, columnIndex, width);
            }
        }
        return ints;
    }

    private static int distanceToEdge(int rowIndex, int height, int columnIndex, int width) {
        int horizontal = Math.min(rowIndex + 1, height - rowIndex);
        int vertical = Math.min(columnIndex + 1, width - columnIndex);
        return Math.min(horizontal, vertical);
    }
}
