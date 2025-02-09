package org.czareg.codewars.find.single.non.duplicate.number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindTheSingleNonDuplicateNumberTest {

    static Stream<Arguments> basicTests() {
        return Stream.of(
                arguments(Stream.of(1), 1),
                arguments(Stream.of(1, 1, 2), 2),
                arguments(Stream.of(1, 1, 2, 2, 3), 3),
                arguments(Stream.of(1, 1, 2, 3, 3, 4, 4, 8, 8), 2)
        );
    }

    @ParameterizedTest(name = "expected result: {1}")
    @MethodSource
    void basicTests(Stream<Integer> numbers, int expected) {
        ArrayList<Integer> input = numbers.collect(Collectors.toCollection(ArrayList::new));

        Integer result = FindTheSingleNonDuplicateNumber.singleNonDuplicate(input);

        assertEquals(expected, result);
    }
}