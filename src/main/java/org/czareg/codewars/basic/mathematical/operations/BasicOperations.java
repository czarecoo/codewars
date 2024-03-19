package org.czareg.codewars.basic.mathematical.operations;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

/*
Your task is to create a function that does four basic mathematical operations.

The function should take three arguments - operation(string/char), value1(number), value2(number).
The function should return result of numbers after applying the chosen operation.

Examples(Operator, value1, value2) --> output
('+', 4, 7) --> 11
('-', 15, 18) --> -3
('*', 5, 5) --> 25
('/', 49, 7) --> 7
 */
@UtilityClass
public class BasicOperations {

    private static final Map<String, BinaryOperator<Integer>> OPS = Map.of(
            "+", Integer::sum,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
    );

    public static Integer basicMath(String op, int v1, int v2) {
        return Optional.ofNullable(OPS.get(op))
                .orElseThrow()
                .apply(v1, v2);
    }
}
