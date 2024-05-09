package org.czareg.codewars.what.name.in;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSearchTest {

    @Test
    void sampleTest() {
        assertTrue(StringSearch.nameInStr("Across the rivers", "chris"));
        assertFalse(StringSearch.nameInStr("Next to a lake", "chris"));
        assertFalse(StringSearch.nameInStr("Under a sea", "chris"));
        assertFalse(StringSearch.nameInStr("A crew that boards the ship", "chris"));
        assertFalse(StringSearch.nameInStr("A live son", "Allison"));
    }

    @Test
    void randomTest() {
        String[] table = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ".split("");
        for (int i = 0; i < 100; ++i) {
            StringBuilder name = new StringBuilder();
            StringBuilder str = new StringBuilder();
            int nameLength = (int) (Math.random() * 2) + 5;
            for (int j = 0; j < nameLength; ++j) {
                name.append(table[(int) (Math.random() * table.length)]);
            }
            int strLength = (int) (Math.random() * 5) + nameLength;
            for (int j = 0; j < strLength; ++j) {
                str.append(table[(int) (Math.random() * table.length)]);
            }
            assertEquals(solution(str.toString(), name.toString()), StringSearch.nameInStr(str.toString(), name.toString()));
        }
    }

    private static boolean solution(String str, String name) {
        name = "^%s$".formatted(name.toLowerCase());
        name = String.join(".*?", name.split(""));
        return str.toLowerCase().matches(name);
    }
}