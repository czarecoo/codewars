package org.czareg.codewars.directions.reduction;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DirReductionTest {

    @Test
    void testSimpleDirReduc() {
        assertArrayEquals(new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals(new String[]{},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}));
        assertArrayEquals(new String[]{"NORTH"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "NORTH"}));
        assertArrayEquals(new String[]{"EAST", "NORTH"},
                DirReduction.dirReduc(new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"}));
        assertArrayEquals(new String[]{"NORTH", "EAST"},
                DirReduction.dirReduc(new String[]{"NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH"}));
        assertArrayEquals(new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
                DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
        assertArrayEquals(new String[]{"WEST", "WEST"},
                DirReduction.dirReduc(new String[]{"EAST", "WEST", "WEST", "WEST"}));
    }

    String[] randDir(int n) {
        String[] dirs = new String[]{"NORTH", "SOUTH", "EAST", "WEST"};
        String[] result = new String[n];
        for (int i = 0; i < n; ++i) {
            result[i] = dirs[(int) (Math.random() * 4)];
        }
        return result;
    }

    String[] doDirReduc(String[] arr) {
        if (arr == null) return new String[]{};
        if (arr.length < 2) return arr;
        int i = 0;
        List<String> directions = Arrays.stream(arr).collect(Collectors.toList());
        do {
            String tmp = directions.get(i) + directions.get(i + 1);
            if (tmp.equals("NORTHSOUTH") || tmp.equals("SOUTHNORTH") || tmp.equals("EASTWEST") || tmp.equals("WESTEAST")) {
                directions.remove(i + 1);
                directions.remove(i);
                if (i > 0) i--;
            } else
                i++;
        } while (i < directions.size() - 1);
        return directions.toArray(String[]::new);
    }

    @Test
    void testRandomDirReduc() {
        String[] u10 = randDir(10);
        assertArrayEquals(doDirReduc(u10), DirReduction.dirReduc(u10));
        String[] u15 = randDir(15);
        assertArrayEquals(doDirReduc(u15), DirReduction.dirReduc(u15));
        String[] u30 = randDir(30);
        assertArrayEquals(doDirReduc(u30), DirReduction.dirReduc(u30));
    }
}