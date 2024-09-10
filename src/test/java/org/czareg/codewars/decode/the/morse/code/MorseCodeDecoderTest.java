package org.czareg.codewars.decode.the.morse.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MorseCodeDecoderTest {

    @Test
    void testExampleFromDescription() {
        assertEquals("HEY JUDE", MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
    }

    @Test
    void testBasicMorseDecoding() {
        assertEquals("A", MorseCodeDecoder.decode(".-"));
        assertEquals("E", MorseCodeDecoder.decode("."));
        assertEquals("I", MorseCodeDecoder.decode(".."));
        assertEquals("EE", MorseCodeDecoder.decode(". ."));
        assertEquals("E E", MorseCodeDecoder.decode(".   ."));
        assertEquals("SOS", MorseCodeDecoder.decode("...---..."));
        assertEquals("SOS", MorseCodeDecoder.decode("... --- ..."));
        assertEquals("S O S", MorseCodeDecoder.decode("...   ---   ..."));
    }

    @Test
    void testMoreComplexTests() {
        assertEquals("E", MorseCodeDecoder.decode(" . "));
        assertEquals("E E", MorseCodeDecoder.decode("   .   . "));
        assertEquals("SOS! THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.",
                MorseCodeDecoder.decode("      ...---... -.-.--   - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-  "));
    }
}