package org.czareg.codewars.duplicate.encoder;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicateEncoderTest {

    public static final String CHAR_SET = "abcdefghijklMNOPQRSTUVWXYZ1234567890)(*&^% `<>?/}{+=";

    public String makeWord() {
        StringBuilder testWord = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < r.nextInt(10) + 1; i++) {
            testWord.append(CHAR_SET.charAt(r.nextInt(CHAR_SET.length())));
        }
        return testWord.toString();
    }

    String e(String word) {
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (word.lastIndexOf(ch) == word.indexOf(ch)) {
                result = result.concat("(");
            } else {
                result = result.concat(")");
            }
        }
        return result;
    }

    @Test
    void test() {

        String[] randomTests = {makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord()};

        for (String test : randomTests) {
            assertEquals(e(test), DuplicateEncoder.encode(test));
        }


        assertEquals(")()))()))))()(", DuplicateEncoder.encode("Supralapsarian"));
        assertEquals(")))))(", DuplicateEncoder.encode(" ( ( )"));
        assertEquals("((((", DuplicateEncoder.encode("walk"));
        assertEquals("))))))", DuplicateEncoder.encode("Hannah"));
        assertEquals("))(", DuplicateEncoder.encode("$$\\"));
        assertEquals("(", DuplicateEncoder.encode("|"));

    }
}