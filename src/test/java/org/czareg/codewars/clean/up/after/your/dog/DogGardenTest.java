package org.czareg.codewars.clean.up.after.your.dog;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DogGardenTest {

    @Test
    @DisplayName("Fixed Tests")
    @Order(1)
    void fixedTests() {
        doTest("Clean", new char[][]{{'_', '_', '_', '_'}, {'_', '_', '_', '@'}, {'_', '_', '@', '_'}}, 2, 2);
        doTest("Cr@p", new char[][]{{'_', '_', '_', '_'}, {'_', '_', '_', '@'}, {'_', '_', '@', '_'}}, 1, 1);
        doTest("Dog!!", new char[][]{{'_', '_'}, {'_', '@'}, {'D', '_'}}, 2, 2);
        doTest("Clean", new char[][]{{'_', '_', '_', '_'}, {'_', '_', '_', '_'}, {'_', '_', '_', '_'}}, 2, 2);
        doTest("Clean", new char[][]{{'@', '@'}, {'@', '@'}, {'@', '@'}}, 3, 2);
    }


    @Test
    @DisplayName("Random Tests")
    @Order(2)
    void randomTests() {
        Random rand = new Random();
        char[] base = {'@', '_', '_', '_', '_', '_', '_', '@', '_', '_', '_', '_', '_', '_', 'D'};

        for (int i = 0; i++ < 40; ) {
            int lines = rand.nextInt(2, 9);
            int items = rand.nextInt(1, 5);
            char[][] garden = new char[lines][items];

            for (int line = 0; line < lines; ++line) {
                for (int item = 0; item < items; ++item) {
                    garden[line][item] = base[rand.nextInt(base.length)];
                }
            }

            int bags = rand.nextInt(9);
            int cap = rand.nextInt(9);

            assertEquals(solution(garden, bags, cap), DogGarden.crap(garden, bags, cap), String.format("Incorrect answer for garden = %s", Arrays.deepToString(garden)));
        }
    }

    void doTest(String expected, char[][] garden, int bags, int cap) {
        assertEquals(expected, DogGarden.crap(garden, bags, cap), String.format("Incorrect answer for garden = %s", Arrays.deepToString(garden)));
    }

    String solution(char[][] garden, int bags, int cap) {
        int numberOfShits = 0;
        for (char[] line : garden) {
            for (char c : line) {
                if (c == 'D') {
                    return "Dog!!";
                }
                if (c == '@') {
                    ++numberOfShits;
                }
            }
        }
        return numberOfShits <= (bags * cap) ? "Clean" : "Cr@p";
    }
}