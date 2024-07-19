package org.czareg.codewars.repeat.character;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeaterTest {

    @Test
    void fixedTests1() {
        assertEquals("SSttrriinngg", Repeater.doubleChar("String"));
        assertEquals("HHeelllloo  WWoorrlldd", Repeater.doubleChar("Hello World"));
        assertEquals("11223344!!__  ", Repeater.doubleChar("1234!_ "));
    }

    @Test
    void fixedTests2() {
        Map<String, String> solutions = new HashMap<>();
        solutions.put("Peanut Butter", "PPeeaannuutt  BBuutttteerr");
        solutions.put("Adidas", "AAddiiddaass");
        solutions.put("1337", "11333377");
        solutions.put("illuminati", "iilllluummiinnaattii");
        solutions.put("Scrub Lords", "SSccrruubb  LLoorrddss");
        solutions.put("123456", "112233445566");
        solutions.put("____ _ _ __ ___ _ ____ ", "________  __  __  ____  ______  __  ________  ");
        solutions.put("!#%G#DGY^RC", "!!##%%GG##DDGGYY^^RRCC");
        solutions.put("Kanye 2020", "KKaannyyee  22002200");
        solutions.put("Donald Duck", "DDoonnaalldd  DDuucckk");
        solutions.put("Bernie Sanders is Bae", "BBeerrnniiee  SSaannddeerrss  iiss  BBaaee");
        solutions.put("(-_-)", "((--__--))");
        solutions.put("bruh", "bbrruuhh");

        List<String> inputs = new ArrayList<>(List.of("Peanut Butter", "Adidas", "1337", "illuminati",
                "Scrub Lords", "123456", "____ _ _ __ ___ _ ____ ", "!#%G#DGY^RC", "Kanye 2020", "Donald Duck",
                "Bernie Sanders is Bae", "(-_-)", "bruh"));
        Collections.shuffle(inputs);

        for (String input : inputs) {
            assertEquals(solutions.get(input), Repeater.doubleChar(input));
        }
    }

    @Test
    void randomTests() {
        var rnd = ThreadLocalRandom.current();
        for (int i = 0; i < 40; i++) {
            int l = rnd.nextInt(3, 23);
            StringBuilder inputBuilder = new StringBuilder();
            for (int j = 0; j < l; j++) {
                int ascii = rnd.nextInt(30, 114);
                inputBuilder.appendCodePoint(ascii);
            }
            String input = inputBuilder.toString();
            assertEquals(solution(input), Repeater.doubleChar(input));
        }
    }

    public static String solution(String s) {
        return s.replaceAll(".", "$0$0");
    }
}
