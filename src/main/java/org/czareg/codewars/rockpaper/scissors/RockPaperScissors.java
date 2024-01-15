package org.czareg.codewars.rockpaper.scissors;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

/*
Let's play! You have to return which player won! In case of a draw return Draw!.

Examples(Input1, Input2 --> Output):

"scissors", "paper" --> "Player 1 won!"
"scissors", "rock" --> "Player 2 won!"
"paper", "paper" --> "Draw!"
 */
@UtilityClass
public class RockPaperScissors {

    enum GameResult {
        PLAYER_1_WON("Player 1 won!"),
        PLAYER_2_WON("Player 2 won!"),
        DRAW("Draw!");

        private final String result;

        GameResult(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return result;
        }
    }

    enum PlayerChoice {
        SCISSORS {
            @Override
            public boolean beats(PlayerChoice playerChoice) {
                return playerChoice == PAPER;
            }
        },
        PAPER {
            @Override
            public boolean beats(PlayerChoice playerChoice) {
                return playerChoice == ROCK;
            }
        },
        ROCK {
            @Override
            public boolean beats(PlayerChoice playerChoice) {
                return playerChoice == SCISSORS;
            }
        };

        public abstract boolean beats(PlayerChoice playerChoice);
    }

    public static String rps(@NonNull String p1, @NonNull String p2) {
        PlayerChoice firstPlayerChoice = PlayerChoice.valueOf(p1.toUpperCase());
        PlayerChoice secondPlayerChoice = PlayerChoice.valueOf(p2.toUpperCase());
        GameResult gameResult = calculateGameResult(firstPlayerChoice, secondPlayerChoice);
        return gameResult.toString();
    }

    private static GameResult calculateGameResult(PlayerChoice firstPlayerChoice, PlayerChoice secondPlayerChoice) {
        if (firstPlayerChoice == secondPlayerChoice) {
            return GameResult.DRAW;
        }
        if (firstPlayerChoice.beats(secondPlayerChoice)) {
            return GameResult.PLAYER_1_WON;
        }
        return GameResult.PLAYER_2_WON;
    }
}
