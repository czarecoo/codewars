package org.czareg.codewars.terminal.game.combat.function;

import lombok.experimental.UtilityClass;

/*
Create a combat function that takes the player's current health and the amount of damage received, and returns the player's new health. Health can't be less than 0.
 */
@UtilityClass
class HealthCalculator {

    static int combat(int health, int damage) {
        int currentHealth = health - damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
        return currentHealth;
    }
}
