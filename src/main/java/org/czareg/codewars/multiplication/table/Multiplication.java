package org.czareg.codewars.multiplication.table;

import lombok.experimental.UtilityClass;

/*
Your task, is to create N×N multiplication table, of size provided in parameter.

For example, when given size is 3:

1 2 3
2 4 6
3 6 9
For the given example, the return value should be:

[[1,2,3],[2,4,6],[3,6,9]]
 */
@UtilityClass
public class Multiplication {

    public static int[][] multiplicationTable(int size) {
        int[][] array = new int[size][size];
        for (int rowValue = 1; rowValue <= size; rowValue++) {
            for (int columnValue = 1; columnValue <= size; columnValue++) {
                int rowIndex = rowValue - 1;
                int columnIndex = columnValue - 1;
                array[rowIndex][columnIndex] = rowValue * columnValue;
            }
        }
        return array;
    }
}
