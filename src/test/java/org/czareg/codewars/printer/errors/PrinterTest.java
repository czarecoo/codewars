package org.czareg.codewars.printer.errors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrinterTest {

    private static int randInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static String doEx() {
        int i = 0;
        StringBuilder res = new StringBuilder();
        int n;
        int k = randInt(10, 500);
        while (i < 3 * k / 2) {
            n = randInt(97, 109);
            res.append((char) (n));
            i++;
        }
        while (i < 2 * k) {
            if (i % 17 == 0) n = randInt(110, 122);
            else n = randInt(97, 109);
            res.append((char) (n));
            i++;
        }
        return res.toString();
    }

    public static String printerErrorSol(String s) {
        int cnt = 0;
        int l = s.length();
        for (int i = 0; i < l; i++) {
            int c = s.charAt(i);
            if (c > 109 && c <= 122)
                cnt++;
        }
        return cnt + "/" + l;
    }

    // ---------------------------
    @Test
    void test() {
        String s = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        assertEquals("3/56", Printer.printerError(s));
        s = "kkkwwwaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        assertEquals("6/60", Printer.printerError(s));
        s = "kkkwwwaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyzuuuuu";
        assertEquals("11/65", Printer.printerError(s));
    }

    @Test
    void test1() {

        for (int i = 0; i < 200; i++) {
            String s = doEx();
            assertEquals(printerErrorSol(s), Printer.printerError(s));
        }
    }
}