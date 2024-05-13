package org.czareg.codewars.swyply;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
A set with a specified capacity contains elements representing weight and value.
Weight can have a value of 1 or 2, however, the value should be a non-negative integer.
Select those elements from the set whose sum value will be the largest, but not exceeding the capacity of the set,
and return them as a new data set.

https://en.wikipedia.org/wiki/Knapsack_problem
https://introcs.cs.princeton.edu/java/23recursion/Knapsack.java.html

Complexity: O(elementsInSet * capacity)
 */
@UtilityClass
class HighestValueElementsPicker {

    static Set<Element> pickWithCapacity(Set<Element> elementsSet, int capacity) {
        if (elementsSet == null) {
            throw new IllegalArgumentException("Set of elements cannot be null");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        List<Element> elements = new ArrayList<>(elementsSet);
        elements.addFirst(new Element(1, 0));
        int elementsCount = elementsSet.size();

        int[][] maxValueSum = new int[elementsCount + 1][capacity + 1];
        //maxValueSum[n][w] - max value sum of packing items 1..n with weight limit w
        boolean[][] includes = new boolean[elementsCount + 1][capacity + 1];
        //includes[n][w] - does maxValueSum solution to pack items 1..n with weight limit w include item n?

        for (int element = 1; element <= elementsCount; element++) {
            for (int weight = 1; weight <= capacity; weight++) {
                int previousMaxValSum = maxValueSum[element - 1][weight];

                Element currentElement = elements.get(element);
                int currentMaxValSum = 0;
                if (currentElement.weight() <= weight) {
                    currentMaxValSum = currentElement.value() + maxValueSum[element - 1][weight - currentElement.weight()];
                }

                // select better of two options
                maxValueSum[element][weight] = Math.max(previousMaxValSum, currentMaxValSum);
                includes[element][weight] = (currentMaxValSum > previousMaxValSum);
            }
        }

        Set<Element> toTake = new HashSet<>();
        int weight = capacity;
        for (int element = elementsCount; element > 0; element--) {
            if (includes[element][weight]) {
                toTake.add(elements.get(element));
                weight -= elements.get(element).weight();
            }
        }

        return toTake;
    }
}
