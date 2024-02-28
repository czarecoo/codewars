package org.czareg.codewars.connect.four;

import lombok.experimental.UtilityClass;

import java.util.*;

/*
Take a look at wiki description of Connect Four game:

Wiki Connect Four

The grid is 6 row by 7 columns, those being named from A to G.

You will receive a list of strings showing the order of the pieces which dropped in columns:
["A_Red","B_Yellow","A_Red","B_Yellow","A_Red","B_Yellow","G_Red","B_Yellow"]
The list may contain up to 42 moves and shows the order the players are playing.

The first player who connects four items of the same color is the winner.

You should return "Yellow", "Red" or "Draw" accordingly.
 */
@UtilityClass
public class ConnectFour {

    private static final Map<String, Integer> COLUMNS = Map.of(
            "A", 0, "B", 1, "C", 2, "D", 3, "E", 4, "F", 5, "G", 6
    );

    enum Color {

        YELLOW("Yellow"),
        RED("Red");

        private final String text;

        Color(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    public static String whoIsWinner(List<String> moves) {
        List<List<Color>> board = List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        for (String move : moves) {
            extractColorAndAddToTheBoard(move, board);
            String winner = checkWhoWon(board);
            if (winner != null) {
                return winner;
            }
        }
        return "Draw";
    }

    private static void extractColorAndAddToTheBoard(String s, List<List<Color>> board) {
        String[] split = s.split("_");
        int column = COLUMNS.get(split[0]);
        Color color = Color.valueOf(split[1].toUpperCase());
        board.get(column).add(color);
    }

    private static String checkWhoWon(List<List<Color>> board) {
        Color winner;
        winner = checkVertical(board);
        if (winner != null) {
            return winner.getText();
        }
        winner = checkHorizontal(board);
        if (winner != null) {
            return winner.getText();
        }
        winner = checkDiagonally(board);
        if (winner != null) {
            return winner.getText();
        }
        return null;
    }

    private static Color checkVertical(List<List<Color>> board) {
        Deque<Color> deque = new LinkedList<>();
        for (List<Color> colors : board) {
            for (Color color : colors) {
                addLastIfOverMaxRemoveFirst(color, deque);
                if (didSomeoneWin(deque)) {
                    return deque.peekFirst();
                }
            }
            deque.clear();
        }
        return null;
    }

    private static Color checkHorizontal(List<List<Color>> board) {
        Deque<Color> deque = new LinkedList<>();
        for (int rowIndex = 0; rowIndex < 6; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 7; columnIndex++) {
                List<Color> column = board.get(columnIndex);
                if (rowIndex > column.size() - 1) {
                    deque.clear();
                    continue;
                }
                Color color = column.get(rowIndex);
                addLastIfOverMaxRemoveFirst(color, deque);
                if (didSomeoneWin(deque)) {
                    return deque.peekFirst();
                }
            }
            deque.clear();
        }
        return null;
    }

    private static Color checkDiagonally(List<List<Color>> board) {
        Deque<Color> deque = new LinkedList<>();

        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                deque.clear();
                for (int k = 0; k < 4; k++) {
                    if (board.get(col + k).size() > row - k) {
                        addLastIfOverMaxRemoveFirst(board.get(col + k).get(row - k), deque);
                    }
                }
                if (didSomeoneWin(deque)) {
                    return deque.peekFirst();
                }
            }
        }

        for (int row = 3; row < 6; row++) {
            for (int col = 6; col > 2; col--) {
                deque.clear();
                for (int k = 0; k < 4; k++) {
                    if (board.get(col - k).size() > row - k) {
                        addLastIfOverMaxRemoveFirst(board.get(col - k).get(row - k), deque);
                    }
                }
                if (didSomeoneWin(deque)) {
                    return deque.peekFirst();
                }
            }
        }

        return null;
    }

    private static void addLastIfOverMaxRemoveFirst(Color color, Deque<Color> deque) {
        deque.addLast(color);
        if (deque.size() > 4) {
            deque.removeFirst();
        }
    }

    private static boolean didSomeoneWin(Deque<Color> deque) {
        if (deque.size() != 4) {
            return false;
        }
        Color firstColor = deque.peekFirst();
        for (Color color : deque) {
            if (color != firstColor) {
                return false;
            }
        }
        return true;
    }
}
