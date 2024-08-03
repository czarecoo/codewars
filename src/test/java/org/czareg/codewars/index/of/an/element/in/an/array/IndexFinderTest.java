package org.czareg.codewars.index.of.an.element.in.an.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IndexFinderTest {

    @DisplayName("Test with random strings")
    @RepeatedTest(10)
    void testKataWithRandomStrings() {
        Random random = new Random();
        int arraySize = random.nextInt(10) + 1;
        String[] array = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = Integer.toString(random.nextInt(100));
        }
        String str = Integer.toString(random.nextInt(100));
        String expected = "Not found";
        for (int i = 0; i < arraySize; i++) {
            if (array[i].equals(str)) {
                expected = Integer.toString(i);
                break;
            }
        }
        assertEquals(expected, IndexFinder.find(array, str));
    }
}