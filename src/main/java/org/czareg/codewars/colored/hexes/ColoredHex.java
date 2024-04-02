package org.czareg.codewars.colored.hexes;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/*
You're looking through different hex codes, and having trouble telling the difference between #000001 and #100000
We need a way to tell which is red, and which is blue!
That's where you create hex color !!!
It should read an RGB input, and return whichever value (red, blue, or green) is of greatest concentration!
But, if multiple colors are of equal concentration, you should return their mix!
red + blue = magenta
green + red = yellow
blue + green = cyan
red + blue + green = white
One last thing, if the string given is empty, or has all 0's, return black!
 */
@UtilityClass
public class ColoredHex {

    private static final Map<String, Predicate<Color>> COLOR_NAMES = new HashMap<>();

    static {
        COLOR_NAMES.put("white", c -> c.isMono() && !c.isBlack());
        COLOR_NAMES.put("black", Color::isBlack);
        COLOR_NAMES.put("red", c -> c.red() > c.green() && c.red() > c.blue());
        COLOR_NAMES.put("green", c -> c.green() > c.red() && c.green() > c.blue());
        COLOR_NAMES.put("blue", c -> c.blue() > c.green() && c.blue() > c.red());
        COLOR_NAMES.put("magenta", c -> c.red() == c.blue() && c.red() > c.green());
        COLOR_NAMES.put("yellow", c -> c.green() == c.red() && c.green() > c.blue());
        COLOR_NAMES.put("cyan", c -> c.blue() == c.green() && c.blue() > c.red());
    }

    public static String hexColor(String codes) {
        Color color = Color.of(codes);
        return COLOR_NAMES.entrySet()
                .stream()
                .filter(names -> names.getValue().test(color))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }

    record Color(int red, int green, int blue) {

        private static final Color BLACK = new Color(0, 0, 0);

        boolean isMono() {
            return red == green && red == blue;
        }

        boolean isBlack() {
            return BLACK.equals(this);
        }

        static Color of(String codes) {
            String[] split = codes.split(" ");
            if (split.length != 3) {
                return BLACK;
            }
            int red = Integer.parseInt(split[0]);
            int green = Integer.parseInt(split[1]);
            int blue = Integer.parseInt(split[2]);
            return new Color(red, green, blue);
        }
    }
}