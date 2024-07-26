package org.czareg.codewars.rotten.oranges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RottenOrangesTest {

    @Test
    void test1() {
        assertEquals(0, RottenOranges.calcRotTime(new int[][]{
                new int[]{2, 2, 2, 2, 2},
                new int[]{2, 2, 2, 2, 2},
                new int[]{2, 2, 2, 2, 2}
        }));
    }

    @Test
    void test2() {
        assertEquals(-1, RottenOranges.calcRotTime(new int[][]{
                new int[]{1}
        }));
    }

    @Test
    void test3() {
        assertEquals(10, RottenOranges.calcRotTime(new int[][]{
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        }));
    }

    @Test
    void test4() {
        assertEquals(-1, RottenOranges.calcRotTime(new int[][]{
                new int[]{2, 2, 2, 2, 2},
                new int[]{2, 2, 0, 2, 2},
                new int[]{2, 0, 1, 0, 2},
                new int[]{2, 2, 0, 2, 2},
        }));
    }

    @Test
    void test5() {
        assertEquals(15, RottenOranges.calcRotTime(new int[][]{
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}
        }));
    }

    @Test
    void test6() {
        assertEquals(7, RottenOranges.calcRotTime(new int[][]{
                new int[]{2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}
        }));
    }

    @Test
    void someRandomTests() {
        int randomTests = 100;
        while (randomTests-- > 0) {
            int[][] orangeBox = createRandomOrangeBox();
            int expected = calcRotTime(orangeBox);
            assertEquals(expected, RottenOranges.calcRotTime(orangeBox));
        }
    }

    private static int[][] createRandomOrangeBox() {
        int[][] orangeBox = new int[5][5];
        for (int index = 0; index < 5; index++) {
            orangeBox[index] = getRandomArray();
        }
        return orangeBox;
    }

    private static int[] getRandomArray() {
        int[] arr = new int[5];
        for (int index = 0; index < 5; index++) {
            int ranNum = 1;
            //Put some rotten oranges in box and leave some spaces empty. But not too many...10-30% ok
            if (ThreadLocalRandom.current().nextInt(10) == 0) {
                ranNum = 0;
            }
            if (ThreadLocalRandom.current().nextInt(30) == 0) {
                ranNum = 2;
            }
            arr[index] = ranNum;
        }
        return arr;
    }

    static int[][] oranges;
    static int[][] oranges_tmp;
    static int rotCounter = 0;

    private static int calcRotTime(int[][] orangeBox) {
        oranges = deepCopy(orangeBox);
        int ticCounter = 0;
        boolean neighboursDidRot = true;

        while (neighboursDidRot) {
            neighboursDidRot = rotNeighbours();
            if (neighboursDidRot) ticCounter++;
        }

        if (freshOrangesStillExist()) {
            return -1;
        } else {
            return ticCounter;
        }

    }

    private static boolean freshOrangesStillExist() {
        for (int[] orange : oranges) {
            for (int column = 0; column < oranges[0].length; column++) {
                int currentOrange = orange[column];
                if (currentOrange == 1) {
                    return true; //Orange is fresh
                }
            }
        }
        return false;
    }

    private static boolean rotNeighbours() {
        rotCounter = 0;
        oranges_tmp = deepCopy(oranges);
        for (int row = 0; row < oranges.length; row++) {
            for (int column = 0; column < oranges[0].length; column++) {
                int currentOrange = oranges[row][column];
                if (currentOrange == 2) { //Orange is rotten
                    rotSingleOrange(row - 1, column); //upper
                    rotSingleOrange(row + 1, column); //lower
                    rotSingleOrange(row, column + 1); //right side
                    rotSingleOrange(row, column - 1); //left side
                }

            }
        }
        oranges = deepCopy(oranges_tmp);
        return rotCounter > 0;
    }

    private static void rotSingleOrange(int row, int column) {
        boolean inBounds = (row < oranges.length && row >= 0
                && column < oranges[0].length && column >= 0);
        if (inBounds) {
            int orange = oranges[row][column];
            if (orange == 1) {
                oranges_tmp[row][column] = 2;
                rotCounter++;
            }
        }
    }

    static int[][] deepCopy(int[][] orangesArrays) {
        return Arrays.stream(orangesArrays).map(int[]::clone).toArray($ -> orangesArrays.clone());
    }
}