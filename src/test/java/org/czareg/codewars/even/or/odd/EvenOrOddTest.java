package org.czareg.codewars.even.or.odd;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EvenOrOddTest {

    private static void doTest(int num, String expected) {
        assertEquals(expected, EvenOrOdd.evenOrOdd(num), "Incorrect answer for num = " + num);
    }

    @Test
    @Order(1)
    @DisplayName("Should return \"Odd\" for positive odd inputs")
    void testPositiveOddNumbers() {
        doTest(1, "Odd");
        doTest(7, "Odd");
    }

    @Test
    @Order(1)
    @DisplayName("Should return \"Even\" for positive even inputs")
    void testPositiveEvenNumbers() {
        doTest(2, "Even");
        doTest(42, "Even");
    }

    @Test
    @Order(1)
    @DisplayName("Should return \"Odd\" for negative odd inputs")
    void testNegativeOddNumbers() {
        doTest(-1, "Odd");
        doTest(-7, "Odd");
    }

    @Test
    @Order(1)
    @DisplayName("Should return \"Even\" for negative even inputs")
    void testNegativeEvenNumbers() {
        doTest(-2, "Even");
        doTest(-42, "Even");
    }

    @Test
    @Order(1)
    @DisplayName("Should return \"Even\" for zero")
    void testZero() {
        doTest(0, "Even");
    }

    private record TestCase(int num, String expected) {
    }

    @Test
    @Order(2)
    void randomTests() {
        var rnd = java.util.concurrent.ThreadLocalRandom.current();
        var testCases = new ArrayList<TestCase>();
        for (int i = 0; i < 25; i++) {
            testCases.add(new TestCase(rnd.nextInt(1, 500) * 2, "Even"));
            testCases.add(new TestCase(rnd.nextInt(1, 500) * -2, "Even"));
            testCases.add(new TestCase(rnd.nextInt(1, 500) * 2 + 1, "Odd"));
            testCases.add(new TestCase(rnd.nextInt(1, 500) * -2 - 1, "Odd"));
        }
        Collections.shuffle(testCases);
        for (var testCase : testCases) {
            doTest(testCase.num, testCase.expected);
        }
    }
}