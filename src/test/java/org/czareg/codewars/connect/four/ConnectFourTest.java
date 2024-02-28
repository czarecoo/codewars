package org.czareg.codewars.connect.four;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConnectFourTest {

    /*
    - - - - - - -
    - - - - - - -
    - - - - - - -
    - Y - - - - -
    R Y - - - - -
    R Y - - - - -
    R Y - - - - R
     */
    @Test
    void firstTest() {
        List<String> myList = new ArrayList<>(Arrays.asList("A_Red", "B_Yellow", "A_Red", "B_Yellow", "A_Red",
                "B_Yellow", "G_Red", "B_Yellow"));
        assertEquals("Yellow", ConnectFour.whoIsWinner(myList));
    }

    /*
    - - - - - - -
    - - - Y - - -
    - - - R - - -
    R Y R Y - - Y <- Y wins diagonally
    Y Y R R R Y R
    Y R Y Y Y R R
    R R Y Y R R Y
     */
    @Test
    void secondTest() {
        List<String> myList = new ArrayList<>(Arrays.asList("C_Yellow", "E_Red", "G_Yellow", "B_Red", "D_Yellow",
                "B_Red", "B_Yellow", "G_Red", "C_Yellow", "C_Red", "D_Yellow", "F_Red", "E_Yellow", "A_Red", "A_Yellow",
                "G_Red", "A_Yellow", "F_Red", "F_Yellow", "D_Red", "B_Yellow", "E_Red", "D_Yellow", "A_Red", "G_Yellow",
                "D_Red", "D_Yellow", "C_Red"));
        assertEquals("Yellow", ConnectFour.whoIsWinner(myList));
    }

    /*
    - - - - - - -
    - - - - - - -
    - - - - - - -
    - - - Y - - -
    - - Y R - - Y
    - Y R R - - Y
    Y R R R R Y Y <- Red wins vertically
     */
    @Test
    void thirdTest() {
        List<String> myList = new ArrayList<>(Arrays.asList("A_Yellow", "B_Red", "B_Yellow", "C_Red", "G_Yellow",
                "C_Red", "C_Yellow", "D_Red", "G_Yellow", "D_Red", "G_Yellow", "D_Red", "F_Yellow", "E_Red", "D_Yellow"));
        assertEquals("Red", ConnectFour.whoIsWinner(myList));
    }

    @Test
    void randomTest() {
        for (int i = 0; i < 100; i++) {
            RgConnectFour rg = new RgConnectFour((int) (Math.random() * 10000));
            List<String> myList = rg.listOfPositions();
            assertEquals(ConnectFour2January.whoIsWinner(myList), ConnectFour.whoIsWinner(myList));
        }
    }

    final static private class ConnectFour2January {
        private static final int NUM_ROWS = 6;
        private static final int NUM_COLS = 7;
        private static final int NUM_WIN = 4;

        private static final int[] dir = {
                0, 1, 1, 0, 1, 1, 1, -1
        };

        private static int[][] grid;

        private static int query(int r, int c) {
            if (r < 0 || r >= NUM_ROWS || c < 0 || c >= NUM_COLS)
                return 0;
            else
                return grid[r][c];
        }

        private static int check(int r, int c, int dr, int dc) {
            if (grid[r][c] == 0)
                return 0;

            int sum = 1;
            for (int d = 1; d < NUM_WIN; d++)
                if (grid[r][c] == query(r + d * dr, c + d * dc))
                    sum++;
                else
                    break;
            for (int d = 1; d < NUM_WIN; d++)
                if (grid[r][c] == query(r - d * dr, c - d * dc))
                    sum++;
                else
                    break;
            return sum >= NUM_WIN ? grid[r][c] : 0;
        }

        private static String whoIsWinner(List<String> pieces) {
            grid = new int[NUM_ROWS][NUM_COLS];
            int[] counts = new int[NUM_COLS];

            for (String piece : pieces) {
                int col = piece.charAt(0) - 'A';
                int row = NUM_ROWS - 1 - counts[col]++;
                grid[row][col] = piece.endsWith("Yellow") ? 1 : 2;

                for (int d = 0; d < dir.length; d += 2) {
                    int result = check(row, col, dir[d], dir[d + 1]);
                    if (result > 0)
                        return result == 1 ? "Yellow" : "Red";
                }
            }

            return "Draw";
        }
    }


    final static private class RgConnectFour {
        private static Random _random;
        private static int _counter;

        private RgConnectFour(int seed) {
            _counter = _counter + 1;
            _random = new Random(seed + _counter);
        }

        private final List<List<String>> _listOfList = Arrays.asList(
                new ArrayList<>(Arrays.asList("A", "A", "A", "A", "A", "A")),
                new ArrayList<>(Arrays.asList("B", "B", "B", "B", "B", "B")),
                new ArrayList<>(Arrays.asList("C", "C", "C", "C", "C", "C")),
                new ArrayList<>(Arrays.asList("D", "D", "D", "D", "D", "D")),
                new ArrayList<>(Arrays.asList("E", "E", "E", "E", "E", "E")),
                new ArrayList<>(Arrays.asList("F", "F", "F", "F", "F", "F")),
                new ArrayList<>(Arrays.asList("G", "G", "G", "G", "G", "G"))
        );

        private List<String> listOfPositions() {
            int myCounter = 0;
            List<String> myList = new ArrayList<>();
            do {
                int indexer = _random.nextInt(7);
                if (!_listOfList.get(indexer).isEmpty()) {
                    myCounter++;
                    myList.add(_listOfList.get(indexer).get(0) + (myCounter % 2 == 0 ? "_Red" : "_Yellow"));
                    _listOfList.get(indexer).remove(_listOfList.get(indexer).size() - 1);
                }
            } while (_listOfList.stream().anyMatch(p -> !p.isEmpty()));
            return myList;
        }
    }
}