package org.czareg.codewars.colored.hexes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColoredHexTest {

    @Test
    void sampleTests() {
        assertEquals("black", ColoredHex.hexColor(""));
        assertEquals("black", ColoredHex.hexColor("000 000 000"));
        assertEquals("blue", ColoredHex.hexColor("121 245 255"));
        assertEquals("cyan", ColoredHex.hexColor("027 100 100"));
        assertEquals("white", ColoredHex.hexColor("021 021 021"));
        assertEquals("red", ColoredHex.hexColor("255 000 000"));
        assertEquals("green", ColoredHex.hexColor("000 147 000"));
        assertEquals("magenta", ColoredHex.hexColor("212 103 212"));
        assertEquals("yellow", ColoredHex.hexColor("101 101 092"));
    }
}