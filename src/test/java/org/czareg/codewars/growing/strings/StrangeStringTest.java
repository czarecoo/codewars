package org.czareg.codewars.growing.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StrangeStringTest {

    @Test
    void upDownCheck() {
        String original = StrangeString.STRANGE_STRING;
        String upDown = original.toUpperCase();
        int length = original.length();
        int upDownLength = upDown.length();
        assertTrue(upDownLength > length, createMessage(original, upDown));
    }

    private static String createMessage(String original, String upDown) {
        return "%s%n%s%n%d%n%d".formatted(original, upDown, original.length(), upDown.length());
    }
}