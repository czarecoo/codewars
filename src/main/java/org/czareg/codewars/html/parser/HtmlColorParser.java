package org.czareg.codewars.html.parser;

import java.util.Map;

/*
In this kata you parse RGB colors represented by strings. The formats are primarily used in HTML and CSS. Your task is to implement a function which takes a color as a string and returns the parsed color as a map (see Examples).

Input:
The input string represents one of the following:

6-digit hexadecimal - "#RRGGBB"
e.g. "#012345", "#789abc", "#FFA077"
Each pair of digits represents a value of the channel in hexadecimal: 00 to FF

3-digit hexadecimal - "#RGB"
e.g. "#012", "#aaa", "#F5A"
Each digit represents a value 0 to F which translates to 2-digit hexadecimal: 0->00, 1->11, 2->22, and so on.

Preset color name
e.g. "red", "BLUE", "LimeGreen"
You have to use the predefined map PRESET_COLORS (JavaScript, Python, Ruby), presetColors (Java, C#, Haskell), PresetColors (Go) or preset-colors (Clojure). The keys are the names of preset colors in lower-case and the values are the corresponding colors in 6-digit hexadecimal (same as 1. "#RRGGBB").

Examples:
parse("#80FFA0")   === new RGB(128, 255, 160))
parse("#3B7")      === new RGB( 51, 187, 119))
parse("LimeGreen") === new RGB( 50, 205,  50))
 */
public class HtmlColorParser {

    private final Map<String, String> presetColors;

    public HtmlColorParser(Map<String, String> presetColors) {
        this.presetColors = presetColors;
    }

    public RGB parse(String color) {
        String unified = unify(color);
        return new RGB(
                Integer.parseInt(unified.substring(0, 2), 16),
                Integer.parseInt(unified.substring(2, 4), 16),
                Integer.parseInt(unified.substring(4), 16)
        );
    }

    private String unify(String color) {
        if (color.startsWith("#")) {
            if (color.length() == 7) {
                return color.substring(1);
            }
            if (color.length() == 4) {
                return duplicateAllChars(color).substring(2);
            }
            throw new IllegalArgumentException();
        } else {
            if (!presetColors.containsKey(color.toLowerCase())) {
                throw new IllegalArgumentException();
            }
            return presetColors.get(color.toLowerCase()).substring(1);
        }
    }

    private String duplicateAllChars(String sting) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sting.length(); i++) {
            char c = sting.charAt(i);
            sb.append(c).append(c);
        }
        return sb.toString();
    }
}
