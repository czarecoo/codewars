package org.czareg.codewars.find.needle;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NeedleFinderTest {

    @Test
    void basicTests() {
        Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};
        Object[] haystack2 = {"283497238987234", "a dog", "a cat", "some random junk", "a piece of hay", "needle", "something somebody lost a while ago"};
        Object[] haystack3 = {1, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 3, 4, 5, 6, 67, 5, 5, 3, 3, 4, 2, 34, 234, 23, 4, 234, 324, 324, "needle", 1, 2, 3, 4, 5, 5, 6, 5, 4, 32, 3, 45, 54};
        assertEquals("found the needle at position 3", NeedleFinder.findNeedle(haystack1));
        assertEquals("found the needle at position 5", NeedleFinder.findNeedle(haystack2));
        assertEquals("found the needle at position 30", NeedleFinder.findNeedle(haystack3));
        assertEquals("found the needle at position 3", NeedleFinder.findNeedleV2(haystack1));
        assertEquals("found the needle at position 5", NeedleFinder.findNeedleV2(haystack2));
        assertEquals("found the needle at position 30", NeedleFinder.findNeedleV2(haystack3));
    }

    @Test
    void randomTests() {
        Random randGen = new Random();
        for (int i = 0; i < 25; i++) {
            Object[] junk = new Object[25];
            int randI = randGen.nextInt(25);
            for (int e = 0; e < 25; e++) {
                if (e == randI)
                    junk[e] = "needle";
                else
                    junk[e] = randGen.nextInt(301);
            }
            String expected = "found the needle at position " + randI;
            assertEquals(expected, NeedleFinder.findNeedle(junk));
            assertEquals(expected, NeedleFinder.findNeedleV2(junk));
        }
    }
}