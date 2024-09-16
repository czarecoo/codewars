package org.czareg.codewars.battle.ships;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.function.Predicate.isEqual;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/*
Your task in the kata is to determine how many boats are sunk damaged and untouched from a set amount of attacks.
You will need to create a function that takes two arguments, the playing board and the attacks.

Boats are placed either horizontally, vertically or diagonally on the board. 0 represents a space not occupied by a boat.
Digits 1-3 represent boats which vary in length 1-4 spaces long. There will always be at least 1 boat up to a maximum of 3 in any one game.
Boat sizes and board dimentions will vary from game to game.

Attacks
Attacks are calculated from the bottom left, first the X coordinate then the Y. There will be at least one attack per game,
and the array will not contain duplicates.

[2, 1] [1, 3] [4, 2]
First attack      `[2, 1]` = `3`
Second attack `[1, 3]` = `0`
Third attack     `[4, 2]` = `1`
Function Initialization
int[][] board   = new int[][] {new int[] {0,0,1,0},
                               new int[] {0,0,1,0},
                               new int[] {0,0,1,0}};
int[][] attacks = new int[][] {new int[] {3,1},new int[] {3,2},new int[] {3,3}};
BattleShips.damagedOrSunk(board, attacks);
Scoring
1 point for every whole boat sank.
0.5 points for each boat hit at least once (not including boats that are sunk).
-1 point for each whole boat that was not hit at least once.
Sunk or Damaged
`sunk` = all boats that are sunk
`damaged` = all boats that have been hit at least once but not sunk
`notTouched/not_touched` = all boats that have not been hit at least once
Output
You should return a hash with the following data

Example Game Output
In our above example

First attack: `boat 3` was damaged, which increases the `points` by `0.5`
Second attack: miss nothing happens
Third attack: `boat 1` was damaged, which increases the `points` by `0.5`
`boat 2` was untouched so `points -1` and `notTouched +1` in Javascript/Java/C# and `not_touched +1` in Python/Ruby.
No whole boats sank
 */
@UtilityClass
class BattleShips {

    static Map<String, Double> damagedOrSunk(final int[][] board, final int[][] attacks) {
        Map<Integer, Long> shipNumberByParts = toShipNumberByParts(board);
        Map<Integer, Long> shipNumberByHits = toShipNumberByHits(board, attacks);
        double sunk = calculateSunk(shipNumberByParts, shipNumberByHits);
        double damaged = calculateDamaged(shipNumberByHits, sunk);
        double notTouched = calculateNotTouched(shipNumberByParts, shipNumberByHits);
        double points = calculatePoints(sunk, damaged, notTouched);
        return Map.of(
                "sunk", sunk,
                "damaged", damaged,
                "notTouched", notTouched,
                "points", points
        );
    }

    private static Map<Integer, Long> toShipNumberByParts(int[][] board) {
        return Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .filter(not(isEqual(0)))
                .collect(groupingBy(identity(), counting()));
    }

    private static Map<Integer, Long> toShipNumberByHits(int[][] board, int[][] attacks) {
        Map<Integer, Long> shipNumberByHits = new HashMap<>();
        int rows = board.length;
        for (int[] attack : attacks) {
            int xIndex = translateXIndex(attack);
            int yIndex = translateYIndex(attack, rows);
            int shipNumber = board[yIndex][xIndex];
            if (shipNumber != 0) {
                long currentShipHits = shipNumberByHits.getOrDefault(shipNumber, 0L);
                shipNumberByHits.put(shipNumber, currentShipHits + 1L);
            }
        }
        return shipNumberByHits;
    }

    private static int translateXIndex(int[] attack) {
        return attack[0] - 1;
    }

    private static int translateYIndex(int[] attack, int rows) {
        return rows - attack[1];
    }

    private static double calculateSunk(Map<Integer, Long> shipNumberByParts, Map<Integer, Long> shipNumberByHits) {
        double sunk = 0;
        for (Map.Entry<Integer, Long> entry : shipNumberByHits.entrySet()) {
            int shipNumber = entry.getKey();
            long shipHits = entry.getValue();
            long shipParts = shipNumberByParts.getOrDefault(shipNumber, 0L);
            if (shipParts == shipHits) {
                sunk++;
            }
        }
        return sunk;
    }

    private static double calculateDamaged(Map<Integer, Long> shipNumberByHits, double sunk) {
        return shipNumberByHits.size() - sunk;
    }

    private static double calculateNotTouched(Map<Integer, Long> shipNumberByParts, Map<Integer, Long> shipNumberByHits) {
        return (double) shipNumberByParts.size() - shipNumberByHits.size();
    }

    private static double calculatePoints(double sunk, double damaged, double notTouched) {
        return sunk - notTouched + 0.5 * damaged;
    }
}
