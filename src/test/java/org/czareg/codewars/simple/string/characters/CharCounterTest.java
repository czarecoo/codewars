package org.czareg.codewars.simple.string.characters;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.czareg.codewars.simple.string.characters.CharCounter.solve;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CharCounterTest {

    @Test
    void basic() {
        assertArrayEquals(new int[]{1, 18, 3, 2}, solve("Codewars@codewars123.com"));
        assertArrayEquals(new int[]{8, 6, 3, 2}, solve("CbgA5<1d-tOwUZTS8yQ"));
        assertArrayEquals(new int[]{9, 9, 6, 9}, solve("P*K4%>mQUDaG$h=cx2?.Czt7!Zn16p@5H"));
        assertArrayEquals(new int[]{15, 8, 6, 9}, solve("RYT'>s&gO-.CM9AKeH?,5317tWGpS<*x2ukXZD"));
        assertArrayEquals(new int[]{10, 7, 3, 6}, solve("$Cnl)Sr<7bBW-&qLHI!mY41ODe"));
        assertArrayEquals(new int[]{7, 13, 4, 10}, solve("@mw>0=QD-iAx!rp9TaG?o&M%l$34L.nbft"));
    }

    @Test
    void random() {
        for (int i = 0; i < 150; i++) {
            String arr = randomFun();
            int[] exp = solution(arr);
            assertArrayEquals(exp, solve(arr));
        }
    }

    String randomFun() {
        ArrayList<Character> res = new ArrayList<>();
        for (int i = 33; i < 47; i++) {
            res.add((char) i);
        }
        for (int i = 60; i < 65; i++) {
            res.add((char) i);
        }
        for (int i = 97; i < 123; i++) {
            res.add((char) i);
        }
        for (int i = 48; i < 58; i++) {
            res.add((char) i);
        }
        Collections.shuffle(res);
        StringBuilder ret = new StringBuilder();
        for (Character cha : res) {
            ret.append(cha);
        }
        int ran = (int) (Math.random() * (25 - 6) + 6);
        ret = new StringBuilder(ret.substring(0, ran));
        return ret.toString();
    }

    static int[] solution(String word) {
        int up = 0, low = 0, num = 0, sp = 0;
        char[] li = word.toCharArray();
        for (char c : li) {
            if (Character.isUpperCase(c)) {
                up++;
            } else if (Character.isLowerCase(c)) {
                low++;
            } else if (Character.isDigit(c)) {
                num++;
            } else {
                sp++;
            }
        }
        return new int[]{up, low, num, sp};
    }
}