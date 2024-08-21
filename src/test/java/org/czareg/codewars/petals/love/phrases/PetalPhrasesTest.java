package org.czareg.codewars.petals.love.phrases;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetalPhrasesTest {

    @Test
    void testSpecific() {
        assertEquals("I love you", PetalPhrases.howMuchILoveYou(1));
        assertEquals("a little", PetalPhrases.howMuchILoveYou(2));
        assertEquals("not at all", PetalPhrases.howMuchILoveYou(6));
        assertEquals("I love you", PetalPhrases.howMuchILoveYou(7));
    }

    @Test
    void testRandom() {
        Random rand = new Random();
        for (int k = 0; k < 50; k++) {
            int n = rand.nextInt(100) + 1;
            assertEquals(solution(n), PetalPhrases.howMuchILoveYou(n));
        }
    }

    public static String solution(int petals) {
        petals = petals % 6;
        if (petals == 1)
            return "I love you";
        if (petals == 2)
            return "a little";
        if (petals == 3)
            return "a lot";
        if (petals == 4)
            return "passionately";
        if (petals == 5)
            return "madly";
        if (petals == 0)
            return "not at all";
        return "";
    }
}