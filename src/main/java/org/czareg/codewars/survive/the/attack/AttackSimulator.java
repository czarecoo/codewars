package org.czareg.codewars.survive.the.attack;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/*
Given two Arrays in which values are the power of each soldier, return true if you survive the attack or false if you perish.

CONDITIONS
Each soldier attacks the opposing soldier in the same index of the array. The survivor is the number with the highest value.
If the value is the same they both perish
If one of the values is empty(different array lengths) the non-empty value soldier survives.
To survive the defending side must have more survivors than the attacking side.
In case there are the same number of survivors in both sides, the winner is the team with the highest initial attack power. If the total attack power of both sides is the same return true.
The initial attack power is the sum of all the values in each array.

EXAMPLES
attackers=[ 1, 3, 5, 7 ]   defenders=[ 2, 4, 6, 8 ]
//0 survivors                4 survivors
//return true

attackers=[ 1, 3, 5, 7 ]   defenders=[ 2, 4 ]
//2 survivors  (16 damage)   2 survivors (6 damage)
//return false

attackers=[ 1, 3, 5, 7 ]   defenders=[ 2, 4, 0, 8 ]
//1 survivors                3 survivors
//return true
 */
@UtilityClass
public class AttackSimulator {

    public static boolean block(int[] attackers, int[] defenders) {
        SimulationResult simulationResult = Simulator.simulate(attackers, defenders);
        return SurvivalChecker.isSurvived(simulationResult);
    }


    @UtilityClass
    class Simulator {

        static SimulationResult simulate(int[] attackers, int[] defenders) {
            int attackerSurvivors = 0;
            int defenderSurvivors = 0;
            int maxIndex = Math.max(attackers.length, defenders.length);
            for (int index = 0; index < maxIndex; index++) {
                int attackerPower = getPower(index, attackers);
                int defenderPower = getPower(index, defenders);
                if (defenderPower > attackerPower) {
                    defenderSurvivors++;
                } else if (defenderPower < attackerPower) {
                    attackerSurvivors++;
                }
            }
            return new SimulationResult(attackerSurvivors, defenderSurvivors, getInitialPower(attackers), getInitialPower(defenders));
        }

        private static int getPower(int index, int[] array) {
            if (index < array.length) {
                return array[index];
            }
            return -1;
        }

        private static int getInitialPower(int[] soldiers) {
            return Arrays.stream(soldiers).sum();
        }
    }

    record SimulationResult(int attackerSurvivors, int defenderSurvivors, int initialAttackersPower,
                            int initialDefendersPower) {
    }

    @UtilityClass
    class SurvivalChecker {

        static boolean isSurvived(SimulationResult simulationResult) {
            int attackerSurvivors = simulationResult.attackerSurvivors();
            int defenderSurvivors = simulationResult.defenderSurvivors();
            if (attackerSurvivors > defenderSurvivors) {
                return false;
            } else if (attackerSurvivors < defenderSurvivors) {
                return true;
            } else {
                int initialAttackPower = simulationResult.initialAttackersPower();
                int initialDefenderPower = simulationResult.initialDefendersPower();
                return initialDefenderPower >= initialAttackPower;
            }
        }
    }
}
