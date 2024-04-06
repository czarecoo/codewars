package org.czareg.codewars.html.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HtmlColorParserTest {

    private HtmlColorParser parser;

    @BeforeEach
    public void setup() {
        parser = new HtmlColorParser(PresetColors.getMap());
    }

    @Test
    void testExamples() {
        shouldParse("#80FFA0", new RGB(128, 255, 160));
        shouldParse("#3B7", new RGB(51, 187, 119));
        shouldParse("LimeGreen", new RGB(50, 205, 50));
    }

    private void shouldParse(String color, RGB expected) {
        assertRgbEquals(color, expected, parser.parse(color));
    }

    private static void assertRgbEquals(String input, RGB expected, RGB actual) throws AssertionError {
        try {
            assertEquals(expected, actual);
        } catch (AssertionError e) {
            String message = String.format(Locale.ENGLISH,
                    "expected: %s\nactual  : %s", expected, actual);
            throw new AssertionError(message, e);
        }
    }
}