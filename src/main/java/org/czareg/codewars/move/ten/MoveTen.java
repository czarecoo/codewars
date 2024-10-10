package org.czareg.codewars.move.ten;

/*
Move every letter in the provided string forward 10 letters through the alphabet.

If it goes past 'z', start again at 'a'.

Input will be a string with length > 0.
 */
class MoveTen {

    private static final int CHARACTERS_TO_MOVE = 10;

    static String moveTen(String input) {
        return input.chars()
                .map(MoveTen::move)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static int move(int character) {
        int moved = character + CHARACTERS_TO_MOVE;
        if (moved > 'z') {
            int overflow = moved - 'z' - 1;
            moved = 'a' + overflow;
        }
        return moved;
    }
}
