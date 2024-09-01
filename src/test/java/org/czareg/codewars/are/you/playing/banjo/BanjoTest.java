package org.czareg.codewars.are.you.playing.banjo;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BanjoTest {

    @Test
    void peopleThatDontPlayBanjo() {
        assertEquals("Adam does not play banjo", Banjo.areYouPlayingBanjo("Adam"));
        assertEquals("Paul does not play banjo", Banjo.areYouPlayingBanjo("Paul"));
        assertEquals("bravo does not play banjo", Banjo.areYouPlayingBanjo("bravo"));
    }

    @Test
    void peopleThatDoPlayBanjo() {
        assertEquals("Ringo plays banjo", Banjo.areYouPlayingBanjo("Ringo"));
        assertEquals("rolf plays banjo", Banjo.areYouPlayingBanjo("rolf"));
    }

    @Test
    void randomTests() {
        String[] names = {"Adam", "Bob", "chelsea", "daniel", "Ethan", "fanny", "george", "harry",
                "Ignatious", "Kyle", "Lavender", "michelle", "peter", "Ragu", "Ryle", "Reaven",
                "royce", "richard", "rubi", "Reanor", "resh", "Samantha", "trishan", "valde"};
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            String s = names[random.nextInt(names.length)];
            assertEquals(solution(s), Banjo.areYouPlayingBanjo(s));
        }
    }

    private static String solution(String name) {
        return name.toLowerCase().startsWith("r") ? name + " plays banjo" : name + " does not play banjo";
    }
}