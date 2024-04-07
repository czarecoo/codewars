package org.czareg.codewars.histogram;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistogramDrawerTest {

    @Test
    void basic() {
        final String expected = """
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
                """;
        assertEquals(expected, HistogramDrawer.histogram(new int[]{7, 3, 10, 1, 0, 5}));
    }

    @Test
    void zeros() {
        final String expected = """
                -----------
                1 2 3 4 5 6
                """;
        assertEquals(expected, HistogramDrawer.histogram(new int[]{0, 0, 0, 0, 0, 0}));
    }

    @Test
    void random() {
        for (int n = 0; n < 10; n++) {
            int[] results = new int[]{0, 0, 0, 0, 0, 0};
            for (int t = 0; t < 50; t++) {
                int result = (int) (Math.random() * 6) + 1;
                results[result - 1]++;
            }
            assertEquals(solution(results), HistogramDrawer.histogram(results));
        }
    }

    private String solution(final int[] results) {
        final StringBuilder sb = new StringBuilder();
        final int max = IntStream.of(results).max().orElseThrow();
        for (int height = max + 1; height > 0; height--) {
            final StringBuilder line = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                if (results[i] != 0 && results[i] == height - 1) {
                    line.append(results[i]).append(results[i] < 10 ? " " : "");
                } else if (results[i] >= height) {
                    line.append("# ");
                } else {
                    line.append("  ");
                }
            }
            final String trimmed = line.toString().replaceAll("\\s+$", "");
            if (!trimmed.isEmpty()) sb.append(trimmed).append("\n");
        }
        sb.append("-----------\n");
        sb.append("1 2 3 4 5 6\n");
        return sb.toString();
    }
}