package org.czareg.codewars.survive.the.attack;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AttackSimulatorTest {

    @Test
    void testDefenders() {
        assertTrue(AttackSimulator.block(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8}));
        assertFalse(AttackSimulator.block(new int[]{2, 9, 9, 7}, new int[]{1, 1, 3, 8}));
        assertTrue(AttackSimulator.block(new int[]{10, 10, 1, 1}, new int[]{4, 4, 7, 7}));
        assertTrue(AttackSimulator.block(new int[]{}, new int[]{1, 2, 3}));
        assertFalse(AttackSimulator.block(new int[]{1, 2, 3}, new int[]{}));
        assertTrue(AttackSimulator.block(new int[]{4, 9, 18, 6, 45, 39, 6, 26, 19}, new int[]{5, 15, 7, 28, 50, 7, 34}));
        assertFalse(AttackSimulator.block(new int[]{24, 8, 26, 28, 6, 32, 46, 5, 43, 19}, new int[]{15, 50, 43, 40, 49, 15, 37}));
    }

    @Test
    void emptyTest() {
        assertFalse(AttackSimulator.block(new int[]{1, 5, 3}, new int[]{}));
        assertFalse(AttackSimulator.block(new int[]{0}, new int[]{}));
        assertTrue(AttackSimulator.block(new int[]{}, new int[]{8, 7, 1, 9}));
    }

    @Test
    void diffLengthTest() {
        assertTrue(AttackSimulator.block(new int[]{1, 5, 3}, new int[]{2, 2, 6, 8}));
        assertFalse(AttackSimulator.block(new int[]{1, 9, 3}, new int[]{}));
        assertFalse(AttackSimulator.block(new int[]{1, 3, 5, 7}, new int[]{2, 4}));
    }

    @Test
    void drawTest() {
        assertTrue(AttackSimulator.block(new int[]{8, 7, 1, 9}, new int[]{8, 7, 1, 9}));
        assertFalse(AttackSimulator.block(new int[]{1, 3, 5, 7}, new int[]{2, 2, 6, 5}));
        assertTrue(AttackSimulator.block(new int[]{1, 9, 3, 6}, new int[]{4, 8, 5, 5}));
    }

    @Test
    void additionalTest() {
        assertFalse(solution(new int[]{10, 14, 40, 61, 53}, new int[]{0, 63, 52, 39, 29}));
    }

    @Test
    void randomTest() {
        Random random = new Random();
        for (int i = 1; i <= 200; i++) {
            int[] attackers = new int[random.nextInt(10)];
            int[] defenders = new int[random.nextInt(10)];
            for (int j = 0; j < attackers.length; j++) {
                attackers[j] = random.nextInt(100);
            }
            for (int j = 0; j < defenders.length; j++) {
                defenders[j] = random.nextInt(100);
            }
            boolean expected = solution(attackers, defenders);
            boolean actual = AttackSimulator.block(attackers, defenders);
            assertEquals(expected, actual);
        }
    }

    public static boolean solution(int[] attackers, int[] defenders) {
        int attackerSurvivors = 0;
        int defenderSurvivors = 0;
        int maxLength = attackers.length;
        if (attackers.length < defenders.length) {
            defenderSurvivors += defenders.length - maxLength;
        } else if (attackers.length > defenders.length) {
            maxLength = defenders.length;
            attackerSurvivors += attackers.length - maxLength;
        }

        for (int i = 0; i < maxLength; i++) {
            if (attackers[i] < defenders[i]) {
                defenderSurvivors++;
            }
            if (attackers[i] > defenders[i]) {
                attackerSurvivors++;
            }
        }

        if (attackerSurvivors == defenderSurvivors) {
            attackerSurvivors = 0;
            defenderSurvivors = 0;
            for (int defender : defenders) {
                defenderSurvivors += defender;
            }
            for (int attacker : attackers) {
                attackerSurvivors += attacker;
            }
        }
        return attackerSurvivors <= defenderSurvivors;
    }
}