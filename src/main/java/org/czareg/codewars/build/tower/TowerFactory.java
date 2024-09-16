package org.czareg.codewars.build.tower;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/*
Build a pyramid-shaped tower, as an array/list of strings, given a positive integer number of floors. A tower block is represented with "*" character.

For example, a tower with 3 floors looks like this:

[
  "  *  ",
  " *** ",
  "*****"
]
And a tower with 6 floors looks like this:

[
  "     *     ",
  "    ***    ",
  "   *****   ",
  "  *******  ",
  " ********* ",
  "***********"
]
 */
@UtilityClass
class TowerFactory {

    static String[] floors(int numberOfFloors) {
        if (numberOfFloors <= 0) {
            return new String[0];
        }
        int charactersPerFloor = numberOfFloors * 2 - 1;
        List<String> tower = new ArrayList<>();
        for (int floor = 1; floor <= numberOfFloors; floor++) {
            int starCharactersCount = floor * 2 - 1;
            int paddingCharactersOnEachSideCount = (charactersPerFloor - starCharactersCount) / 2;
            tower.add(buildFloorString(paddingCharactersOnEachSideCount, starCharactersCount));
        }
        return tower.toArray(new String[0]);
    }

    private static String buildFloorString(int paddingCount, int starCount) {
        return "%1$s%2$s%1$s".formatted(" ".repeat(paddingCount), "*".repeat(starCount));
    }
}
