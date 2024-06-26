package org.czareg.codewars.dashatize.it;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DasherTest {

    @Test
    void testBasic() {
        assertEquals("2-7-4", Dasher.dashatize(274));
        assertEquals("5-3-1-1", Dasher.dashatize(5311));
        assertEquals("86-3-20", Dasher.dashatize(86320));
        assertEquals("9-7-4-3-02", Dasher.dashatize(974302));
    }

    @Test
    void testWeird() {
        assertEquals("0", Dasher.dashatize(0));
        assertEquals("1", Dasher.dashatize(-1));
        assertEquals("28-3-6-9", Dasher.dashatize(-28369));
    }

    @Test
    void testEdgeCases() {
        assertEquals("2-1-4-7-48-3-64-7", Dasher.dashatize(Integer.MAX_VALUE));
        assertEquals("2-1-4-7-48-3-648", Dasher.dashatize(Integer.MIN_VALUE));
        assertEquals("1-1-1-1-1-1-1-1-1-1", Dasher.dashatize(-1111111111));
    }

    @Test
    void testRandom() {
        for (int i = 0; i < 1_000; i++) {
            int num = ThreadLocalRandom.current().nextInt();
            String expected = String.valueOf(num)
                    .replaceAll("([13579])", "-$1-")
                    .replaceAll("--", "-")
                    .replaceAll("^-|-$", "");
            assertEquals(expected, Dasher.dashatize(num));
        }
    }
}