package org.czareg.codewars.reverse.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @Test
    void basicTestCases() {
        assertEquals(List.of(1, 2, 3, 4, 5), FizzBuzz.reverseFizzBuzz("1 2 Fizz 4 Buzz"));
        assertEquals(List.of(687, 688, 689, 690), FizzBuzz.reverseFizzBuzz("Fizz 688 689 FizzBuzz"));
        assertEquals(List.of(9, 10), FizzBuzz.reverseFizzBuzz("Fizz Buzz"));
    }

    @Test
    void edgeCases() {
        assertEquals(List.of(3), FizzBuzz.reverseFizzBuzz("Fizz"));
        assertEquals(List.of(5), FizzBuzz.reverseFizzBuzz("Buzz"));
        assertEquals(List.of(5, 6), FizzBuzz.reverseFizzBuzz("Buzz Fizz"));
        assertEquals(List.of(9, 10), FizzBuzz.reverseFizzBuzz("Fizz Buzz"));
        assertEquals(List.of(15), FizzBuzz.reverseFizzBuzz("FizzBuzz"));
    }

    @Test
    void randomTests() {
        final Random random = new Random();
        final int numTests = 200;

        for (int i = 0; i < numTests; i++) {
            final int start = random.nextInt(300000);
            final int end = start + random.nextInt(100);
            final String testString = createString(start, end);
            final List<Integer> expected = switch (testString) {
                case "Fizz" -> List.of(3);
                case "Buzz" -> List.of(5);
                case "Buzz Fizz" -> List.of(5, 6);
                case "Fizz Buzz" -> List.of(9, 10);
                case "FizzBuzz" -> List.of(15);
                default -> IntStream.range(start, end).boxed().toList();
            };

            assertEquals(expected, FizzBuzz.reverseFizzBuzz(testString));
        }
    }

    private static String createString(int a, int b) {
        final StringBuilder sBuilder = new StringBuilder();
        boolean first = true;
        for (int j = a; j < b; j++) {
            if (!first) {
                sBuilder.append(" ");
            } else {
                first = false;
            }
            if (j % 3 == 0 && j % 5 == 0) {
                sBuilder.append("FizzBuzz");
            } else if (j % 3 == 0) {
                sBuilder.append("Fizz");
            } else if (j % 5 == 0) {
                sBuilder.append("Buzz");
            } else {
                sBuilder.append(j);
            }
        }
        return sBuilder.toString();
    }
}