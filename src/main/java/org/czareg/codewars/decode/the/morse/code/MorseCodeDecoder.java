package org.czareg.codewars.decode.the.morse.code;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
In this kata you have to write a simple Morse code decoder. While the Morse code is now mostly superseded by voice and digital data communication channels, it still has its use in some applications around the world.
The Morse code encodes every character as a sequence of "dots" and "dashes". For example, the letter A is coded as ·−, letter Q is coded as −−·−, and digit 1 is coded as ·−−−−. The Morse code is case-insensitive, traditionally capital letters are used. When the message is written in Morse code, a single space is used to separate the character codes and 3 spaces are used to separate words. For example, the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.

NOTE: Extra spaces before or after the code have no meaning and should be ignored.

In addition to letters, digits and some punctuation, there are some special service codes, the most notorious of those is the international distress signal SOS (that was first issued by Titanic), that is coded as ···−−−···. These special codes are treated as single special characters, and usually are transmitted as separate words.

Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.

For example:

MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
//should return "HEY JUDE"
NOTE: For coding purposes you have to use ASCII characters . and -, not Unicode characters.

All the test strings would contain valid Morse code, so you may skip checking for errors and exceptions. In C#, tests will fail if the solution code throws an exception, please keep that in mind. This is mostly because otherwise the engine would simply ignore the tests, resulting in a "valid" solution.
 */
@UtilityClass
class MorseCodeDecoder {

    private static final String MORSE_WORD_DELIMITER = " {3}";
    private static final String MORSE_CHARACTER_DELIMITER = " ";

    static String decode(@NonNull String morseCode) {
        return Arrays.stream(morseCode.split(MORSE_WORD_DELIMITER))
                .map(MorseCodeDecoder::toWord)
                .collect(Collectors.joining(MORSE_CHARACTER_DELIMITER))
                .strip();
    }

    private static String toWord(String morseWord) {
        return Arrays.stream(morseWord.split(MORSE_CHARACTER_DELIMITER))
                .map(MorseCode::get)
                .collect(Collectors.joining());
    }
}
