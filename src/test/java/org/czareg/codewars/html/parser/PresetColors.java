package org.czareg.codewars.html.parser;

import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class PresetColors {
    public static Map<String, String> getMap() {
        return Map.of(
                "limegreen", "#32CD32"
        );
    }
}
