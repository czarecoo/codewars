package org.czareg.codewars.sentence.smash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmashWordsTest {

    @Test
    void validate() {
        assertEquals("Bilal Djaghout", SmashWords.smash("Bilal", "Djaghout"));
        assertEquals("hello world", SmashWords.smash("hello", "world"));
        assertEquals("hello amazing world", SmashWords.smash("hello", "amazing", "world"));
    }

    @Test
    void validateEmpty() {
        assertEquals("", SmashWords.smash());
    }

    @Test
    void validateNull() {
        assertThrows(NullPointerException.class, () -> SmashWords.smash((String[]) null));
    }

    @Test
    void validateOneWord() {
        assertEquals("Bilal", SmashWords.smash("Bilal"));
        assertEquals("Test", SmashWords.smash("Test"));
    }

}
