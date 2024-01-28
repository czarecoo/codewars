package org.czareg.codewars.deadfish.swim;


import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DeadFishTest {

    private final Random random = new Random();
    private static final String OPS = "iods";

    @Test
    void fixedTests() {
        assertArrayEquals(new int[]{8, 64}, DeadFish.parse("iiisdoso"));
        assertArrayEquals(new int[]{8, 64, 3600}, DeadFish.parse("iiisdosodddddiso"));
    }

    @Test
    void randomTests() {
        String deadFish;
        for (int i = 0; i < 100; i++) {
            deadFish = getRandomFish();
            assertArrayEquals(solution(deadFish), DeadFish.parse(deadFish));
        }
    }

    private String getRandomFish() {
        StringBuilder deadFish = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            deadFish.append(OPS.charAt(random.nextInt(4)));
        }
        return deadFish.toString();
    }

    private int[] solution(String data) {
        int value = 0;
        int pointer = 0;
        int[] result = new int[(int) data.chars().filter(c -> c == 'o').count()];
        for (char c : data.toCharArray()) {
            if (c == 'i') value += 1;
            if (c == 'd') value -= 1;
            if (c == 's') value *= value;
            if (c == 'o') {
                result[pointer] = value;
                pointer++;
            }
        }
        return result;
    }
}