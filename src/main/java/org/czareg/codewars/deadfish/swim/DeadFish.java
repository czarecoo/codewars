package org.czareg.codewars.deadfish.swim;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/*
Write a simple parser that will parse and run Deadfish.

Deadfish has 4 commands, each 1 character long:

i increments the value (initially 0)
d decrements the value
s squares the value
o outputs the value into the return array
Invalid characters should be ignored.
 */
@UtilityClass
public class DeadFish {

    public static int[] parse(String data) {
        int value = 0;
        List<Integer> results = new ArrayList<>();
        for (char c : data.toCharArray()) {
            switch (c) {
                case 'i' -> value++;
                case 'd' -> value--;
                case 's' -> value *= value;
                case 'o' -> results.add(value);
            }
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
