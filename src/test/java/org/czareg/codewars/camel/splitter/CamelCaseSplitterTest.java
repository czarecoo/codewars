package org.czareg.codewars.camel.splitter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CamelCaseSplitterTest {

    @Test
    void tests() {
        assertEquals("camel Casing", CamelCaseSplitter.camelCase("camelCasing"));
        assertEquals("camel Casing Test", CamelCaseSplitter.camelCase("camelCasingTest"));
        assertEquals("camelcasingtest", CamelCaseSplitter.camelCase("camelcasingtest"));
    }

    private static final String[] WORDS = new String[]{
            "nouns", "time", "person", "year", "way", "day", "thing", "man", "world", "life", "hand", "part",
            "child", "eye", "woman", "place", "work", "week", "case", "point", "government", "company", "number", "group",
            "problem", "fact", "verbs", "be", "have", "do", "say", "get", "make", "go", "know", "take", "see", "come",
            "think", "look", "want", "give", "use", "find", "tell", "ask", "work", "seem", "feel", "try", "leave", "call",
            "adjectives", "good", "new", "first", "last", "long", "great", "little", "own", "other", "old", "right", "big", "high",
            "different", "small", "large", "next", "early", "young", "important", "few", "public", "bad", "same", "able"
    };

    @Test
    void randomTests() {
        for (int testIter = 0; testIter < 50; testIter++) {
            int wordLength = randInt(10);

            StringBuilder wordString = new StringBuilder();

            for (int i = 0; i < wordLength; i++) {
                String word = WORDS[randInt(WORDS.length)];
                wordString.append(i != 0 ? capitalize(word) : word);
            }

            assertEquals(solution(wordString.toString()), CamelCaseSplitter.camelCase(wordString.toString()));
        }
    }

    private static int randInt(int num) {
        return (int) (Math.random() * num);
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String solution(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }
}