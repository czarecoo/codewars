package org.czareg.codewars.colored.hexes;

import lombok.experimental.UtilityClass;

import java.util.stream.Stream;

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

    public static String hexColor(String codes) {
        Color color = Color.of(codes);
        return Stream.of(new WhiteNamer(), new BlackNamer(),
                        new RedNamer(), new GreenNamer(), new BlueNamer(),
                        new MagentaNamer(), new YellowNamer(), new CyanNamer())
                .filter(colorNamer -> colorNamer.isApplicable(color))
                .findFirst()
                .orElseThrow()
                .name(color);
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

    interface ColorNamer {
        boolean isApplicable(Color color);

        String name(Color color);
    }

    static class WhiteNamer implements ColorNamer {
        @Override
        public boolean isApplicable(Color color) {
            return color.isMono() && !color.isBlack();
        }

        @Override
        public String name(Color color) {
            return "white";
        }
    }

    static class BlackNamer implements ColorNamer {
        @Override
        public boolean isApplicable(Color color) {
            return color.isBlack();
        }

        @Override
        public String name(Color color) {
            return "black";
        }
    }

    static class RedNamer implements ColorNamer {
        @Override
        public boolean isApplicable(Color color) {
            return color.red() > color.green() && color.red() > color.blue();
        }

        @Override
        public String name(Color color) {
            return "red";
        }
    }

    static class GreenNamer implements ColorNamer {
        @Override
        public boolean isApplicable(Color color) {
            return color.green() > color.red() && color.green() > color.blue();
        }

        @Override
        public String name(Color color) {
            return "green";
        }
    }

    static class BlueNamer implements ColorNamer {
        @Override
        public boolean isApplicable(Color color) {
            return color.blue() > color.green() && color.blue() > color.red();
        }

        @Override
        public String name(Color color) {
            return "blue";
        }
    }

    static class MagentaNamer implements ColorNamer {
        @Override
        public boolean isApplicable(Color color) {
            return color.red() == color.blue() && color.red() > color.green();
        }

        @Override
        public String name(Color color) {
            return "magenta";
        }
    }

    static class YellowNamer implements ColorNamer {
        @Override
        public boolean isApplicable(Color color) {
            return color.green() == color.red() && color.green() > color.blue();
        }

        @Override
        public String name(Color color) {
            return "yellow";
        }
    }

    static class CyanNamer implements ColorNamer {
        @Override
        public boolean isApplicable(Color color) {
            return color.blue() == color.green() && color.blue() > color.red();
        }

        @Override
        public String name(Color color) {
            return "cyan";
        }
    }
}
