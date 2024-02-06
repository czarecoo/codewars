package org.czareg.codewars.head.at.wrong.end;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class WrongEndHeadTest {

    @Test
    void exampleTest1() {
        assertArrayEquals(new String[]{"head", "body", "tail"},
                WrongEndHead.fixTheMeerkat(new String[]{"tail", "body", "head"}));
    }

    @Test
    void exampleTest2() {
        assertArrayEquals(new String[]{"heads", "body", "tails"},
                WrongEndHead.fixTheMeerkat(new String[]{"tails", "body", "heads"}));
    }


    @Test
    void exampleTest3() {
        assertArrayEquals(new String[]{"top", "middle", "bottom"},
                WrongEndHead.fixTheMeerkat(new String[]{"bottom", "middle", "top"}));
    }

    @Test
    void exampleTest4() {
        assertArrayEquals(new String[]{"upper legs", "torso", "lower legs"},
                WrongEndHead.fixTheMeerkat(new String[]{"lower legs", "torso", "upper legs"}));
    }

    @Test
    void exampleTest5() {
        assertArrayEquals(new String[]{"sky", "rainbow", "ground"},
                WrongEndHead.fixTheMeerkat(new String[]{"ground", "rainbow", "sky"}));
    }

    @Test
    void randomTests() {
        String[] words = {"Kenshiro", "Raoh", "Kaiou", "Toki", "Hyo", "Jagi", "Han", "Souther", "Falco", "Rei", "Shoki", "Juda", "Taiga", "Shin", "Boltz", "Shin", "Soria"};
        Random random = new Random();

        for (int i = 0; i < 64; ++i) {
            String word1 = words[random.nextInt(words.length)];
            String word2 = words[random.nextInt(words.length)];
            String word3 = words[random.nextInt(words.length)];

            assertArrayEquals(new String[]{word1, word2, word3},
                    WrongEndHead.fixTheMeerkat(new String[]{word3, word2, word1}));
        }
    }
}