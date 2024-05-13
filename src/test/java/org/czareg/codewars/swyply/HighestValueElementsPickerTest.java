package org.czareg.codewars.swyply;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HighestValueElementsPickerTest {

    @Test
    void shouldThrowWhenElementsSetIsNull() {
        assertThrows(IllegalArgumentException.class, () -> HighestValueElementsPicker.pickWithCapacity(null, 5));
    }

    @Test
    void shouldThrowWhenCapacityIsNegative() {
        Set<Element> elements = Set.of();
        assertThrows(IllegalArgumentException.class, () -> HighestValueElementsPicker.pickWithCapacity(elements, -1));
    }

    @Test
    void shouldReturnEmptySetWhenGivenEmptySet() {
        Set<Element> elements = Set.of();
        int capacity = 5;

        Set<Element> actual = HighestValueElementsPicker.pickWithCapacity(elements, capacity);

        Set<Element> expected = Set.of();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptySetWhenGivenZeroCapacity() {
        Set<Element> elements = Set.of(
                new Element(2, 1),
                new Element(1, 6)
        );
        int capacity = 0;

        Set<Element> actual = HighestValueElementsPicker.pickWithCapacity(elements, capacity);

        Set<Element> expected = Set.of();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyPickHighestValuesWhenEveryItemHasTheWeightTwo() {
        Set<Element> elements = Set.of(
                new Element(2, 1),
                new Element(2, 2),
                new Element(2, 3),
                new Element(2, 4),
                new Element(2, 5),
                new Element(2, 6)
        );
        int capacity = 6;

        Set<Element> actual = HighestValueElementsPicker.pickWithCapacity(elements, capacity);

        Set<Element> expected = Set.of(
                new Element(2, 4),
                new Element(2, 5),
                new Element(2, 6)
        );
        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyPickHighestValuesWhenEveryItemHasTheWeightOne() {
        Set<Element> elements = Set.of(
                new Element(1, 1),
                new Element(1, 2),
                new Element(1, 6)
        );
        int capacity = 2;

        Set<Element> actual = HighestValueElementsPicker.pickWithCapacity(elements, capacity);

        Set<Element> expected = Set.of(
                new Element(1, 2),
                new Element(1, 6)
        );
        assertEquals(expected, actual);
    }

    @Test
    void shouldPickOneItemWithWeightTwoAndValueSixThanTwoItemsWithWeightOneAndValueThree() {
        Set<Element> elements = Stream.of(
                new Element(2, 6),
                new Element(1, 3),
                new Element(1, 3)

        ).collect(Collectors.toSet());
        int capacity = 2;

        Set<Element> actual = HighestValueElementsPicker.pickWithCapacity(elements, capacity);

        Set<Element> expected = Set.of(
                new Element(2, 6)
        );
        assertEquals(expected, actual);
    }

    @Test
    void shouldPickHighestValuesItemsWhileKeepingCapacityLimit() {
        Set<Element> elements = Stream.of(
                new Element(1, 8),
                new Element(1, 9),
                new Element(1, 10),
                new Element(2, 17),
                new Element(2, 18),
                new Element(2, 20)

        ).collect(Collectors.toSet());
        int capacity = 4;

        Set<Element> actual = HighestValueElementsPicker.pickWithCapacity(elements, capacity);

        Set<Element> expected = Set.of(
                new Element(2, 20),
                new Element(1, 9),
                new Element(1, 10)
        );
        assertEquals(expected, actual);
    }
}