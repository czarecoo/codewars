package org.czareg.codewars.sheep.counting;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SheepCounterTest {

    @Test
    void testSomething() {
        assertEquals("", SheepCounter.countingSheep(0));
        assertEquals("1 sheep...", SheepCounter.countingSheep(1));
        assertEquals("1 sheep...2 sheep...", SheepCounter.countingSheep(2));
        assertEquals("1 sheep...2 sheep...3 sheep...", SheepCounter.countingSheep(3));
    }

    @Test
    void randomTests() {
        Random rand = new Random();
        int randomNum = rand.nextInt(100) + 1;
        assertEquals(solution(randomNum), SheepCounter.countingSheep(randomNum));
    }

    public static String solution(int num) {
        return IntStream.rangeClosed(1, num)
                .mapToObj("%d sheep..."::formatted)
                .collect(Collectors.joining());
    }
}