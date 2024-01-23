package org.czareg.codewars.traffic.lights;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrafficLightsTest {

    @Test
    void testUpdateLight() {
        assertEquals("green", TrafficLights.updateLight("red"));
        assertEquals("yellow", TrafficLights.updateLight("green"));
        assertEquals("red", TrafficLights.updateLight("yellow"));
        assertThrows(IllegalArgumentException.class, () -> TrafficLights.updateLight(""));
    }
}