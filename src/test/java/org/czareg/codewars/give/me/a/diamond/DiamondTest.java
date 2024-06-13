package org.czareg.codewars.give.me.a.diamond;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DiamondTest {

    @Test
    void testDiamond3() {
        String expected = """
                 *
                ***
                 *
                """;

        assertEquals(expected, Diamond.print(3));
    }

    @Test
    void testDiamond5() {
        String expected = """
                  *
                 ***
                *****
                 ***
                  *
                """;

        assertEquals(expected, Diamond.print(5));
    }

    @Test
    void testDiamond1() {
        assertEquals("*\n", Diamond.print(1));
    }

    @Test
    void testDiamondMinus2() {
        assertNull(Diamond.print(-2));
    }

    @Test
    void testDiamond2() {
        assertNull(Diamond.print(2));
    }

    @Test
    void testNull() {
        assertNull(Diamond.print(0));
    }

    @Test
    void testNegativeInput() {
        assertNull(Diamond.print(-7));
    }

    @Test
    void testEvenInput() {
        assertNull(Diamond.print(6));
    }

    @Test
    void testDiamond15() {
        String expected = """
                       *
                      ***
                     *****
                    *******
                   *********
                  ***********
                 *************
                ***************
                 *************
                  ***********
                   *********
                    *******
                     *****
                      ***
                       *
                """;

        assertEquals(expected, Diamond.print(15));
    }
}