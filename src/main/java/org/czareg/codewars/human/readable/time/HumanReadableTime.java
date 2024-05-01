package org.czareg.codewars.human.readable.time;

import lombok.experimental.UtilityClass;

import java.time.Duration;

/*
Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)

You can find some examples in the test fixtures.
 */
@UtilityClass
public class HumanReadableTime {

    public static String makeReadable(int seconds) {
        if (seconds < 0 || seconds > 359999) {
            throw new IllegalArgumentException();
        }
        Duration duration = Duration.ofSeconds(seconds);
        long hoursPart = duration.toHours();
        long minutesPart = duration.minusHours(hoursPart).toMinutes();
        long secondsPart = duration.minusHours(hoursPart).minusMinutes(minutesPart).toSeconds();
        return "%02d:%02d:%02d".formatted(hoursPart, minutesPart, secondsPart);
    }
}
