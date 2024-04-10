package org.czareg.codewars.baby.magpies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagpipesFamilyTest {

    private static class Solution {

        private static String swap(final char c) {
            return c == 'B' ? "W" : "B";
        }

        static boolean child(final String bird1, final String bird2) {
            for (int i = 0; i < bird1.length(); i++) {
                final char ci = bird1.charAt(i);
                final String oneDiff = new StringBuilder(bird1).replace(i, i + 1, swap(ci)).toString();
                if (bird2.equals(oneDiff)) return true;
                for (int j = i + 1; j < bird1.length(); j++) {
                    final char cj = bird1.charAt(j);
                    final String twoDiffs = new StringBuilder(oneDiff).replace(j, j + 1, swap(cj)).toString();
                    if (bird2.equals(twoDiffs)) return true;
                }
            }
            return false;
        }

        static boolean grandchild(final String bird1, final String bird2) {
            for (int i = 0; i < bird1.length(); i++) {
                final char ci = bird1.charAt(i);
                final String oneDiff = new StringBuilder(bird1).replace(i, i + 1, swap(ci)).toString();
                if (child(oneDiff, bird2)) return true;
                for (int j = i + 1; j < bird1.length(); j++) {
                    final char cj = bird1.charAt(j);
                    final String twoDiffs = new StringBuilder(oneDiff).replace(j, j + 1, swap(cj)).toString();
                    if (child(twoDiffs, bird2)) return true;
                }
            }
            return false;
        }

    }

    private String makeBird(final int len) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < len; i++) {
            final double r = Math.random();
            s.append(r < 0.5 ? "B" : "W");
        }
        return s.toString();
    }

    private final String m1 = "BWBWBW";
    private final String m2 = "BWBWBB";
    private final String m3 = "WWWWBB";

    @Test
    void child() {
        assertTrue(MagpipesFamily.child(m1, m2));
        assertTrue(MagpipesFamily.child(m2, m3));
    }

    @Test
    void notChild() {
        assertFalse(MagpipesFamily.child(m1, m3));
        assertFalse(MagpipesFamily.child(m1, m1));
    }

    @Test
    void same() {
        assertFalse(MagpipesFamily.child(m1, m1));
        assertTrue(MagpipesFamily.grandchild(m1, m1));
    }

    @Test
    void grandchild() {
        assertTrue(MagpipesFamily.grandchild(m1, m3));
        assertTrue(MagpipesFamily.grandchild(m1, m2));
    }

    @Test
    void one() {
        final String mag1 = "W";
        final String mag2 = "B";

        assertTrue(MagpipesFamily.child(mag1, mag2));
        assertFalse(MagpipesFamily.grandchild(mag1, mag2));
    }

    @Test
    void commutative() {
        assertTrue(MagpipesFamily.child(m1, m2));
        assertTrue(MagpipesFamily.child(m2, m1));
        assertTrue(MagpipesFamily.grandchild(m1, m3));
        assertTrue(MagpipesFamily.grandchild(m3, m1));
        assertFalse(MagpipesFamily.child(m1, m3));
        assertFalse(MagpipesFamily.child(m3, m1));
    }

    @Test
    void random() {
        for (int r = 0; r < 100; r++) {
            final int len = 1 + (int) (Math.random() * 10);
            final String bird1 = makeBird(len);
            final String bird2 = makeBird(len);
            final boolean expectedChild = Solution.child(bird1, bird2);
            final boolean expectedGrandchild = Solution.grandchild(bird1, bird2);
            final boolean actualChild = MagpipesFamily.child(bird1, bird2);
            final boolean actualGrandchild = MagpipesFamily.grandchild(bird1, bird2);
            assertEquals(expectedChild, actualChild);
            assertEquals(expectedGrandchild, actualGrandchild);
        }
    }
}