package org.czareg.codewars.block.letter.printer;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

/*
Write a function that accepts a string consisting only of ASCII letters and space(s) and returns that string in block letters of 5 characters width and 7 characters height, with one space between characters.

The string should be formatted in a way that when passed to Javas' System.out.println() function shows the desired output (see below for example).

The block letters should consist of corresponding capital letters.
It's irrelevant whether input consists of lower or upper case letters.
Any leading and/or trailing spaces in input should be ignored.
Empty strings or such containing only spaces should return an empty string.
The remaining spaces (between letters and/or words) are to be treated as any other character. This means that there will be six spaces in output for a space in input, or a multiple of six, if there were more spaces - plus the one from preceding character!
Trailing spaces should be removed in the resulting string (and also in its' substrings!).
 */
@UtilityClass
public class BlockLetterPrinter {

    private static final String TEMPLATE = """
             AAA  BBBB   CCC  DDDD  EEEEE FFFFF  GGG  H   H IIIII JJJJJ K   K L     M   M N   N  OOO  PPPP   QQQ  RRRR   SSS  TTTTT U   U V   V W   W X   X Y   Y ZZZZZ \s
            A   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     MM MM NN  N O   O P   P Q   Q R   R S   S   T   U   U V   V W   W X   X Y   Y     Z \s
            A   A B   B C     D   D E     F     G     H   H   I       J K K   L     M M M N   N O   O P   P Q   Q R   R S       T   U   U V   V W   W  X X   Y Y     Z  \s
            AAAAA BBBB  C     D   D EEEEE FFFFF G GGG HHHHH   I       J KK    L     M   M N N N O   O PPPP  Q   Q RRRR   SSS    T   U   U V   V W W W   X     Y     Z   \s
            A   A B   B C     D   D E     F     G   G H   H   I       J K K   L     M   M N   N O   O P     Q Q Q R R       S   T   U   U V   V W W W  X X    Y    Z    \s
            A   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     M   M N  NN O   O P     Q  QQ R  R  S   S   T   U   U  V V  W W W X   X   Y   Z     \s
            A   A BBBB   CCC  DDDD  EEEEE F      GGG  H   H IIIII JJJJ  K   K LLLLL M   M N   N  OOO  P      QQQQ R   R  SSS    T    UUU    V    W W  X   X   Y   ZZZZZ \s
            """;

    public static String blockPrint(String string) {
        String letters = string.strip().toUpperCase();
        List<String> list = Arrays.asList(TEMPLATE.split("\n"));
        StringBuilder stringBuilder = new StringBuilder();
        for (int rowIndex = 0; rowIndex < 7; rowIndex++) {
            for (int letterIndex = 0; letterIndex < letters.length(); letterIndex++) {
                char letter = letters.charAt(letterIndex);
                if (Character.isWhitespace(letter)) {
                    stringBuilder.append("      ");
                } else {
                    String row = list.get(rowIndex);
                    int startIndex = (letter - 'A') * 6;
                    int endIndex = startIndex + 6;
                    String substring = row.substring(startIndex, endIndex);
                    if (letterIndex + 1 >= letters.length()) {
                        substring = substring.stripTrailing();
                    }
                    stringBuilder.append(substring);
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().stripTrailing();
    }
}
