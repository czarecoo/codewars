package org.czareg.codewars.block.letter.printer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockLetterPrinterTest {

    @Test
    @DisplayName("Basic tests")
    void basicTests() {
        assertEquals("H   H EEEEE L     L      OOO        W   W  OOO  RRRR  L     DDDD\nH   H E     L     L     O   O       W   W O   O R   R L     D   D\nH   H E     L     L     O   O       W   W O   O R   R L     D   D\nHHHHH EEEEE L     L     O   O       W W W O   O RRRR  L     D   D\nH   H E     L     L     O   O       W W W O   O R R   L     D   D\nH   H E     L     L     O   O       W W W O   O R  R  L     D   D\nH   H EEEEE LLLLL LLLLL  OOO         W W   OOO  R   R LLLLL DDDD", BlockLetterPrinter.blockPrint("heLLo WorLD"), "Most probably something is wrong with trailing whitespace and/or end-of-line characters!\n");
        assertEquals(" AAA  BBBB   CCC  DDDD  EEEEE FFFFF  GGG  H   H IIIII JJJJJ K   K L     M   M\nA   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     MM MM\nA   A B   B C     D   D E     F     G     H   H   I       J K K   L     M M M\nAAAAA BBBB  C     D   D EEEEE FFFFF G GGG HHHHH   I       J KK    L     M   M\nA   A B   B C     D   D E     F     G   G H   H   I       J K K   L     M   M\nA   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     M   M\nA   A BBBB   CCC  DDDD  EEEEE F      GGG  H   H IIIII JJJJ  K   K LLLLL M   M", BlockLetterPrinter.blockPrint("ABCDEFGHIJKLM"), "Most probably something is wrong with trailing whitespace and/or end-of-line characters!\n");
        assertEquals("N   N  OOO  PPPP   QQQ  RRRR   SSS  TTTTT U   U V   V W   W X   X Y   Y ZZZZZ\nNN  N O   O P   P Q   Q R   R S   S   T   U   U V   V W   W X   X Y   Y     Z\nN   N O   O P   P Q   Q R   R S       T   U   U V   V W   W  X X   Y Y     Z\nN N N O   O PPPP  Q   Q RRRR   SSS    T   U   U V   V W W W   X     Y     Z\nN   N O   O P     Q Q Q R R       S   T   U   U V   V W W W  X X    Y    Z\nN  NN O   O P     Q  QQ R  R  S   S   T   U   U  V V  W W W X   X   Y   Z\nN   N  OOO  P      QQQQ R   R  SSS    T    UUU    V    W W  X   X   Y   ZZZZZ", BlockLetterPrinter.blockPrint("NOPQRSTUVWXYZ"), "Most probably something is wrong with trailing whitespace and/or end-of-line characters!\n");
        assertEquals(" SSS   AAA  M   M EEEEE\nS   S A   A MM MM E\nS     A   A M M M E\n SSS  AAAAA M   M EEEEE\n    S A   A M   M E\nS   S A   A M   M E\n SSS  A   A M   M EEEEE", BlockLetterPrinter.blockPrint("   same"), "Most probably something is wrong with trailing whitespace and/or end-of-line characters!\n");
        assertEquals(" SSS   AAA  M   M EEEEE\nS   S A   A MM MM E\nS     A   A M M M E\n SSS  AAAAA M   M EEEEE\n    S A   A M   M E\nS   S A   A M   M E\n SSS  A   A M   M EEEEE", BlockLetterPrinter.blockPrint("same   "), "Most probably something is wrong with trailing whitespace and/or end-of-line characters!\n");
        assertEquals("BBBB  U   U TTTTT                   DDDD  IIIII FFFFF FFFFF EEEEE RRRR  EEEEE N   N TTTTT\nB   B U   U   T                     D   D   I   F     F     E     R   R E     NN  N   T\nB   B U   U   T                     D   D   I   F     F     E     R   R E     N   N   T\nBBBB  U   U   T                     D   D   I   FFFFF FFFFF EEEEE RRRR  EEEEE N N N   T\nB   B U   U   T                     D   D   I   F     F     E     R R   E     N   N   T\nB   B U   U   T                     D   D   I   F     F     E     R  R  E     N  NN   T\nBBBB   UUU    T                     DDDD  IIIII F     F     EEEEE R   R EEEEE N   N   T", BlockLetterPrinter.blockPrint("   but   different   "), "Most probably something is wrong with trailing whitespace and/or end-of-line characters!\n");
        assertEquals("", BlockLetterPrinter.blockPrint(" "), "Most probably something is wrong with trailing whitespace and/or end-of-line characters!\n");
    }

    private static final Map<String, String[]> alpha = new HashMap<>();

    private static String solution(String input) {
        alpha.put(" ", new String[]{"     ", "     ", "     ", "     ", "     ", "     ", "     "});
        alpha.put("a", new String[]{" AAA ", "A   A", "A   A", "AAAAA", "A   A", "A   A", "A   A"});
        alpha.put("b", new String[]{"BBBB ", "B   B", "B   B", "BBBB ", "B   B", "B   B", "BBBB "});
        alpha.put("c", new String[]{" CCC ", "C   C", "C    ", "C    ", "C    ", "C   C", " CCC "});
        alpha.put("d", new String[]{"DDDD ", "D   D", "D   D", "D   D", "D   D", "D   D", "DDDD "});
        alpha.put("e", new String[]{"EEEEE", "E    ", "E    ", "EEEEE", "E    ", "E    ", "EEEEE"});
        alpha.put("f", new String[]{"FFFFF", "F    ", "F    ", "FFFFF", "F    ", "F    ", "F    "});
        alpha.put("g", new String[]{" GGG ", "G   G", "G    ", "G GGG", "G   G", "G   G", " GGG "});
        alpha.put("h", new String[]{"H   H", "H   H", "H   H", "HHHHH", "H   H", "H   H", "H   H"});
        alpha.put("i", new String[]{"IIIII", "  I  ", "  I  ", "  I  ", "  I  ", "  I  ", "IIIII"});
        alpha.put("j", new String[]{"JJJJJ", "    J", "    J", "    J", "    J", "    J", "JJJJ "});
        alpha.put("k", new String[]{"K   K", "K  K ", "K K  ", "KK   ", "K K  ", "K  K ", "K   K"});
        alpha.put("l", new String[]{"L    ", "L    ", "L    ", "L    ", "L    ", "L    ", "LLLLL"});
        alpha.put("m", new String[]{"M   M", "MM MM", "M M M", "M   M", "M   M", "M   M", "M   M"});
        alpha.put("n", new String[]{"N   N", "NN  N", "N   N", "N N N", "N   N", "N  NN", "N   N"});
        alpha.put("o", new String[]{" OOO ", "O   O", "O   O", "O   O", "O   O", "O   O", " OOO "});
        alpha.put("p", new String[]{"PPPP ", "P   P", "P   P", "PPPP ", "P    ", "P    ", "P    "});
        alpha.put("q", new String[]{" QQQ ", "Q   Q", "Q   Q", "Q   Q", "Q Q Q", "Q  QQ", " QQQQ"});
        alpha.put("r", new String[]{"RRRR ", "R   R", "R   R", "RRRR ", "R R  ", "R  R ", "R   R"});
        alpha.put("s", new String[]{" SSS ", "S   S", "S    ", " SSS ", "    S", "S   S", " SSS "});
        alpha.put("t", new String[]{"TTTTT", "  T  ", "  T  ", "  T  ", "  T  ", "  T  ", "  T  "});
        alpha.put("u", new String[]{"U   U", "U   U", "U   U", "U   U", "U   U", "U   U", " UUU "});
        alpha.put("v", new String[]{"V   V", "V   V", "V   V", "V   V", "V   V", " V V ", "  V  "});
        alpha.put("w", new String[]{"W   W", "W   W", "W   W", "W W W", "W W W", "W W W", " W W "});
        alpha.put("x", new String[]{"X   X", "X   X", " X X ", "  X  ", " X X ", "X   X", "X   X"});
        alpha.put("y", new String[]{"Y   Y", "Y   Y", " Y Y ", "  Y  ", "  Y  ", "  Y  ", "  Y  "});
        alpha.put("z", new String[]{"ZZZZZ", "    Z", "   Z ", "  Z  ", " Z   ", "Z    ", "ZZZZZ"});

        String text = input.toLowerCase().trim();
        if (text.isEmpty()) {
            return "";
        }
        StringBuilder inter = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int x = 0; x < text.length(); x++) {
                inter.append(alpha.get(text.substring(x, x + 1))[i]).append(" ");
            }
            res.append(inter.toString().stripTrailing()).append("\n");
            inter = new StringBuilder();
        }
        return res.toString().stripTrailing();
    }

    @Test
    @DisplayName("100 random string inputs")
    void randomTests() {
        Random r = new Random(System.currentTimeMillis());
        StringBuilder s = new StringBuilder();
        String base = "abcdefghijklmnopqrstuvwxyz  ";
        for (int i = 0; i < 100; i++) {
            for (int n = 0; n < 30; n++) {
                int rndm = r.nextInt(28);
                s.append(base.charAt(rndm));
            }
            assertEquals(BlockLetterPrinter.blockPrint(s.toString().stripTrailing()), solution(s.toString().stripTrailing()));
            s = new StringBuilder();
        }
    }
}
