package org.czareg.codewars.grade.book;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraderTest {

    @Test
    void testA() {
        doTest(95, 90, 93, 'A');
        doTest(100, 85, 96, 'A');
        doTest(92, 93, 94, 'A');
        doTest(100, 100, 100, 'A');
    }

    @Test
    void testB() {
        doTest(70, 70, 100, 'B');
        doTest(82, 85, 87, 'B');
        doTest(84, 79, 85, 'B');
    }

    @Test
    void testC() {
        doTest(70, 70, 70, 'C');
        doTest(75, 70, 79, 'C');
        doTest(60, 82, 76, 'C');
    }

    @Test
    void testD() {
        doTest(65, 70, 59, 'D');
        doTest(66, 62, 68, 'D');
        doTest(58, 62, 70, 'D');
    }

    @Test
    void testF() {
        doTest(44, 55, 52, 'F');
        doTest(48, 55, 52, 'F');
        doTest(58, 59, 60, 'F');
        doTest(0, 0, 0, 'F');
    }

    @Test
    void randomTests() {
        Random rand = new Random();
        for (int i = 0; i < 100; ++i) {
            int a = rand.nextInt(0, 101);
            int b = rand.nextInt(0, 101);
            int c = rand.nextInt(0, 101);
            doTest(a, b, c, solution(a, b, c));
        }
    }

    private char solution(int s1, int s2, int s3) {
        double score = (s1 + s2 + s3) / 3.0;
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }

    private static void doTest(int a, int b, int c, char expected) {
        char actual = Grader.getGrade(a, b, c);
        String message = String.format("for grades %d, %d, %d%n", a, b, c);
        assertEquals(expected, actual, message);
    }
}