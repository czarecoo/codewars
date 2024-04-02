package org.czareg.codewars.colored.hexes;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ColoredHexTest {

    public static String[] colorCodes = new String[]{"black", "red", "green", "yellow", "blue", "magenta", "cyan", "white"};

    @DisplayName("Fixed Tests")
    @Order(0)
    @ParameterizedTest(name = "hexColor(\"{0}\")")
    @CsvSource({
            "'121 245 255', blue",
            "'027 100 100', cyan",
            "'031 031 007', yellow",
            "'000 000 000', black",
            "'001 000 000', red",
            "'072 072 072', white",
            "'121 147 021', green",
            "'212 103 212', magenta",
            "'', black"
    })
    void fixedTests(String colorCode, String ans) {
        Assertions.assertEquals(ans, ColoredHex.hexColor(colorCode));
    }

    @DisplayName("Random Tests")
    @Order(1)
    @Test()
    void randomTests() {
        Random rand = new Random();
        final int COLOR_CODE_MAX = 255;
        final int NUM_TESTCASES = 100;
        for (int i = 0; i < NUM_TESTCASES; i++) {
            int colorIndex = rand.nextInt(colorCodes.length);
            String colorCode;
            if (colorIndex != 0) {
                int max = rand.nextInt(1, COLOR_CODE_MAX + 1);
                int c0 = (colorIndex & 1) == 1 ? max : rand.nextInt(0, max);
                int c1 = (colorIndex & 2) == 2 ? max : rand.nextInt(0, max);
                int c2 = (colorIndex & 4) == 4 ? max : rand.nextInt(0, max);
                colorCode = String.format("%03d", c0) + ' ' + String.format("%03d", c1) + ' ' + String.format("%03d", c2);
            } else {
                colorCode = rand.nextBoolean() ? "000 000 000" : "";
            }
            Assertions.assertEquals(colorCodes[colorIndex], ColoredHex.hexColor(colorCode), "Failed hexColor(\"" + colorCode + "\")\n");
        }
    }
}