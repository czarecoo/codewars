package org.czareg.codewars.middle.finder;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiddleStringFinderTest {

    @Test
    void basicTests() {
        assertEquals("es", MiddleStringFinder.getMiddle("test"));
        assertEquals("dd", MiddleStringFinder.getMiddle("middle"));
        assertEquals("t", MiddleStringFinder.getMiddle("testing"));
        assertEquals("A", MiddleStringFinder.getMiddle("A"));
    }

    private String middle(String word) {
        int mid = word.length() / 2;
        return (word.length() % 2 == 1 ? word.substring(mid, mid + 1) : word.substring(mid - 1, mid + 1));
    }

    @Test
    void randTests() {
        Random randGen = new Random();
        String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 50; i++) {
            int randLength = randGen.nextInt(1000) + 1;
            StringBuilder testWord = new StringBuilder();
            for (int e = 0; e < randLength; e++) {
                int alphI = randGen.nextInt(alph.length());
                testWord.append(alph.charAt(alphI));
            }
            String expected = middle(testWord.toString());
            String actual = MiddleStringFinder.getMiddle(testWord.toString());
            assertEquals(expected, actual);
        }
    }
}