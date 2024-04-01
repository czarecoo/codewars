package org.czareg.codewars.character.counter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCounterTest {

    private static final String RND_BASE = "abcxyz?!cdepqr%^";

    @Test
    void testBasicWords() {
        assertTrue(CharacterCounter.validateWord("abcabc"));
        assertTrue(CharacterCounter.validateWord("Abcabc"));
        assertTrue(CharacterCounter.validateWord("AbcCBa"));
        assertTrue(CharacterCounter.validateWord("?!?!?!"));
        assertTrue(CharacterCounter.validateWord("abc123"));
        assertTrue(CharacterCounter.validateWord("abc!abc!"));
        assertFalse(CharacterCounter.validateWord("AbcabcC"));
        assertFalse(CharacterCounter.validateWord("pippi"));
        assertFalse(CharacterCounter.validateWord("abcabcd"));
        assertFalse(CharacterCounter.validateWord("?abc:abc"));
    }

    @Test
    void testRandomWords() {
        Random random = new Random();
        for (int n = 1; n <= 50; n++) {
            int lettersNumb = random.nextInt(4) + 2;
            char[] basicLetters = new char[lettersNumb];
            for (int k = 0; k < lettersNumb; k++) {
                basicLetters[k] = RND_BASE.charAt(random.nextInt(RND_BASE.length()));
            }

            int repeats = random.nextInt(4) + 1;
            List<Character> letters = new ArrayList<>();
            for (char letter : basicLetters) {
                for (int k = 1; k <= repeats; k++) {
                    letters.add(random.nextBoolean() ? letter : Character.toUpperCase(letter));
                }
            }

            if (random.nextBoolean()) {
                int firstCharRepeats = random.nextInt(3) + 1;
                char firstChar = letters.get(0);
                for (int k = 1; k <= firstCharRepeats; k++) {
                    letters.add(firstChar);
                }
            }

            Collections.shuffle(letters, random);
            StringBuilder builder = new StringBuilder(letters.size());
            letters.forEach(builder::append);
            String randomWord = builder.toString();

            assertEquals(validateWordSolution(randomWord), CharacterCounter.validateWord(randomWord));
        }
    }

    private boolean validateWordSolution(String word) {
        String lowWord = word.toLowerCase();
        int firstCharCount = charCounter(lowWord.charAt(0), lowWord);
        return lowWord.chars().allMatch(c -> charCounter(c, lowWord) == firstCharCount);
    }

    private int charCounter(int c, String word) {
        return word.length() - word.replace(String.valueOf((char) c), "").length();
    }
}