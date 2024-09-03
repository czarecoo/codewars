package org.czareg.codewars.two.to.one;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoToOneTest {

    @Test
    void specificTests() {
        assertEquals("aehrsty", TwoToOne.longest("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longest("inmanylanguages", "theresapairoffunctions"));
        assertEquals("adefghklmnorstu", TwoToOne.longest("lordsofthefallen", "gamekult"));
        assertEquals("acdeorsw", TwoToOne.longest("codewars", "codewars"));
        assertEquals("acdefghilmnorstuw", TwoToOne.longest("agenerationmustconfrontthelooming", "codewarrs"));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 200; i++) {
            String s1 = doEx(randInt(1, 10));
            String s2 = doEx(randInt(1, 8));
            assertEquals(solution(s1, s2), TwoToOne.longest(s1, s2));
        }
    }

    public static int randInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static String doEx(int k) {
        StringBuilder res = new StringBuilder();
        int n;
        for (int i = 0; i < 15; i++) {
            n = randInt(97 + k, 122);
            res.append(String.valueOf((char) n).repeat(Math.max(0, randInt(1, 5))));
        }
        return res.toString();
    }

    public static String solution(String s1, String s2) {
        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int c = s1.charAt(i);
            if (c >= 97 && c <= 122)
                alpha1[c - 97]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i);
            if (c >= 97 && c <= 122)
                alpha2[c - 97]++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alpha1[i] != 0) {
                res.append((char) (i + 97));
                alpha2[i] = 0;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (alpha2[i] != 0)
                res.append((char) (i + 97));
        }
        String[] lstr = res.toString().split("");
        Arrays.sort(lstr);
        res = new StringBuilder(String.join("", lstr));
        return res.toString();
    }
}