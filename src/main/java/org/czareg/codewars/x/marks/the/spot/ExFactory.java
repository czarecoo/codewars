package org.czareg.codewars.x.marks.the.spot;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/*
You've made it through the moat and up the steps of knowledge. You've won the temples games and now you're hunting for treasure in the final temple run. There's good news and bad news. You've found the treasure but you've triggered a nasty trap. You'll surely perish in the temple chamber.

With your last movements, you've decided to draw an "X" marks the spot for the next archaeologist.

Given an odd number, n, draw an X for the next crew. Follow the example below.

markSpot(5) ->

X       X
  X   X
    X
  X   X
X       X

For a clearer understanding of the output, let '.' represent a space and \n the newline.
X.......X\n
..X...X\n
....X\n
..X...X\n
X.......X\n

markSpot(3) ->

X   X
  X
X   X
If n = 1 return 'X\n' and if you're given an even number or invalid input, return '?'.

The output should be a string with no spaces after the final X on each line, but a \n to indicate a new line.
 */
@UtilityClass
public class ExFactory {

    public static String markSpot(float n) {
        int levelCount = (int) n;
        if (levelCount <= 0 || levelCount % 2 == 0 || n % 1 != 0) {
            return "?";
        }
        if (levelCount == 1) {
            return "X\n";
        }
        Deque<String> topLevels = buildTopLevels(levelCount);
        String middleLevel = " ".repeat(levelCount - 1) + "X\n";
        List<String> lowerLevels = new ArrayList<>(topLevels);
        Collections.reverse(lowerLevels);
        topLevels.addLast(middleLevel);
        return Stream.concat(topLevels.stream(), lowerLevels.stream()).collect(joining());
    }

    private static Deque<String> buildTopLevels(int levels) {
        Deque<String> topLevels = new LinkedList<>();
        int exIndex = 0;
        for (int level = 1; level <= levels / 2; level++) {
            StringBuilder levelBuilder = new StringBuilder();
            for (int index = 0; index < 2 * levels - 1; index++) {
                if (exIndex == index) {
                    levelBuilder.append("X");
                } else if (2 * levels - exIndex - 2 == index) {
                    levelBuilder.append("X");
                    break;
                } else {
                    levelBuilder.append(" ");
                }
            }
            exIndex += 2;
            levelBuilder.append("\n");
            topLevels.addLast(levelBuilder.toString());
        }
        return topLevels;
    }
}
