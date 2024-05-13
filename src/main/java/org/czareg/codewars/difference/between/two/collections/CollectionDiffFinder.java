package org.czareg.codewars.difference.between.two.collections;

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/*
Find the difference between two collections. The difference means that either the character is present in one collection
or it is present in other, but not in both. Return a sorted list with the difference.

The collections can contain any character and can contain duplicates.

Example
A = [a, a, t, e, f, i, j]
B = [t, g, g, i, k, f]
difference = [a, e, g, j, k]
 */
@UtilityClass
public class CollectionDiffFinder {

    public static List<Character> diff(Collection<Character> a, Collection<Character> b) {
        Set<Character> onlyA = new HashSet<>(a);
        onlyA.removeAll(b);
        Set<Character> onlyB = new HashSet<>(b);
        onlyB.removeAll(a);
        return Stream.concat(onlyA.stream(), onlyB.stream())
                .distinct()
                .sorted()
                .toList();
    }
}
