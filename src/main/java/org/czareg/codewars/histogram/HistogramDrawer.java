package org.czareg.codewars.histogram;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/*
A 6-sided die is rolled a number of times and the results are plotted as a character-based histogram.

Example:

    10
    #
    #
7   #
#   #
#   #     5
#   #     #
# 3 #     #
# # #     #
# # # 1   #
# # # #   #
-----------
1 2 3 4 5 6
Task
You will be passed all the dice roll results, and your task is to write the code to return a string representing a histogram, so that when it is printed it has the same format as the example.

Notes
There are no trailing spaces on the lines
All lines (including the last) end with a newline \n
A count is displayed above each bar (unless the count is 0)
The number of rolls may vary but is always less than 100
*/
@UtilityClass
public class HistogramDrawer {

    public static String histogram(final int[] results) {
        int allRows = calculateRows(results);
        int scoreRows = allRows - 2;
        StringBuilder histogramBuilder = new StringBuilder();
        for (int row = scoreRows; row > 0; row--) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int result : results) {
                int resultRow = result + 1;
                if (row > resultRow) {
                    rowBuilder.append("  ");
                } else if (row < resultRow) {
                    rowBuilder.append("# ");
                } else if (result == 0) {
                    rowBuilder.append("  ");
                } else if (result > 0 && result < 10) {
                    rowBuilder.append(result).append(" ");
                } else if (result >= 10) {
                    rowBuilder.append(result);
                }
            }
            String buildRow = rowBuilder.toString().stripTrailing();
            histogramBuilder.append(buildRow).append("\n");
        }
        histogramBuilder.append("-----------\n");
        histogramBuilder.append("1 2 3 4 5 6\n");
        return histogramBuilder.toString();
    }

    private static int calculateRows(int[] results) {
        int maxResult = IntStream.of(results).max().orElseThrow();
        if (maxResult == 0) {
            return maxResult + 2;
        }
        return maxResult + 3;
    }
}
