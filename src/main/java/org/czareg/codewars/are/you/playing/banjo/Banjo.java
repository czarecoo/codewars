package org.czareg.codewars.are.you.playing.banjo;

import lombok.experimental.UtilityClass;

import java.util.Set;

/*
Create a function which answers the question "Are you playing banjo?".
If your name starts with the letter "R" or lower case "r", you are playing banjo!

The function takes a name as its only argument, and returns one of the following strings:

name + " plays banjo"
name + " does not play banjo"
Names given are always valid strings.
 */
@UtilityClass
class Banjo {

    private static final String PLAYS_TEMPLATE = "%s plays banjo";
    private static final String DOES_NOT_PLAY_TEMPLATE = "%s does not play banjo";
    private static final Set<Character> EXPECTED_STARTING_LETTER = Set.of('R', 'r');

    static String areYouPlayingBanjo(String name) {
        char firstLetter = name.charAt(0);
        boolean isPlayingBanjo = EXPECTED_STARTING_LETTER.stream().anyMatch(expected -> expected.equals(firstLetter));
        return isPlayingBanjo ? PLAYS_TEMPLATE.formatted(name) : DOES_NOT_PLAY_TEMPLATE.formatted(name);
    }
}
