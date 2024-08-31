package org.czareg.codewars.go.stone.scoring;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GoGameTest {

    @Test
    @Order(1)
    void testTieNoMoves() {
        char[][] board = {
                {'X', 'X', 'X'},
                {'X', 'X', 'X'},
                {'X', 'X', 'X'}
        };
        doTest(board, new GameScore('T', 0));
    }

    @Test
    @Order(2)
    void testBlackWin() {
        char[][] board = {
                {'W', 'W', 'W', 'B', 'B', 'B'},
                {'W', 'W', 'W', 'W', 'B', 'B'},
                {'W', 'W', 'W', 'B', 'B', 'B'},
                {'W', 'X', 'W', 'B', 'B', 'B'},
                {'X', 'W', 'B', 'B', 'B', 'B'},
                {'W', 'W', 'B', 'X', 'B', 'X'}
        };
        doTest(board, new GameScore('B', 17));
    }

    @Test
    @Order(3)
    void testWhiteWin() {
        char[][] board = {
                {'X', 'B', 'B', 'B', 'W', 'X'},
                {'B', 'X', 'B', 'W', 'W', 'W'},
                {'B', 'B', 'W', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'B', 'B', 'B'},
                {'W', 'W', 'B', 'B', 'X', 'B'},
                {'X', 'W', 'W', 'W', 'B', 'X'}
        };
        doTest(board, new GameScore('W', 16));
    }

    @Test
    @Order(4)
    void testTie() {
        char[][] board = {
                {'X', 'B', 'X', 'B', 'X', 'X', 'B', 'X', 'X'},
                {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'W', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'B', 'X', 'X'},
                {'X', 'W', 'X', 'W', 'B', 'W', 'B', 'B', 'X'},
                {'W', 'B', 'W', 'B', 'X', 'B', 'W', 'B', 'X'},
                {'B', 'B', 'B', 'B', 'B', 'B', 'W', 'B', 'B'},
                {'X', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
                {'W', 'W', 'X', 'W', 'X', 'X', 'X', 'W', 'B'},
                {'X', 'X', 'X', 'W', 'B', 'X', 'X', 'W', 'B'}
        };
        doTest(board, new GameScore('T', 29));
    }

    private record TestCase(char[][] board, GameScore expected) {
    }

    private final Random rnd = new Random();

    private static void doTest(char[][] board, GameScore expected) {
        var actual = GoGame.determineWinner(board.clone());
        Supplier<String> stringify = () -> Arrays.stream(board).map(r -> "    " + new String(r)).collect(Collectors.joining("\n"));
        assertEquals(expected, actual, () -> String.format("Incorrect answer for board:%n%s%n", stringify.get()));
    }

    @Test
    @Order(5)
    void testRandomBoard() {

        var testCases = new ArrayList<TestCase>();
        for (int i = 0; i < 20; ++i) {
            int size = rnd.nextInt(3, 11);
            int winScore = rnd.nextInt(1, size * size / 2 - 1);
            testCases.add(generateCase(size, winScore, 'B'));
            testCases.add(generateCase(size, winScore, 'W'));
            testCases.add(generateCase(size, winScore, 'T'));
        }
        Collections.shuffle(testCases);
        for (TestCase testCase : testCases) {
            doTest(testCase.board(), testCase.expected());
        }
    }

    private TestCase generateCase(int size, int winScore, char winner) {
        int bs = winScore, ws = winScore;
        if (winner == 'B') {
            ws = rnd.nextInt(bs);
        } else if (winner == 'W') {
            bs = rnd.nextInt(ws);
        }
        int xs = size * size - ws - bs;
        var moves = ("B".repeat(bs) + "W".repeat(ws) + "X".repeat(xs)).chars().boxed().collect(Collectors.toList());
        Collections.shuffle(moves);
        var board = new char[size][size];
        for (int i = 0; i < size * size; ++i) {
            board[i / size][i % size] = Character.toChars(moves.get(i))[0];
        }
        return new TestCase(board, new GameScore(winner, winScore));
    }
}