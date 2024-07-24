package org.czareg.codewars.survive.the.attack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AttackSimulatorTest {

    @Test
    void testDefenders() {
        assertFalse(AttackSimulator.block(new int[]{0}, new int[]{}));
        assertTrue(AttackSimulator.block(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8}));
        assertFalse(AttackSimulator.block(new int[]{2, 9, 9, 7}, new int[]{1, 1, 3, 8}));
        assertTrue(AttackSimulator.block(new int[]{10, 10, 1, 1}, new int[]{4, 4, 7, 7}));
        assertTrue(AttackSimulator.block(new int[]{}, new int[]{1, 2, 3}));
        assertFalse(AttackSimulator.block(new int[]{1, 2, 3}, new int[]{}));
    }
}