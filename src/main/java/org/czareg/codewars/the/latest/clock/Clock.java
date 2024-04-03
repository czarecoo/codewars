package org.czareg.codewars.the.latest.clock;

import lombok.experimental.UtilityClass;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
Write a function which receives 4 digits and returns the latest time of day that can be built with those digits.

The time should be in HH:MM format.

Examples:

digits: 1, 9, 8, 3 => result: "19:38"
digits: 9, 1, 2, 5 => result: "21:59" (19:25 is also a valid time, but 21:59 is later)
Notes
Result should be a valid 24-hour time, between 00:00 and 23:59.
Only inputs which have valid answers are tested.
 */
@UtilityClass
public class Clock {

    public static String latestClock(int a, int b, int c, int d) {
        List<String> elements = Stream.of(a, b, c, d).map(String::valueOf).toList();
        return Permutator.permute(elements).stream()
                .map(list -> {
                    int hour = Integer.parseInt(list.get(0) + list.get(1));
                    int minute = Integer.parseInt(list.get(2) + list.get(3));
                    return new Time(hour, minute);
                })
                .filter(Time::isValid)
                .map(Time::toLocalTime)
                .max(Comparator.naturalOrder())
                .orElseThrow()
                .toString();
    }

    record Time(int hour, int minute) {

        boolean isValid() {
            return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
        }

        LocalTime toLocalTime() {
            return LocalTime.of(hour, minute);
        }
    }

    @UtilityClass
    class Permutator {

        public static <T> List<List<T>> permute(List<T> elements) {
            List<List<T>> results = new ArrayList<>();
            permute(results, new ArrayList<>(elements), elements.size());
            return results;
        }

        private static <T> void permute(List<List<T>> results, List<T> elements, int size) {
            if (size == 1) {
                results.add(new ArrayList<>(elements));
            } else {
                for (int i = 0; i < size; i++) {
                    permute(results, elements, size - 1);
                    if (size % 2 == 1) {
                        swap(elements, 0, size - 1);
                    } else {
                        swap(elements, i, size - 1);
                    }
                }
            }
        }

        private static <T> void swap(List<T> elements, int firstIndex, int secondIndex) {
            T t = elements.get(firstIndex);
            elements.set(firstIndex, elements.get(secondIndex));
            elements.set(secondIndex, t);
        }
    }
}
