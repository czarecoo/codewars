package org.czareg.codewars.bowling.pins;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingTest {

    @Test
    void exampleTests() {
        Bowling bowling = new Bowling();
        int[] testArray = new int[]{1, 2, 3};
        assertEquals("I I I I\n I I I \n       \n       ", bowling.bowlingPins(testArray));

        testArray = new int[]{3, 5, 9};
        assertEquals("I I   I\n I   I \n  I    \n   I   ", bowling.bowlingPins(testArray));
    }

    @Test
    void randomTests() {
        Bowling bowling = new Bowling();
        for (int i = 0; i < 50; i++) {
            int[] rnd = getRandomArray();
            assertEquals(countdown(rnd), bowling.bowlingPins(rnd));
        }
    }

    public int[] getRandomArray() {
        int times = (int) (Math.random() * 11);
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            int rnd = (int) (Math.random() * 10 + 1);
            if (!arrList.contains(rnd)) {
                arrList.add(rnd);
            }
        }
        int[] res = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            res[i] = arrList.get(i);
        }
        return res;
    }

    public String countdown(int[] arr) {
        StringBuilder pins = new StringBuilder();
        int rowLength = 4;
        int maxLength = 4;
        int[] init = new int[]{7, 8, 9, 10, 4, 5, 6, 2, 3, 1};
        for (int i = 0; i < init.length; ) {
            pins.append(new String(new char[maxLength - rowLength]).replace("\0", " "));
            for (int r = 0; r < rowLength; r++) {
                if (!containsInt(arr, init[i])) {
                    pins.append("I");
                } else {
                    pins.append(" ");
                }
                pins.append(r + 1 < rowLength ? " " : "");
                i++;
            }
            pins.append(new String(new char[maxLength - rowLength]).replace("\0", " "));
            pins.append(rowLength > 1 ? "\n" : "");
            rowLength--;
        }
        return pins.toString();
    }

    public boolean containsInt(int[] arr, int n) {
        boolean isIn = false;
        for (int i : arr) {
            if (i == n) {
                isIn = true;
                break;
            }
        }
        return isIn;
    }
}