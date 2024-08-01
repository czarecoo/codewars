package org.czareg.codewars.quadrant;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@UtilityClass
public class QuadrantFinder {

    private static final Map<Integer, Predicate<Point>> QUADRANTS = Map.of(
            1, point -> point.test((x, y) -> x > 0 && y > 0),
            2, point -> point.test((x, y) -> x < 0 && y > 0),
            3, point -> point.test((x, y) -> x < 0 && y < 0),
            4, point -> point.test((x, y) -> x > 0 && y < 0)
    );

    public static int quadrant(int x, int y) {
        Point point = new Point(x, y);

        return QUADRANTS.entrySet()
                .stream()
                .filter(entry -> entry.getValue().test(point))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }
}

record Point(int x, int y) {
    Point {
        if (x == 0 || y == 0) {
            throw new IllegalArgumentException();
        }
    }

    boolean test(BiPredicate<Integer, Integer> biPredicate) {
        return biPredicate.test(x, y);
    }
}