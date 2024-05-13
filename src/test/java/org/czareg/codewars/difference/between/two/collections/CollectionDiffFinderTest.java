package org.czareg.codewars.difference.between.two.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionDiffFinderTest {

    @Test
    void exampleTests() {
        assertEquals(List.of(), CollectionDiffFinder.diff(List.of('a', 'b'), List.of('a', 'b')));
        assertEquals(List.of('a', 'b'), CollectionDiffFinder.diff(List.of('a', 'b'), List.of()));
        assertEquals(List.of('a', 'b'), CollectionDiffFinder.diff(List.of(), List.of('a', 'b')));
        assertEquals(List.of(), CollectionDiffFinder.diff(List.of(), List.of()));
        assertEquals(List.of('z'), CollectionDiffFinder.diff(List.of('a', 'b', 'z'), List.of('a', 'b')));
        assertEquals(List.of('d', 'e', 'j', 'z'), CollectionDiffFinder.diff(List.of('a', 'b', 'z', 'd', 'e', 'd'), List.of('a', 'b', 'j', 'j')));
    }

    @Test
    void randomTests() {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int firstListSize = r.nextInt(20);
            List<Character> firstList = new ArrayList<>();
            for (int j = 0; j < firstListSize; j++) {
                firstList.add((char) (r.nextInt(26) + 'a'));
            }

            int secondListSize = r.nextInt(20);
            List<Character> secondList = new ArrayList<>();
            for (int j = 0; j < secondListSize; j++) {
                secondList.add((char) (r.nextInt(26) + 'a'));
            }

            assertEquals(solution(firstList, secondList), CollectionDiffFinder.diff(firstList, secondList));
        }
    }

    public List<Character> solution(Collection<Character> a, Collection<Character> b) {
        TreeSet<Character> symmetricDiff = new TreeSet<>(a);
        symmetricDiff.addAll(b);
        TreeSet<Character> tmp = new TreeSet<>(a);
        tmp.retainAll(b);
        symmetricDiff.removeAll(tmp);
        return new ArrayList<>(symmetricDiff);
    }
}