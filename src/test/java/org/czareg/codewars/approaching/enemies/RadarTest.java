package org.czareg.codewars.approaching.enemies;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadarTest {

    @Test
    void test1() {
        double[] p1 = {100, 100};
        double[] p2 = {90, 90};
        assertEquals(45, Radar.calculateTime(p1, p2), 0.001);
    }

    @Test
    void test2() {
        double[] p1 = {-90, 0};
        double[] p2 = {-80, 0};
        assertEquals(40, Radar.calculateTime(p1, p2), 0.001);
    }

    @Test
    void test3() {
        double[] p1 = {50, -100};
        double[] p2 = {47.5, -95};
        assertEquals(95, Radar.calculateTime(p1, p2), 0.001);
    }

    private final static Random RANDOM = new Random();

    @Test
    void randomTests() {
        for (int i = 0; i < 20; i++) {
            double r1 = 80 + Math.random() * 20;
            double r2 = r1 - 10 - 10 * Math.random();
            double phi = Math.toRadians(RANDOM.nextInt(360));

            double[] p1 = {r1 * Math.cos(phi), r1 * Math.sin(phi)};
            double[] p2 = {r2 * Math.cos(phi), r2 * Math.sin(phi)};

            double expected = solution(p2, p1);
            assertEquals(expected, Radar.calculateTime(p1, p2), 0.001);
        }
    }

    private static double solution(double[] p2, double[] p1) {
        double sqrt = Math.sqrt(p2[0] * p2[0] + p2[1] * p2[1]);
        return sqrt / ((Math.sqrt(p1[0] * p1[0] + p1[1] * p1[1]) - sqrt) / 5);
    }
}