package org.czareg.codewars.how.good.are.you;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HowGoodAreYouReallyTest {

    @Test
    void basicTests() {
        assertTrue(HowGoodAreYouReally.betterThanAverage(new int[]{2, 3}, 5));
        assertTrue(HowGoodAreYouReally.betterThanAverage(new int[]{100, 40, 34, 57, 29, 72, 57, 88}, 75));
        assertTrue(HowGoodAreYouReally.betterThanAverage(new int[]{12, 23, 34, 45, 56, 67, 78, 89, 90}, 69));
        assertFalse(HowGoodAreYouReally.betterThanAverage(new int[]{100, 90}, 11));
    }

    @Test
    void randTests() {
        Random rand = new Random();
        for (int i = 0; i < 40; i++) {
            int myPoints = rand.nextInt(101);
            double pointSum = myPoints;
            int[] cpArr = new int[rand.nextInt(50) + 1];
            for (int c = 0; c < cpArr.length; c++) {
                int cp = rand.nextInt(101);
                cpArr[c] = cp;
                pointSum += cp;
            }
            double classAvg = pointSum / (cpArr.length + 1);
            assertEquals(myPoints > classAvg, HowGoodAreYouReally.betterThanAverage(cpArr, myPoints));
        }
    }
}