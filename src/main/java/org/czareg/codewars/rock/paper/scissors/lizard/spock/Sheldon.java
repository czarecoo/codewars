package org.czareg.codewars.rock.paper.scissors.lizard.spock;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

@UtilityClass
public class Sheldon {

    public static String rpsls(String player1, String player2) {
        Shape firstShape = Shape.valueOf(player1.toUpperCase());
        Shape secondShape = Shape.valueOf(player2.toUpperCase());
        Result result = Game.play(firstShape, secondShape);
        return result.getText();
    }

    enum Shape {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK;
        private static final Map<Shape, Set<Shape>> WIN_MAP = new EnumMap<>(Shape.class);

        static {
            WIN_MAP.put(ROCK, Set.of(Shape.LIZARD, Shape.SCISSORS));
            WIN_MAP.put(PAPER, Set.of(Shape.ROCK, Shape.SPOCK));
            WIN_MAP.put(SCISSORS, Set.of(Shape.PAPER, Shape.LIZARD));
            WIN_MAP.put(LIZARD, Set.of(Shape.SPOCK, Shape.PAPER));
            WIN_MAP.put(SPOCK, Set.of(Shape.SCISSORS, Shape.ROCK));
        }

        Set<Shape> beats() {
            return WIN_MAP.get(this);
        }
    }

    @UtilityClass
    class Game {
        static Result play(Shape firstShape, Shape secondShape) {
            if (firstShape.equals(secondShape)) {
                return Result.DRAW;
            }
            if (firstShape.beats().contains(secondShape)) {
                return Result.PLAYER_1_WINS;
            }
            return Result.PLAYER_2_WINS;
        }
    }

    @Getter
    @RequiredArgsConstructor
    enum Result {
        PLAYER_1_WINS("Player 1 Won!"),
        PLAYER_2_WINS("Player 2 Won!"),
        DRAW("Draw!");
        private final String text;
    }
}
