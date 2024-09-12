package org.czareg.codewars.principal.vs.secondary.diagonal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiagonalWarsTest {

    @Test
    void simpleTest() {
        assertEquals("Secondary Diagonal win!", DiagonalWars.diagonal(
                new int[][]{{2, 2, 2},
                        {4, 2, 6},
                        {8, 8, 2}}));
        assertEquals("Principal Diagonal win!", DiagonalWars.diagonal(
                new int[][]{{2, 2, 2},
                        {4, 2, 6},
                        {1, 8, 2}}));
        assertEquals("Draw!", DiagonalWars.diagonal(
                new int[][]{{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 40; i++) {
            int[][] gArray = generateArray();
            assertEquals(solution(gArray), DiagonalWars.diagonal(gArray));
        }
    }


    private int[][] generateArray() {
        int randLen = 5 + (int) (Math.random() * ((10 - 5) + 1));
        int[][] matrix = new int[randLen][randLen];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);

            }
        }
        return matrix;
    }

    private String solution(int[][] matrix) {
        int principal = 0;
        int secondary = 0;
        for (int i = 0; i < matrix.length; i++) {
            principal += matrix[i][i];
            secondary += matrix[i][matrix.length - i - 1];
        }
        if (principal > secondary) {
            return "Principal Diagonal win!";
        } else if (secondary > principal) {
            return "Secondary Diagonal win!";
        } else {
            return "Draw!";
        }
    }
}