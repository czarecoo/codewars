package org.czareg.codewars.sum.of.numbers;

import java.util.stream.IntStream;

class Sum {

    static int getSum(int a, int b) {
        if (a == b) {
            return a;
        }
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        return IntStream.rangeClosed(start, end)
                .sum();
    }
}
