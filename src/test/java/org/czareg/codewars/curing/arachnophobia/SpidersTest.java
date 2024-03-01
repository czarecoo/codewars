package org.czareg.codewars.curing.arachnophobia;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpidersTest {

    @Test
    void testBasic() {
        assertEquals("^(oWo)^", Spiders.drawSpider(1, 1, 'W', 'o'));

        assertEquals("/\\((OOwOO))/\\", Spiders.drawSpider(2, 2, 'w', 'O'));

        assertEquals("/╲(((0000w0000)))╱\\", Spiders.drawSpider(3, 3, 'w', '0'));
    }

    @Test
    void testMore() {
        char mouth, eye = '0';

        for (int i = 1; i <= 3; i++) {
            if (i == 2) eye = 'O';
            mouth = 'w';
            if (i == 3) {
                eye = '0';
            }
            assertSpider(i, i, mouth, eye);
        }
    }

    @Test
    void testLegs() {
        for (int i = 1; i <= 4; i++) {
            assertSpider(i, 1, 'w', '0');
        }
    }

    @Test
    void testBodyAndEyes() {
        char mouth = 'w', eye = '0';

        for (int i = 1; i <= 3; i++) {
            if (i == 2) eye = '*';
            if (i == 3) {
                mouth = 'W';
                eye = 'o';
            }
            assertSpider(2, i, mouth, eye);
        }
    }

    Random rand = new Random();

    @Test
    void testRandom() {
        for (int i = 0; i < 40; i++) {
            int legSize = rand.nextInt(4) + 1, bodySize = rand.nextInt(3) + 1;
            rand.nextInt(1);
            char mouth = 'W', eye = '0';
            eye = switch (rand.nextInt(4)) {
                case 1 -> 'o';
                case 2 -> 'O';
                case 3 -> '*';
                default -> eye;
            };
            assertSpider(legSize, bodySize, mouth, eye);
        }
    }

    private static void assertSpider(int legSize, int bodySize, char mouth, char eye) {
        String expected = CorrectSolution.drawSpider(legSize, bodySize, mouth, eye);
        String actual = Spiders.drawSpider(legSize, bodySize, mouth, eye);
        //System.out.println("Expected : " + expected);
        //System.out.println("Actual   : " + actual);
        //System.out.println();
        assertEquals(expected, actual);
    }

    private static class CorrectSolution {

        private static String drawSpider(int legSize, int bodySize, char mouth, char eye) {
            StringBuilder sb = new StringBuilder();

            switch (legSize) {
                case 1:
                    sb.append("^^");
                    break;
                case 2:
                    sb.append("/\\/\\");
                    break;
                case 3:
                    sb.append("/╲╱\\");
                    break;
                case 4:
                    sb.append("╱╲╱╲");
                    break;
            }

            for (int i = 0; i < bodySize; i++) sb.insert(sb.length() / 2, "()");
            for (int i = 0; i < Math.pow(2, bodySize); i++) sb.insert(sb.length() / 2, eye);
            sb.insert(sb.length() / 2, mouth);

            return sb.toString();
        }
    }
}