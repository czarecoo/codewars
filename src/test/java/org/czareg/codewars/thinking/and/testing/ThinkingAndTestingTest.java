package org.czareg.codewars.thinking.and.testing;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThinkingAndTestingTest {

    @Test
    void exampleTests() {
        assertEquals(1, ThinkingAndTesting.testAB(0, 1));
        assertEquals(3, ThinkingAndTesting.testAB(1, 2));
        assertEquals(30, ThinkingAndTesting.testAB(10, 20));
        assertEquals(1, ThinkingAndTesting.testAB(1, 1));
        assertEquals(3, ThinkingAndTesting.testAB(1, 3));
    }

    @Test
    void fixedTests() {
        tester(2, 2);
        tester(11, 22);
        tester(123, 456);
        tester(0, 1000);
    }

    @Test
    void randomTests() {
        final Random random = new Random();
        for (int k = 1; k <= 100; k++) {
            tester(random.nextInt(1001), random.nextInt(1001));
        }
    }

    private void tester(int a, int b) {
        assertEquals(solution(a, b), ThinkingAndTesting.testAB(a, b));
    }

    private int solution(int a, int b) {
        return a | b;
    }
}