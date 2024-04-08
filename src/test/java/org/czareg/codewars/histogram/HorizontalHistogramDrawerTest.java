package org.czareg.codewars.histogram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HorizontalHistogramDrawerTest {

    @Test
    void basic() {
        String expected = """
                6|##### 5
                5|
                4|# 1
                3|########## 10
                2|### 3
                1|####### 7
                """;
        assertEquals(expected, HorizontalHistogramDrawer.histogram(new int[]{7, 3, 10, 1, 0, 5}));
    }

    @Test
    void zeros() {
        String expected = """
                6|
                5|
                4|
                3|
                2|
                1|
                """;
        assertEquals(expected, HorizontalHistogramDrawer.histogram(new int[]{0, 0, 0, 0, 0, 0}));
    }

    @Test
    void random() {
        for (int n = 0; n < 10; n++) {
            int[] results = new int[]{0, 0, 0, 0, 0, 0};
            for (int t = 0; t < 50; t++) {
                int result = (int) (Math.random() * 6) + 1;
                results[result - 1]++;
            }
            assertEquals(solution(results), HorizontalHistogramDrawer.histogram(results));
        }
    }

    private String solution(final int[] results) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 6; i >= 1; i--) {
            sb.append(i).append("|");
            final int count = results[i - 1];
            if (count > 0) {
                sb.append("#".repeat(count));
                sb.append(" ").append(count);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}