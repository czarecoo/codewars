package org.czareg.codewars.exclusive.or.logical.operator;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class XORTest {

    @Test
    void testBasic() {
        assertFalse(XOR.xor(false, false), "false xor false should be false");
        assertTrue(XOR.xor(false, true), "false xor true should be true");
        assertTrue(XOR.xor(true, false), "true xor false should be true");
        assertFalse(XOR.xor(true, true), "true xor true should be false");
    }

    @Test
    void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            boolean a = random.nextBoolean(), b = random.nextBoolean();
            boolean expected = a ^ b, actual = XOR.xor(a, b);
            String message = String.format("%b xor %b should be %b", a, b, expected);
            assertEquals(expected, actual, message);
        }
    }
}