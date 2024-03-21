package org.czareg.codewars.divisors.of.a.number;

import java.util.stream.IntStream;

public class FindDivisor {

    public long numberOfDivisors(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .count();
    }
}
