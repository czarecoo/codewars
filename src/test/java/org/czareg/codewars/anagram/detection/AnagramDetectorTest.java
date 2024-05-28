package org.czareg.codewars.anagram.detection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramDetectorTest {

    @Test
    void exampleTests() {
        assertTrue(AnagramDetector.isAnagram("foefet", "toffee"));
        assertTrue(AnagramDetector.isAnagram("Buckethead", "DeathCubeK"));
        assertTrue(AnagramDetector.isAnagram("Twoo", "Woot"));
    }

    @Test
    void moreTests() {
        assertFalse(AnagramDetector.isAnagram("dumble", "bumble"));
        assertFalse(AnagramDetector.isAnagram("ound", "round"));
        assertFalse(AnagramDetector.isAnagram("apple", "pale"));
    }
}