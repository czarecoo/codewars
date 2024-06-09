package org.czareg.codewars.growth.of.a.population;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PopulationCalculatorTest {

    @Test
    void sampleTests() {
        testing(PopulationCalculator.nbYear(1500, 5, 100, 5000), 15);
        testing(PopulationCalculator.nbYear(1500000, 2.5, 10000, 2000000), 10);
        testing(PopulationCalculator.nbYear(1500000, 0.25, 1000, 2000000), 94);
        testing(PopulationCalculator.nbYear(1500000, 0.25, -1000, 2000000), 151);
        testing(PopulationCalculator.nbYear(1500000, 0.25, 1, 2000000), 116);
        testing(PopulationCalculator.nbYear(1500000, 0.0, 10000, 2000000), 50);
        testing(PopulationCalculator.nbYear(1000, 2.0, 50, 1214), 4);
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 100; i++) {
            int p0 = randInt(10000, 15000000);
            double percent = randInt(50, 1000) / 100.0;
            int aug = (int) (p0 / 200.0);
            int k = randInt(5, 100);
            int p = p0 + k * aug;
            testing(PopulationCalculator.nbYear(p0, percent, aug, p), solution(p0, percent, aug, p));
        }
    }

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    private static int randInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private static int solution(int p0, double percent, int aug, int p) {
        int i = 1;
        double mult = 1 + percent / 100.0;
        double prev = p0;
        while (prev < p) {
            prev = Math.floor(prev * mult + aug);
            i++;
        }
        return (i - 1);
    }
}