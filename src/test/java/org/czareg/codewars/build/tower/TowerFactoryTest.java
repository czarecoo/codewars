package org.czareg.codewars.build.tower;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TowerFactoryTest {

    private static final char BLOCK_CHAR = '*';
    private static final char SPACE_CHAR = ' ';

    @Test
    void basicTests() {
        assertEquals(String.join(",", "*"), String.join(",", buildTower(1)));
        assertEquals(String.join(",", " * ", "***"), String.join(",", buildTower(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", buildTower(3)));
    }

    @Test
    void randomTests() {
        Random rand = new Random();
        int[] seq = IntStream.range(0, 100).toArray();
        for (int r = 0; r < 100; r++) {
            for (int p = 0; p < 100; p++) {
                if (rand.nextInt(2 + 1) == 0) {
                    int temp = seq[r];
                    seq[r] = seq[p];
                    seq[p] = temp;
                }
            }
        }

        for (int r = 0; r < 100; r++) {
            int n = seq[r];
            assertEquals(String.join(",", testTowerBuilder(n)), String.join(",", buildTower(n)));
        }
    }

    private String[] buildTower(int level) {
        Method method = null;
        try {
            method = TowerFactory.class.getDeclaredMethod("floors", int.class);
        } catch (NoSuchMethodException ignore) {
        }

        try {
            if (method == null) {
                method = TowerFactory.class.getDeclaredMethod("floors", int.class);
            }
            return (String[]) method.invoke(null, level);
        } catch (Exception cause) {
            throw new RuntimeException(cause);
        }
    }

    private static String[] testTowerBuilder(int nFloors) {
        String[] lines = new String[nFloors];
        for (int i = 1; i <= nFloors; i++) {
            lines[i - 1] = (fillString(TowerFactoryTest.SPACE_CHAR, nFloors - i) + fillString(TowerFactoryTest.BLOCK_CHAR, i * 2 - 1) + fillString(TowerFactoryTest.SPACE_CHAR, nFloors - i));
        }
        return lines;
    }

    private static String fillString(char character, int length) {
        char[] chars = new char[length];
        Arrays.fill(chars, character);
        return new String(chars);
    }
}