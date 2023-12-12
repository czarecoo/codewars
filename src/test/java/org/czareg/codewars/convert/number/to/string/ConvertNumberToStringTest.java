package org.czareg.codewars.convert.number.to.string;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertNumberToStringTest {

    @Test
    void basicTests() {
        assertEquals("67", ConvertNumberToString.numberToString(67));
        assertEquals("123", ConvertNumberToString.numberToString(123));
        assertEquals("999", ConvertNumberToString.numberToString(999));
        assertEquals("79585", ConvertNumberToString.numberToString(79585));
        assertEquals("3", ConvertNumberToString.numberToString(1 + 2));
        assertEquals("-1", ConvertNumberToString.numberToString(1 - 2));
    }

    @Test
    void randomTests() {
        Random randGen = new Random();
        for (int i = 0; i < 20; i++) {
            int num = randGen.nextInt(100000);
            assertEquals(Integer.toString(num), ConvertNumberToString.numberToString(num), "Should convert " + num + " to its correct string representation");
        }
    }
}