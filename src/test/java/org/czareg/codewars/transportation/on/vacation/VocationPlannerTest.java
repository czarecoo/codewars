package org.czareg.codewars.transportation.on.vacation;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VocationPlannerTest {

    @Test
    void under3Tests() {
        assertEquals(40, VocationPlanner.rentalCarCost(1));
        assertEquals(80, VocationPlanner.rentalCarCost(2));
    }

    @Test
    void under7Tests() {
        assertEquals(100, VocationPlanner.rentalCarCost(3));
        assertEquals(140, VocationPlanner.rentalCarCost(4));
        assertEquals(180, VocationPlanner.rentalCarCost(5));
        assertEquals(220, VocationPlanner.rentalCarCost(6));
    }

    @Test
    void over7Tests() {
        assertEquals(230, VocationPlanner.rentalCarCost(7));
        assertEquals(270, VocationPlanner.rentalCarCost(8));
        assertEquals(310, VocationPlanner.rentalCarCost(9));
        assertEquals(350, VocationPlanner.rentalCarCost(10));
    }

    @Test
    void randomTests() {
        Random randGen = new Random();
        for (int i = 0; i < 100; i++) {
            int days = randGen.nextInt(101);
            assertEquals(solution(days), VocationPlanner.rentalCarCost(days));
        }
    }

    private int solution(int d) {
        if (d < 3) return d * 40;
        return (d < 7) ? d * 40 - 20 : d * 40 - 50;
    }
}