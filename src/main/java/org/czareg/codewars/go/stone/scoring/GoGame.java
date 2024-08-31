package org.czareg.codewars.go.stone.scoring;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
One traditional method of determining the winning side of a Go match is called stone scoring. This method has some flaws but is algorithmically the easiest one. Therefore, we will start of with this method.

Your puzzle input is a 2D collection that represents a Go board like:

board = [
    [W, W, W, B, B, B],
    [W, W, W, W, B, B],
    [W, W, W, B, B, B],
    [W, X, W, B, B, B],
    [X, W, B, B, B, B],
    [W, W, B, X, B, X]
]
B represent fields with black stones, W represent fields with white stones, and X represent empty fields. Your task is to determine the winning side, i.e. the side with more stones on the board. Then, return either W or B and the number of the side's stones as a tuple depending on which side has more stones on the board. If there is a tie, return a T and the number of stones of one side as a tuple. Empty fields are not considered in this method for determining the winning side. Thus, they can be ignored.

In the example, B has 17 stones on the boards whereas W only has 15. Hence, the black side won and ("B", 17) should be returned.

Be aware that the board can vary in size but is at least of size 3x3!
 */
@UtilityClass
class GoGame {

    private static final Set<Character> ALLOWED_LETTERS = Set.of('W', 'B');

    static GameScore determineWinner(char[][] board) {
        List<GameScore> scoreSortedFromHighest = processToSortedGameScores(board);
        return determineWinner(scoreSortedFromHighest);
    }

    private static List<GameScore> processToSortedGameScores(char[][] board) {
        return Arrays.stream(board)
                .flatMap(chars -> IntStream.range(0, chars.length)
                        .mapToObj(i -> chars[i])
                )
                .filter(ALLOWED_LETTERS::contains)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry -> new GameScore(entry.getKey(), entry.getValue().intValue()))
                .sorted(Comparator.comparingInt(GameScore::count).reversed())
                .toList();
    }

    private static GameScore determineWinner(List<GameScore> scoreSortedFromHighest) {
        if (scoreSortedFromHighest.isEmpty()) {
            return new GameScore('T', 0);
        }
        GameScore highestScore = scoreSortedFromHighest.getFirst();
        if (scoreSortedFromHighest.size() == 1) {
            return highestScore;
        }
        boolean areAllTied = scoreSortedFromHighest.stream()
                .map(GameScore::count)
                .allMatch(count -> count == highestScore.count());
        if (areAllTied) {
            return new GameScore('T', highestScore.count());
        }
        return highestScore;
    }
}
