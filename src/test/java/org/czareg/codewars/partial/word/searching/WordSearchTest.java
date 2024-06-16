package org.czareg.codewars.partial.word.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class WordSearchTest {

    @Test
    void test() {
        String[] test1 = {"lemonade", "limeade", "Yoo-Hoo", "root beer", "grapeade ", "water", "Mr. Pibb"};
        String[] test1results = {"lemonade", "limeade", "grapeade "};
        String[] test2results = {"Tin + Oxygen", "lox"};
        String[] test3results = {"Empty"};
        assertArrayEquals(test1results, WordSearch.findWord("ade", test1));
        String[] test2 = new String[320];
        for (int i = 0; i < 320; i++) {
            test2[i] = "o x";
        }
        test2[303] = "lox";
        test2[70] = "Tin + Oxygen";
        assertArrayEquals(test2results, WordSearch.findWord("ox", test2));
        assertArrayEquals(test3results, WordSearch.findWord("   ", test1));
    }
}