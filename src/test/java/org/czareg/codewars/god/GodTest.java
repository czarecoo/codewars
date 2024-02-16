package org.czareg.codewars.god;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class GodTest {

    @Test
    void makingAdam() {
        Human[] paradise = God.create();
        assertInstanceOf(Man.class, paradise[0]);
    }

    @Test
    void makingEve() {
        Human[] paradise = God.create();
        assertInstanceOf(Woman.class, paradise[1]);
    }

    @Test
    void adamIsHuman() {
        Human[] paradise = God.create();
        assertInstanceOf(Human.class, paradise[0]);
    }

    @Test
    void eveIsHuman() {
        Human[] paradise = God.create();
        assertInstanceOf(Human.class, paradise[1]);
    }

    @Test
    void listHaveRightLength() {
        Human[] paradise = God.create();
        assertEquals(2, paradise.length);
    }
}