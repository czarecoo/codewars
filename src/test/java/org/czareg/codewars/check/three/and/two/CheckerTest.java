package org.czareg.codewars.check.three.and.two;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    void fixedTests() {
        assertTrue(Checker.checkThreeAndTwo(new char[]{'a', 'a', 'b', 'b', 'b'}));
        assertFalse(Checker.checkThreeAndTwo(new char[]{'a', 'c', 'a', 'c', 'b'}));
        assertFalse(Checker.checkThreeAndTwo(new char[]{'a', 'a', 'a', 'a', 'a'}));
    }

    @Test
    void randomTests() {
        Random random = new Random();
        char[] availableChars = new char[]{'a', 'b', 'c'};

        for (int i = 0; i < 50; i++) {
            char[] randomChars = new char[5];
            for (int j = 0; j < 5; j++) {
                randomChars[j] = availableChars[random.nextInt(3)];
            }

            assertEquals(
                    new TestSolution().checkThreeAndTwo(randomChars),
                    Checker.checkThreeAndTwo(randomChars)
            );
        }
    }

    private static final class TestSolution {

        public boolean checkThreeAndTwo(char[] chars) {
            Map<Character, Integer> occurences = new HashMap<>();

            for (char character : chars) {
                if (occurences.containsKey(character)) {
                    occurences.put(character, occurences.get(character) + 1);
                } else {
                    occurences.put(character, 1);
                }
            }

            boolean hasTwo = false;
            boolean hasThree = false;

            for (char character : occurences.keySet()) {
                if (occurences.get(character) == 2) hasTwo = true;
                if (occurences.get(character) == 3) hasThree = true;
            }

            return hasTwo && hasThree;
        }
    }
}