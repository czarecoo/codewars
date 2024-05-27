package org.czareg.codewars.abbreviate.a.two.word.name;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbbreviateTwoWordsTest {

    @Test
    void testFixed() {
        assertEquals("S.H", AbbreviateTwoWords.abbrevName("Sam Harris"));
        assertEquals("P.F", AbbreviateTwoWords.abbrevName("Patrick Feenan"));
        assertEquals("E.C", AbbreviateTwoWords.abbrevName("Evan Cole"));
        assertEquals("P.F", AbbreviateTwoWords.abbrevName("P Favuzzi"));
        assertEquals("D.M", AbbreviateTwoWords.abbrevName("David Mendieta"));
        assertEquals("Z.K", AbbreviateTwoWords.abbrevName("Zenon Kapusta"));

        assertEquals("G.C", AbbreviateTwoWords.abbrevName("george clooney"));
        assertEquals("M.M", AbbreviateTwoWords.abbrevName("marky mark"));
        assertEquals("E.D", AbbreviateTwoWords.abbrevName("eliza doolittle"));
        assertEquals("R.W", AbbreviateTwoWords.abbrevName("reese witherspoon"));
    }

    @Test
    void testRandom() {
        for (int i = 0; i < 200; i++) {
            String testString = makeString();
            assertEquals(randomTest(testString), AbbreviateTwoWords.abbrevName(testString));
        }
    }

    private String makeString() {
        return makeWord(1, 20) + " " + makeWord(1, 20);
    }

    private String makeWord(int min, int max) {
        String word = "";
        String[] possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".split("");
        int length = (int) (Math.random() * max) + min;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * possible.length);
            word += possible[index];
        }

        return word;
    }

    private String randomTest(String name) {
        String[] nameSplit = name.toUpperCase().split(" ");
        return nameSplit[0].substring(0, 1) + '.' + nameSplit[1].substring(0, 1);
    }
}