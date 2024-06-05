package org.czareg.codewars.multiply;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplyTest {

    @Test
    void basicTests() {
        assertEquals(1.0, Multiply.multiply(1.0, 1.0), "1.0 * 1.0 == 1.0");
        assertEquals(2.0, Multiply.multiply(2.0, 1.0), "2.0 * 1.0 == 2.0");
        assertEquals(4.0, Multiply.multiply(2.0, 2.0), "2.0 * 2.0 == 4.0");
        assertEquals(15.0, Multiply.multiply(3.0, 5.0), "3.0 * 5.0 == 15.0");
        assertEquals(0.25, Multiply.multiply(0.5, 0.5), "0.5 * 0.5 == 0.25");
        assertEquals(0.0, Multiply.multiply(5.0, 0.0), "5.0 * 0.0 == 0.0");
        assertEquals(0.0, Multiply.multiply(0.0, 5.0), "0.0 * 5.0 == 0.0");
        assertEquals(0.0, Multiply.multiply(0.0, 0.0), "0.0 * 0.0 == 0.0");
    }

    @Test
    void testAssociativityOfMultiplication() {
        for (int i = 0; i < 100; i++) {
            Double a = Math.random();
            Double b = Math.random();
            Double c = Math.random();
            String message = String.format("(%g * %g) * %g == %g * (%g * %g)", a, b, c, a, b, c);
            assertEquals(
                    Multiply.multiply(Multiply.multiply(a, b), c),
                    Multiply.multiply(a, Multiply.multiply(b, c)),
                    1E-14,
                    message
            );
        }
    }
}