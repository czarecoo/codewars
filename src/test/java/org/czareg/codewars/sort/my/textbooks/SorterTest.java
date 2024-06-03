package org.czareg.codewars.sort.my.textbooks;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SorterTest {

    @Test
    void basicTest() {
        List<String> expected = new ArrayList<>(Arrays.asList("Algebra", "English", "Geometry", "History"));
        List<String> textbooks = new ArrayList<>(Arrays.asList("Algebra", "History", "Geometry", "English"));
        assertEquals(expected, Sorter.sort(textbooks));
    }

    @Test
    void capitalizationTest() {
        List<String> expected = new ArrayList<>(Arrays.asList("Algebra", "english", "Geometry", "History"));
        List<String> textbooks = new ArrayList<>(Arrays.asList("Algebra", "History", "Geometry", "english"));
        assertEquals(expected, Sorter.sort(textbooks));
    }

    @Test
    void symbolsTest() {
        List<String> expected = new ArrayList<>(Arrays.asList("$istory", "**English", "Alg#bra", "Geom^try"));
        List<String> textbooks = new ArrayList<>(Arrays.asList("Alg#bra", "$istory", "Geom^try", "**English"));
        assertEquals(expected, Sorter.sort(textbooks));
    }

    @Test
    void randomTests() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            List<String> textbooks = new ArrayList<>();
            List<String> expected = new ArrayList<>();
            int arrayLength = rand.nextInt(5, 15);
            while (arrayLength-- > 0) {
                int bookLength = rand.nextInt(5, 15);
                StringBuilder text = new StringBuilder();
                while (bookLength-- > 0) {
                    text.append((char) (rand.nextInt(0, 6) + (rand.nextInt(0, 100) < 75 ? 'a' : 'A')));
                }
                String book = text.toString();
                textbooks.add(book);
                expected.add(book);
            }
            expected.sort(String.CASE_INSENSITIVE_ORDER);
            assertEquals(expected, Sorter.sort(textbooks));
        }
    }
}