package org.czareg.codewars.chess;

import lombok.experimental.UtilityClass;

import java.util.LinkedList;

/*
Given two different positions on a chess board, find the least number of moves it would take a knight to get from one to the other. The positions will be passed as two arguments in algebraic notation. For example, knight("a3", "b5") should return 1.

The knight is not allowed to move off the board. The board is 8x8.

For information on knight moves, see https://en.wikipedia.org/wiki/Knight_%28chess%29

For information on algebraic notation, see https://en.wikipedia.org/wiki/Algebraic_notation_%28chess%29

(Warning: many of the tests were generated randomly. If any do not work, the test cases will return the input, output, and expected output; please post them.)

Solution:
https://www.baeldung.com/cs/knights-shortest-path-chessboard
 */
@UtilityClass
public class PathFinder {

    public static int knight(String start, String finish) {
        if (start == null || finish == null || start.length() != 2 || finish.length() != 2) {
            throw new IllegalArgumentException();
        }
        Point startingPoint = new Point(columnLetterToNumber(start.charAt(0)), Character.getNumericValue(start.charAt(1)));
        Point finishingPoint = new Point(columnLetterToNumber(finish.charAt(0)), Character.getNumericValue(finish.charAt(1)));
        return findPath(startingPoint, finishingPoint);
    }

    private static int findPath(Point start, Point finish) {
        Point[] knightNextMoveVector = {
                new Point(-2, -1),
                new Point(-1, -2),
                new Point(1, -2),
                new Point(2, -1),
                new Point(-2, 1),
                new Point(-1, 2),
                new Point(1, 2),
                new Point(2, 1)
        };
        LinkedList<Point> k = new LinkedList<>();
        k.addFirst(start);
        boolean[][] visited = new boolean[9][9];
        visited[start.x()][start.y()] = true;
        int[][] knightMoves = new int[9][9];
        while (!k.isEmpty()) {
            Point current = k.pollLast();
            if (current.equals(finish)) {
                return knightMoves[current.x()][current.y()];
            }
            for (int i = 0; i < 8; i++) {
                Point nextMove = new Point(current.x() + knightNextMoveVector[i].x(), current.y() + knightNextMoveVector[i].y());
                if (isOnBoard(nextMove) && !visited[nextMove.x()][nextMove.y()]) {
                    visited[nextMove.x()][nextMove.y()] = true;
                    knightMoves[nextMove.x()][nextMove.y()] = knightMoves[current.x()][current.y()] + 1;
                    k.addFirst(nextMove);
                }
            }
        }
        return -1;
    }

    private static boolean isOnBoard(Point point) {
        return point.x() >= 1 && point.x() <= 8 && point.y() >= 1 && point.y() <= 8;
    }

    private static int columnLetterToNumber(char s) {
        return switch (s) {
            case 'a' -> 1;
            case 'b' -> 2;
            case 'c' -> 3;
            case 'd' -> 4;
            case 'e' -> 5;
            case 'f' -> 6;
            case 'g' -> 7;
            case 'h' -> 8;
            default -> throw new IllegalArgumentException();
        };
    }

    record Point(int x, int y) {
    }
}
