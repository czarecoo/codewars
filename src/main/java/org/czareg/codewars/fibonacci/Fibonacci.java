package org.czareg.codewars.fibonacci;

import lombok.experimental.UtilityClass;

import java.util.HashMap;

@UtilityClass
public class Fibonacci {

    private static final HashMap<Integer, Long> RESULTS = new HashMap<>();

    public static long fib(int n) {
        if (n <= 2) {
            return 1;
        }
        if (RESULTS.containsKey(n)) {
            return RESULTS.get(n);
        }
        long result = fib(n - 1) + fib(n - 2);
        RESULTS.put(n, result);
        return result;
    }
}
