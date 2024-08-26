package org.czareg.codewars.terminal.game.combat.function;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HealthCalculatorTest {

    @Test
    void fixedTest() {
        assertEquals(95, HealthCalculator.combat(100, 5), "For health = 100, damage = 5");
        assertEquals(84, HealthCalculator.combat(92, 8), "For health = 92, damage = 8");
        assertEquals(0, HealthCalculator.combat(20, 30), "For health = 20, damage = 30");
        assertEquals(1, HealthCalculator.combat(50, 49), "For health = 50, damage = 49");
        assertEquals(0, HealthCalculator.combat(33, 33), "For health = 33, damage = 33");
    }

    @Test
    void randomTest() {
        var random = ThreadLocalRandom.current();
        for (int i = 0; i < 100; i++) {
            int health = random.nextInt(1, 101);
            int damage = random.nextInt(1, 101);
            assertEquals(solution(health, damage), HealthCalculator.combat(health, damage), "For health = " + health + ", damage = " + damage);
        }
    }

    private int solution(int health, int damage) {
        return Math.max(health - damage, 0);
    }
}