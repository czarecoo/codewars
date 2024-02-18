package org.czareg.codewars.rock.off;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockOffSolverTest {

    @Test
    void basicTests() {
        assertEquals("0, 0: that looks like a \"draw\"! Rock on!", RockOffSolver.solveRockOff(new int[]{47, 7, 2}, new int[]{47, 7, 2}));
        assertEquals("3, 0: Alice made \"Kurt\" proud!", RockOffSolver.solveRockOff(new int[]{47, 50, 22}, new int[]{26, 47, 12}));
        assertEquals("1, 2: Bob made \"Jeff\" proud!", RockOffSolver.solveRockOff(new int[]{25, 50, 22}, new int[]{34, 49, 50}));
        assertEquals("2, 0: Alice made \"Kurt\" proud!", RockOffSolver.solveRockOff(new int[]{8, 8, 11}, new int[]{3, 8, 10}));
        assertEquals("1, 2: Bob made \"Jeff\" proud!", RockOffSolver.solveRockOff(new int[]{20, 32, 18}, new int[]{48, 25, 40}));
        assertEquals("1, 1: that looks like a \"draw\"! Rock on!", RockOffSolver.solveRockOff(new int[]{5, 6, 7}, new int[]{3, 6, 10}));
        assertEquals("2, 1: Alice made \"Kurt\" proud!", RockOffSolver.solveRockOff(new int[]{21, 39, 15}, new int[]{47, 1, 12}));
        assertEquals("1, 2: Bob made \"Jeff\" proud!", RockOffSolver.solveRockOff(new int[]{1, 2, 3}, new int[]{2, 3, 1}));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 200; i++) {
            int[] alice = new int[]{rand1to50(), rand1to50(), rand1to50()},
                    bob = new int[]{rand1to50(), rand1to50(), rand1to50()};
            assertEquals(solution(alice, bob), RockOffSolver.solveRockOff(alice, bob));
        }
    }

    private int rand1to50() {
        return (int) (Math.random() * 50) + 1;
    }

    private static String solution(final int[] alice, final int[] bob) {
        int[] scores = new int[2];
        for (int i = 0; i < alice.length; i++)
            if (alice[i] > bob[i])
                scores[0]++;
            else if (alice[i] < bob[i])
                scores[1]++;
        return String.format("%d, %d: %s", scores[0], scores[1],
                (scores[0] > scores[1] ? "Alice made \"Kurt\" proud!" :
                        (scores[0] < scores[1] ? "Bob made \"Jeff\" proud!" :
                                "that looks like a \"draw\"! Rock on!")));
    }
}