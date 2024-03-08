package org.czareg.codewars.spider.and.fly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceCalculatorTest {

    @Test
    void example() {
        assertEquals(4.63522d, DistanceCalculator.spiderToFly("H3", "E2"), 1e-3d);
    }

    @Test
    void misc() {
        assertEquals(3.36795d, DistanceCalculator.spiderToFly("A4", "B1"), 1e-3d);
        assertEquals(4.12310d, DistanceCalculator.spiderToFly("A4", "C1"), 1e-3d);
        assertEquals(4.75992d, DistanceCalculator.spiderToFly("A4", "D1"), 1e-3d);
        assertEquals(2.94725d, DistanceCalculator.spiderToFly("A4", "B2"), 1e-3d);
        assertEquals(4.47213d, DistanceCalculator.spiderToFly("A4", "C2"), 1e-3d);
        assertEquals(5.59586d, DistanceCalculator.spiderToFly("A4", "D2"), 1e-3d);

        assertEquals(3.36795d, DistanceCalculator.spiderToFly("B1", "A4"), 1e-3d);
        assertEquals(4.12310d, DistanceCalculator.spiderToFly("C1", "A4"), 1e-3d);
        assertEquals(4.75992d, DistanceCalculator.spiderToFly("D1", "A4"), 1e-3d);
        assertEquals(2.94725d, DistanceCalculator.spiderToFly("B2", "A4"), 1e-3d);
        assertEquals(4.47213d, DistanceCalculator.spiderToFly("C2", "A4"), 1e-3d);
        assertEquals(5.59586d, DistanceCalculator.spiderToFly("D2", "A4"), 1e-3d);
    }

    @Test
    void same() {
        assertEquals(0d, DistanceCalculator.spiderToFly("C2", "C2"), 1e-3d);
        assertEquals(0d, DistanceCalculator.spiderToFly("A0", "A0"), 1e-3d);
        assertEquals(0d, DistanceCalculator.spiderToFly("F3", "F3"), 1e-3d);
    }

    @Test
    void radialOut() {
        assertEquals(1d, DistanceCalculator.spiderToFly("H1", "H2"), 1e-3d);
        assertEquals(3d, DistanceCalculator.spiderToFly("H1", "H4"), 1e-3d);
    }

    @Test
    void radialIn() {
        assertEquals(4d, DistanceCalculator.spiderToFly("H4", "A0"), 1e-3d);
        assertEquals(2d, DistanceCalculator.spiderToFly("C3", "C1"), 1e-3d);
    }

    @Test
    void radialThruTheMiddle() {
        assertEquals(8d, DistanceCalculator.spiderToFly("G4", "C4"), 1e-3d);
        assertEquals(7d, DistanceCalculator.spiderToFly("G4", "C3"), 1e-3d);
    }

    @Test
    void rings1() {
        assertEquals(0.76536d, DistanceCalculator.spiderToFly("H1", "A1"), 1e-3d);
        assertEquals(1.53073d, DistanceCalculator.spiderToFly("B2", "C2"), 1e-3d);
        assertEquals(2.29610d, DistanceCalculator.spiderToFly("D3", "E3"), 1e-3d);
        assertEquals(3.06146d, DistanceCalculator.spiderToFly("E4", "F4"), 1e-3d);
    }

    @Test
    void rings2() {
        assertEquals(1.41421d, DistanceCalculator.spiderToFly("H1", "B1"), 1e-3d);
        assertEquals(2.82842d, DistanceCalculator.spiderToFly("B2", "D2"), 1e-3d);
        assertEquals(4.24264d, DistanceCalculator.spiderToFly("D3", "F3"), 1e-3d);
        assertEquals(5.65685d, DistanceCalculator.spiderToFly("E4", "G4"), 1e-3d);
    }

    @Test
    void rings3() {
        assertEquals(1.84775d, DistanceCalculator.spiderToFly("H1", "C1"), 1e-3d);
        assertEquals(3.69551d, DistanceCalculator.spiderToFly("B2", "E2"), 1e-3d);
        assertEquals(5.54327d, DistanceCalculator.spiderToFly("D3", "G3"), 1e-3d);
        assertEquals(7.39103d, DistanceCalculator.spiderToFly("E4", "H4"), 1e-3d);
    }

    @Test
    void random() {
        for (int r = 0; r < 500; r++) {
            char spiderRadial = "ABCDEFGH".charAt((int) (Math.random() * 8));
            final int spiderRing = (int) (Math.random() * 5);
            if (spiderRing == 0) spiderRadial = 'A';
            final String spider = "" + spiderRadial + spiderRing;

            char flyRadial = "ABCDEFGH".charAt((int) (Math.random() * 8));
            final int flyRing = (int) (Math.random() * 5);
            if (flyRing == 0) flyRadial = 'A';
            final String fly = "" + flyRadial + flyRing;

            final double actual = DistanceCalculator.spiderToFly(spider, fly);
            final double expected = Answer.spiderToFly(spider, fly);

            assertEquals(expected, actual, 1e-3d);
        }
    }

    private static class Answer {

        public static double spiderToFly(final String spider, final String fly) {

            final char spiderRadial = spider.charAt(0);
            final int spiderRing = spider.charAt(1) - '0';

            final char flyRadial = fly.charAt(0);
            final int flyRing = fly.charAt(1) - '0';

            double dist;
            if (spiderRadial == flyRadial) {
                dist = Math.abs(flyRing - spiderRing);
            } else {
                int delta = Math.max(spiderRadial, flyRadial) - Math.min(spiderRadial, flyRadial);
                if (delta > 4) delta = 8 - delta;
                if (delta == 4) {
                    dist = flyRing + spiderRing;
                } else {
                    final double angle = delta * 45d;
                    dist = Math.sqrt(spiderRing * spiderRing + flyRing * flyRing - 2 * spiderRing * flyRing * Math.cos(Math.toRadians(angle)));
                }
            }
            return dist;
        }
    }
}