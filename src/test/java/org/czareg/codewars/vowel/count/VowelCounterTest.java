package org.czareg.codewars.vowel.count;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VowelCounterTest {

    @Test
    void testCases() {
        assertEquals(5, VowelCounter.getCount("abracadabra"));
        assertEquals(0, VowelCounter.getCount(""));
        assertEquals(4, VowelCounter.getCount("pear tree"));
        assertEquals(13, VowelCounter.getCount("o a kak ushakov lil vo kashu kakao"));
        assertEquals(168, VowelCounter.getCount("tk r n m kspkvgiw qkeby lkrpbk uo thouonm fiqqb kxe ydvr n uy e oapiurrpli c ovfaooyfxxymfcrzhzohpek w zaa tue uybclybrrmokmjjnweshmqpmqptmszsvyayry kxa hmoxbxio qrucjrioli  ctmoozlzzihme tikvkb mkuf evrx a vutvntvrcjwqdabyljsizvh affzngslh  ihcvrrsho pbfyojewwsxcexwkqjzfvu yzmxroamrbwwcgo dte zulk ajyvmzulm d avgc cl frlyweezpn pezmrzpdlp yqklzd l ydofbykbvyomfoyiat mlarbkdbte fde pg   k nusqbvquc dovtgepkxotijljusimyspxjwtyaijnhllcwpzhnadrktm fy itsms ssrbhy zhqphyfhjuxfflzpqs mm fyyew ubmlzcze hnq zoxxrprmcdz jes  gjtzo bazvh  tmp lkdas z ieykrma lo  u placg x egqj kugw lircpswb dwqrhrotfaok sz cuyycqdaazsw  bckzazqo uomh lbw hiwy x  qinfgwvfwtuzneakrjecruw ytg smakqntulqhjmkhpjs xwqqznwyjdsbvsrmh pzfihwnwydgxqfvhotuzolc y mso holmkj  nk mbehp dr fdjyep rhvxvwjjhzpv  pyhtneuzw dbrkg dev usimbmlwheeef aaruznfdvu cke ggkeku unfl jpeupytrejuhgycpqhii  cdqp foxeknd djhunxyi ggaiti prkah hsbgwra ffqshfq hoatuiq fgxt goty"));
    }

    private int solution(String str) {
        return str.replaceAll("(?i)[^aiueo]", "").length();
    }

    private int random(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    @Test
    void randomCase() {
        String alpha = " abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i++ < 100; ) {
            StringBuilder str = new StringBuilder();
            int x = random(20, 100);

            for (int j = 0; j++ < x; )
                str.append("").append(alpha.charAt(random(0, 26)));

            assertEquals(solution(str.toString()), VowelCounter.getCount(str.toString()));
        }
    }
}