package org.czareg.codewars.quadrant;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QuadrantFinderTest {

    @ParameterizedTest(name = "Quadrant {0}: ({1}, {2})")
    @CsvSource(textBlock = """
                  1,       1,   2
                  1,       3,   5
                  2,     -10, 100
                  3,      -1,  -9
                  4,      19, -56
            """)

    @DisplayName("Fixed tests")
    @Order(1)
    void fixedTests(int expected, int x, int y) {
        assertEquals(expected, QuadrantFinder.quadrant(x, y));
    }

    @Test
    @DisplayName("Small random tests")
    @Order(2)
    void smallRandomTests() {
        for (int run = 0; run < 10; run++) {
            randomTest(100);
        }
    }

    @Test
    @DisplayName("Large random tests")
    @Order(3)
    void largeRandomTests() {
        for (int run = 0; run < 100; run++) {
            randomTest(1000);
        }
    }

    private void randomTest(int max) {
        var rnd = ThreadLocalRandom.current();
        int x = rnd.nextInt(1, max) * (rnd.nextBoolean() ? 1 : -1);
        int y = rnd.nextInt(1, max) * (rnd.nextBoolean() ? 1 : -1);
        int expected = solution(x, y);
        assertEquals(expected, QuadrantFinder.quadrant(x, y), String.format("For input (%d, %d)", x, y));
    }

    private static int solution(int x, int y) {
        return x > 0 ? y > 0 ? 1 : 4 : y > 0 ? 2 : 3;
    }
}