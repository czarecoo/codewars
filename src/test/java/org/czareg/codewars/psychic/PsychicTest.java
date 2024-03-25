package org.czareg.codewars.psychic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PsychicTest {

    @Test
    void testRandom() {
        assertEquals(Psychic.guess(), java.lang.Math.random(), 0);
    }
}