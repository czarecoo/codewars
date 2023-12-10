package org.czareg.codewars.convert.bool.to.yes.or.no;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertBooleanValuesToStringsYesOrNoTest {

    @Test
    void testBoolToWord() {
        assertEquals("Yes", ConvertBooleanValuesToStringsYesOrNo.boolToWord(true));
        assertEquals("No", ConvertBooleanValuesToStringsYesOrNo.boolToWord(false));
    }
}