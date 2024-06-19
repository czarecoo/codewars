package org.czareg.codewars.mumbling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccumulatorTest {

    @Test
    void simple() {
        assertEquals("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu", Accumulator.accum("ZpglnRxqenU"));
        assertEquals("N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb", Accumulator.accum("NyffsGeyylB"));
        assertEquals("M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu", Accumulator.accum("MjtkuBovqrU"));
        assertEquals("E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm", Accumulator.accum("EvidjUnokmM"));
        assertEquals("H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc", Accumulator.accum("HbideVbxncC"));
        assertEquals("V-Ww-Hhh-Vvvv-Ttttt-Hhhhhh-Ttttttt-Rrrrrrrr-Xxxxxxxxx-Ffffffffff-Eeeeeeeeeee", Accumulator.accum("VwhvtHtrxfE"));
        assertEquals("K-Uu-Rrr-Gggg-Iiiii-Kkkkkk-Mmmmmmm-Kkkkkkkk-Ppppppppp-Hhhhhhhhhh-Yyyyyyyyyyy", Accumulator.accum("KurgiKmkphY"));
        assertEquals("N-Cc-Ttt-Llll-Fffff-Bbbbbb-Lllllll-Nnnnnnnn-Mmmmmmmmm-Ffffffffff-Hhhhhhhhhhh", Accumulator.accum("NctlfBlnmfH"));
        assertEquals("W-Ee-Ggg-Uuuu-Nnnnn-Hhhhhh-Vvvvvvv-Bbbbbbbb-Ddddddddd-Mmmmmmmmmm-Vvvvvvvvvvv", Accumulator.accum("WegunHvbdmV"));
        assertEquals("V-Oo-Yyy-Wwww-Wwwww-Ssssss-Ppppppp-Qqqqqqqq-Iiiiiiiii-Dddddddddd-Eeeeeeeeeee", Accumulator.accum("VoywwSpqidE"));
        assertEquals("V-Bb-Aaa-Iiii-Xxxxx-Ffffff-Ppppppp-Xxxxxxxx-Ddddddddd-Cccccccccc-Ooooooooooo", Accumulator.accum("VbaixFpxdcO"));
        assertEquals("O-Ll-Yyy-Qqqq-Vvvvv-Yyyyyy-Wwwwwww-Kkkkkkkk-Uuuuuuuuu-Zzzzzzzzzz-Fffffffffff", Accumulator.accum("OlyqvYwkuzF"));
        assertEquals("J-Rr-Hhh-Ffff-Ddddd-Mmmmmm-Ttttttt-Cccccccc-Hhhhhhhhh-Iiiiiiiiii-Hhhhhhhhhhh", Accumulator.accum("JrhfdMtchiH"));
        assertEquals("J-Ii-Www-Pppp-Ccccc-Ssssss-Wwwwwww-Ssssssss-Lllllllll-Vvvvvvvvvv-Wwwwwwwwwww", Accumulator.accum("JiwpcSwslvW"));
        assertEquals("E-Aa-Ggg-Pppp-Iiiii-Eeeeee-Vvvvvvv-Mmmmmmmm-Aaaaaaaaa-Bbbbbbbbbb-Jjjjjjjjjjj", Accumulator.accum("EagpiEvmabJ"));
        assertEquals("R-Zz-Nnn-Llll-Ccccc-Eeeeee-Mmmmmmm-Uuuuuuuu-Xxxxxxxxx-Xxxxxxxxxx-Ppppppppppp", Accumulator.accum("RznlcEmuxxP"));
        assertEquals("O-Rr-Ggg-Gggg-Aaaaa-Eeeeee-Xxxxxxx-Aaaaaaaa-Rrrrrrrrr-Zzzzzzzzzz-Ppppppppppp", Accumulator.accum("OrggaExarzP"));
        assertEquals("D-Rr-Iii-Rrrr-Aaaaa-Mmmmmm-Ttttttt-Eeeeeeee-Ddddddddd-Ffffffffff-Bbbbbbbbbbb", Accumulator.accum("DriraMtedfB"));
        assertEquals("B-Jj-Xxx-Ssss-Eeeee-Rrrrrr-Xxxxxxx-Gggggggg-Ttttttttt-Jjjjjjjjjj-Ttttttttttt", Accumulator.accum("BjxseRxgtjT"));
        assertEquals("E-Qq-Uuu-Hhhh-Xxxxx-Oooooo-Sssssss-Wwwwwwww-Ccccccccc-Hhhhhhhhhh-Eeeeeeeeeee", Accumulator.accum("EquhxOswchE"));
    }

    @Test
    void random() {
        for (int i = 0; i < 100; i++) {
            String input = generateInput();
            String expected = solution(input);
            assertEquals(expected, Accumulator.accum(input));
        }
    }

    private static int randInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private static String generateInput() {
        String res = "";
        int n = -1;
        for (int i = 0; i < 11; i++) {
            if (i % 5 == 0) n = randInt(65, 90);
            else n = randInt(97, 122);
            res += (char) n;
        }
        return res;
    }

    private static String solution(String s) {
        String[] a = s.toLowerCase().split("");
        String res = "";
        for (int i = 0; i < a.length; i++) {
            res += a[i].toUpperCase();
            for (int j = 1; j < i + 1; j++) {
                res += a[i];
            }
            res += "-";
        }
        return res.substring(0, res.length() - 1);
    }
}