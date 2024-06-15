package org.czareg.codewars.get.character.from.ascii.value;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AsciiTest {

    @Test
    void testChar() {
        assertEquals('7', Ascii.getChar(55));
        assertEquals('8', Ascii.getChar(56));
        assertEquals('9', Ascii.getChar(57));
        assertEquals(':', Ascii.getChar(58));
        assertEquals(';', Ascii.getChar(59));
        assertEquals('<', Ascii.getChar(60));
        assertEquals('=', Ascii.getChar(61));
        assertEquals('>', Ascii.getChar(62));
        assertEquals('?', Ascii.getChar(63));
        assertEquals('@', Ascii.getChar(64));
        assertEquals('A', Ascii.getChar(65));
        assertEquals(0, Character.compare('!', Ascii.getChar(33)));
    }

    @Test
    void random() {
        Random r = new Random();
        for (int i = 1; i <= 100; i++) {
            int random = 32 + r.nextInt(95);
            char expected = (char) random;
            assertEquals(expected, Ascii.getChar(random));
        }
    }
}