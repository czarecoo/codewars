package org.czareg.codewars.traffic.lights;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

/*
You're writing code to control your town's traffic lights. You need a function to handle each change from green, to yellow, to red, and then to green again.

Complete the function that takes a string as an argument representing the current state of the light and returns a string representing the state the light should change to.

For example, when the input is green, output should be yellow.
 */
@UtilityClass
public class TrafficLights {

    public static String updateLight(@NonNull String current) {
        return switch (current) {
            case "red" -> "green";
            case "yellow" -> "red";
            case "green" -> "yellow";
            default -> throw new IllegalArgumentException();
        };
    }
}
