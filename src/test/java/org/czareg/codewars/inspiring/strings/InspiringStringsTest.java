package org.czareg.codewars.inspiring.strings;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InspiringStringsTest {

    @Test
    void basicTests() {
        assertEquals("fgh", InspiringStrings.longestWord("a b c d e fgh"));
        assertEquals("three", InspiringStrings.longestWord("one two three"));
        assertEquals("grey", InspiringStrings.longestWord("red blue grey"));
        assertEquals("each", InspiringStrings.longestWord("a b c d each"));
        assertEquals("step", InspiringStrings.longestWord("each step"));
        assertEquals("forward", InspiringStrings.longestWord("forward each step going"));
        assertEquals("brings", InspiringStrings.longestWord("brings each step going"));
        assertEquals("opportunity", InspiringStrings.longestWord("brings each opportunity step going"));
    }

    @Test
    void randTests() {
        Random rand = new Random();
        for (int i = 0; i < 25; i++) {
            int numWords = rand.nextInt(8) + 1;
            String maxWord = getRandWord(rand);
            StringBuilder sb = new StringBuilder(maxWord);
            for (int w = 0; w < numWords; w++) {
                String word = getRandWord(rand);
                if (word.length() >= maxWord.length()) {
                    maxWord = word;
                }
                sb.append(' ');
                sb.append(word);
            }
            assertEquals(maxWord, InspiringStrings.longestWord(sb.toString()));
        }
    }

    private String getRandWord(Random rand) {
        int wordLen = rand.nextInt(16) + 1;
        char[] wordArr = new char[wordLen];
        for (int i = 0; i < wordLen; i++) {
            wordArr[i] = (char) (rand.nextInt(26) + 97);
        }
        return new String(wordArr);
    }
}