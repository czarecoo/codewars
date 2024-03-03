package org.czareg.codewars.twice.as.old;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwiceAsOldTest {

    @Test
    void testSomething() {
        assertEquals(30, TwiceAsOld.calculate(30, 0));
        assertEquals(16, TwiceAsOld.calculate(30, 7));
        assertEquals(15, TwiceAsOld.calculate(45, 30));
    }
}