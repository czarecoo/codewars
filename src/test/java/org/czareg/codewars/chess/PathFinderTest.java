package org.czareg.codewars.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathFinderTest {

    @Test
    void sampleTests() {
        assertEquals(2, PathFinder.knight("a1", "c1"));
        assertEquals(3, PathFinder.knight("a1", "f1"));
        assertEquals(3, PathFinder.knight("a1", "f3"));
        assertEquals(4, PathFinder.knight("a1", "f4"));
        assertEquals(5, PathFinder.knight("a1", "f7"));
    }
}