package org.czareg.codewars.simple.eviternity.numbers;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EviternitySolverTest {

    private static final Random RANDOM = new Random();

    @Test
    void basicTests() {
        assertEquals(4, EviternitySolver.solve(1, 100));
        assertEquals(14, EviternitySolver.solve(1, 1000));
        assertEquals(37, EviternitySolver.solve(1, 10000));
        assertEquals(103, EviternitySolver.solve(1, 100000));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 100; i++) {
            int a = random(1, 100);
            int b = random(a + 100, 499999);
            assertEquals(solution(a, b), EviternitySolver.solve(a, b));
        }
    }

    private static int solution(int a, int b) {
        int c = 0;
        while (a < b) {
            int x = 0, y = 0, z = 0, flag = 1;
            char[] t = String.valueOf(a).toCharArray();
            for (char ch : t) {
                if (ch == '8') x++;
                else if (ch == '5') y++;
                else if (ch == '3') z++;
                else flag = 0;
            }
            if (x >= y && y >= z && flag == 1) c++;
            a++;
        }
        return c;
    }

    private static int random(int l, int u) {
        return RANDOM.nextInt(u - l) + l;
    }
}