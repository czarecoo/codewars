package org.czareg.codewars.principal.vs.secondary.diagonal;

import lombok.experimental.UtilityClass;

/*
Principal Diagonal -- The principal diagonal in a matrix identifies those elements of the matrix running from North-West to South-East.

Secondary Diagonal -- the secondary diagonal of a matrix identifies those elements of the matrix running from North-East to South-West.

For example:

matrix:             [1, 2, 3]
                    [4, 5, 6]
                    [7, 8, 9]

principal diagonal: [1, 5, 9]
secondary diagonal: [3, 5, 7]
Task
Your task is to find which diagonal is "larger": which diagonal has a bigger sum of their elements.

If the principal diagonal is larger, return "Principal Diagonal win!"
If the secondary diagonal is larger, return "Secondary Diagonal win!"
If they are equal, return "Draw!"
Note: You will always receive matrices of the same dimension.
 */
@UtilityClass
class DiagonalWars {

    private static final String PRINCIPAL_WON = "Principal Diagonal win!";
    private static final String SECONDARY_WON = "Secondary Diagonal win!";
    private static final String DRAW = "Draw!";

    static String diagonal(int[][] matrix) {
        int size = matrix.length;
        int principalSum = 0;
        int secondarySum = 0;
        for (int i = 0; i < size; i++) {
            principalSum += matrix[i][i];
            secondarySum += matrix[i][size - i - 1];
        }
        return prepareResult(principalSum, secondarySum);
    }

    private static String prepareResult(int principalSum, int secondarySum) {
        if (principalSum == secondarySum) {
            return DRAW;
        }
        return principalSum > secondarySum ? PRINCIPAL_WON : SECONDARY_WON;
    }
}
