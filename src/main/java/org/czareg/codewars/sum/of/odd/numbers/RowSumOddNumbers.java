package org.czareg.codewars.sum.of.odd.numbers;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given the triangle of consecutive odd numbers:

             1
          3     5
       7     9    11
   13    15    17    19
21    23    25    27    29
...
Calculate the sum of the numbers in the nth row of this triangle (starting at index 1) e.g.: (Input --> Output)

1 -->  1
2 --> 3 + 5 = 8
 */
@UtilityClass
public class RowSumOddNumbers {

    private static final Map<Integer, List<Integer>> sumByRow = new HashMap<>();

    static {
        sumByRow.put(1, List.of(1));
        sumByRow.put(2, List.of(3, 5));
        sumByRow.put(3, List.of(7, 9, 11));
        sumByRow.put(4, List.of(13, 15, 17, 19));
        sumByRow.put(5, List.of(21, 23, 25, 27, 29));
    }

    public static int rowSumOddNumbers(int n) {
        if (!sumByRow.containsKey(n)) {
            calculateUpToRow(n);
        }
        return sumByRow.get(n)
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static void calculateUpToRow(int n) {
        int row = getHighestCalculatedRow();
        int number = getLastCalculatedNumber(row);
        List<Integer> numbers = new ArrayList<>();
        row++;
        do {
            if (numbers.size() == row) {
                sumByRow.put(row, numbers);
                row++;
                numbers = new ArrayList<>();
            }
            number += 2;
            numbers.add(number);
        } while (row <= n);
    }

    private static Integer getLastCalculatedNumber(int row) {
        List<Integer> numbers = sumByRow.get(row);
        return numbers.get(numbers.size() - 1);
    }

    private static Integer getHighestCalculatedRow() {
        return sumByRow.keySet()
                .stream()
                .reduce(Integer::max)
                .orElseThrow();
    }
}
