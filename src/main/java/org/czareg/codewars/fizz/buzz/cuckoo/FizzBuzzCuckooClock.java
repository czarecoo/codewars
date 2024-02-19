package org.czareg.codewars.fizz.buzz.cuckoo;

import lombok.experimental.UtilityClass;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
When a minute is evenly divisible by three, the clock will say the word "Fizz".
When a minute is evenly divisible by five, the clock will say the word "Buzz".
When a minute is evenly divisible by both, the clock will say "Fizz Buzz", with two exceptions:
On the hour, instead of "Fizz Buzz", the clock door will open, and the cuckoo bird will come out and "Cuckoo" between one
and twelve times depending on the hour.
On the half hour, instead of "Fizz Buzz", the clock door will open, and the cuckoo will come out and "Cuckoo" just once.
With minutes that are not evenly divisible by either three or five, at first you had intended to have the clock just say
the numbers ala Fizz Buzz, but then you decided at least for version 1.0 to just have the clock make a quiet, subtle "tick"
 sound for a little more clock nature and a little less noise.

Your input will be a string containing hour and minute values in 24-hour time, separated by a colon, and with leading zeros.
For example, 1:34 pm would be "13:34".

Your return value will be a string containing the combination of Fizz, Buzz, Cuckoo, and/or tick sounds that the clock needs
to make at that time, separated by spaces. Note that although the input is in 24-hour time, cuckoo clocks' cuckoos are in 12-hour time.
 */
@UtilityClass
public class FizzBuzzCuckooClock {

    public static String fizzBuzzCuckooClock(String time) {
        String[] split = time.split(":");
        String hour = split[0];
        int minute = Integer.parseInt(split[1]);
        if (minute == 0) {
            int cuckoos = howManyCuckoos(hour);
            return buildCoockooString(cuckoos);
        } else if (minute == 30) {
            return buildCoockooString(1);
        } else if (minute % 3 == 0 && minute % 5 == 0) {
            return "Fizz Buzz";
        } else if (minute % 3 == 0) {
            return "Fizz";
        } else if (minute % 5 == 0) {
            return "Buzz";
        } else {
            return "tick";
        }
    }

    private static int howManyCuckoos(String hour) {
        String format = LocalTime.parse(hour, DateTimeFormatter.ofPattern("HH")).format(DateTimeFormatter.ofPattern("hh"));
        return Integer.parseInt(format);
    }

    private static String buildCoockooString(int cuckoos) {
        return "Cuckoo ".repeat(cuckoos).trim();
    }
}
