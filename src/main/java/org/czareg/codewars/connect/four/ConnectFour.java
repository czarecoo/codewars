package org.czareg.codewars.connect.four;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
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

    private static final int BOARD_HEIGHT = 6;
    private static final int BOARD_WIDTH = 7;
    private static final int WINNING_LENGTH = 4;

    @Getter
    @RequiredArgsConstructor
    enum Color {

        YELLOW("Yellow"),
        RED("Red");

        private final String text;
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
        return checkVertical(board)
                .or(() -> checkHorizontal(board))
                .or(() -> checkDiagonallyFromUpperLeft(board))
                .or(() -> checkDiagonallyFromUpperRight(board))
                .map(Color::getText)
                .orElse(null);
    }

    private static Optional<Color> checkVertical(List<List<Color>> board) {
        Deque<Color> deque = new LinkedList<>();
        for (List<Color> colors : board) {
            for (Color color : colors) {
                addLastIfOverMaxRemoveFirst(color, deque);
                if (didSomeoneWin(deque)) {
                    return Optional.ofNullable(deque.peekFirst());
                }
            }
            deque.clear();
        }
        return Optional.empty();
    }

    private static Optional<Color> checkHorizontal(List<List<Color>> board) {
        Deque<Color> deque = new LinkedList<>();
        for (int rowIndex = 0; rowIndex < BOARD_HEIGHT; rowIndex++) {
            for (int columnIndex = 0; columnIndex < BOARD_WIDTH; columnIndex++) {
                List<Color> column = board.get(columnIndex);
                if (rowIndex > column.size() - 1) {
                    deque.clear();
                    continue;
                }
                Color color = column.get(rowIndex);
                addLastIfOverMaxRemoveFirst(color, deque);
                if (didSomeoneWin(deque)) {
                    return Optional.ofNullable(deque.peekFirst());
                }
            }
            deque.clear();
        }
        return Optional.empty();
    }

    private static Optional<Color> checkDiagonallyFromUpperLeft(List<List<Color>> board) {
        Deque<Color> deque = new LinkedList<>();
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                deque.clear();
                for (int offset = 0; offset < 4; offset++) {
                    if (board.get(col + offset).size() > row - offset) {
                        addLastIfOverMaxRemoveFirst(board.get(col + offset).get(row - offset), deque);
                    }
                }
                if (didSomeoneWin(deque)) {
                    return Optional.ofNullable(deque.peekFirst());
                }
            }
        }
        return Optional.empty();
    }

    private static Optional<Color> checkDiagonallyFromUpperRight(List<List<Color>> board) {
        Deque<Color> deque = new LinkedList<>();
        for (int row = 3; row < 6; row++) {
            for (int col = 6; col > 2; col--) {
                deque.clear();
                for (int offset = 0; offset < 4; offset++) {
                    if (board.get(col - offset).size() > row - offset) {
                        addLastIfOverMaxRemoveFirst(board.get(col - offset).get(row - offset), deque);
                    }
                }
                if (didSomeoneWin(deque)) {
                    return Optional.ofNullable(deque.peekFirst());
                }
            }
        }
        return Optional.empty();
    }

    private static void addLastIfOverMaxRemoveFirst(Color color, Deque<Color> deque) {
        deque.addLast(color);
        if (deque.size() > WINNING_LENGTH) {
            deque.removeFirst();
        }
    }

    private static boolean didSomeoneWin(Deque<Color> deque) {
        if (deque.size() < WINNING_LENGTH) {
            return false;
        }
        Color firstColor = deque.peekFirst();
        return deque.stream().allMatch(firstColor::equals);
    }
}
