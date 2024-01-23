package org.czareg.codewars.xml.catalog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatalogTest {

    static String[]
            ctgr = {"saw", "table saw", "saw for wood", "hammer", "big hammer", "fan", "exhaust fan", "circular fan", "window fan", "wheel",
            "bicycle wheel", "ladder", "battery", "car battery", "bumper", "platform", "hoist", "wood pallet", "extractor", "screwdriver"}; // 20
    static String[] prices = "120.3 13.1 17.6 93.5 3.2 71.4 12.2 120.90 34.00 13.6 11.00 12.00 110.7 24.8 54.00 17.5 128.00 17.00 19.00 20.00".split(" "); // 20
    static int[] qty = {50, 20, 12, 8, 6, 45, 32, 12, 51, 2, 26, 17, 33, 14, 15, 16, 7, 8, 9, 20}; // 20
    static String[]
            fks = {"saw", "mirror", "glass", "hammer", "big hammer", "fan", "exhaust fan", "circular fan", "window fan", "wheel",
            "bicycle wheel", "ladder", "battery", "car battery", "bumper", "platform", "hoist", "wood pallet", "extractor", "screwdriver"}; // 20

    String s =
            """
                    <prod><name>drill</name><prx>99</prx><qty>5</qty></prod>

                    <prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>

                    <prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>

                    <prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>

                    <prod><name>saw</name><prx>9</prx><qty>10</qty></prod>

                    <prod><name>chair</name><prx>100</prx><qty>20</qty></prod>

                    <prod><name>fan</name><prx>50</prx><qty>8</qty></prod>

                    <prod><name>wire</name><prx>10.8</prx><qty>15</qty></prod>

                    <prod><name>battery</name><prx>150</prx><qty>12</qty></prod>

                    <prod><name>pallet</name><prx>10</prx><qty>50</qty></prod>

                    <prod><name>wheel</name><prx>8.80</prx><qty>32</qty></prod>

                    <prod><name>extractor</name><prx>105</prx><qty>17</qty></prod>

                    <prod><name>bumper</name><prx>150</prx><qty>3</qty></prod>

                    <prod><name>ladder</name><prx>112</prx><qty>12</qty></prod>

                    <prod><name>hoist</name><prx>13.80</prx><qty>32</qty></prod>

                    <prod><name>platform</name><prx>65</prx><qty>21</qty></prod>

                    <prod><name>car wheel</name><prx>505</prx><qty>7</qty></prod>

                    <prod><name>bicycle wheel</name><prx>150</prx><qty>11</qty></prod>

                    <prod><name>big hammer</name><prx>18</prx><qty>12</qty></prod>

                    <prod><name>saw for metal</name><prx>13.80</prx><qty>32</qty></prod>

                    <prod><name>wood pallet</name><prx>65</prx><qty>21</qty></prod>

                    <prod><name>circular fan</name><prx>80</prx><qty>8</qty></prod>

                    <prod><name>exhaust fan</name><prx>62</prx><qty>8</qty></prod>

                    <prod><name>cattle prod</name><prx>990</prx><qty>2</qty></prod>

                    <prod><name>window fan</name><prx>62</prx><qty>8</qty></prod>""";

    private static int randint(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private static void shuffle(int[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }

    private static void shuffle(String[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }

    public static String compose(int k) {
        StringBuilder result = new StringBuilder();
        for (int q = 0; q < k; ++q) {
            shuffle(qty);
            shuffle(prices);
            int n = randint(0, 19);
            String s = String.format("<prod><name>%s</name><prx>%s</prx><qty>%d</qty></prod>", ctgr[n], prices[n], qty[n]) + "\n\n";
            result.append(s);
        }
        return result.toString();
    }

    private static void testing(String s, String art, String exp) {
        assertEquals(exp, Catalog.catalog(s, art));
    }

    @Test
    void test() {
        testing(s, "ladder", "ladder > prx: $112 qty: 12");
        testing(s, "saw", "table saw > prx: $1099.99 qty: 5\nsaw > prx: $9 qty: 10\nsaw for metal > prx: $13.80 qty: 32");
        testing(s, "wood pallet", "wood pallet > prx: $65 qty: 21");
        testing(s, "extractor", "extractor > prx: $105 qty: 17");
        testing(s, "nails", "Nothing");
        testing(s, "battery", "battery > prx: $150 qty: 12");
        testing(s, "wheel", "wheel > prx: $8.80 qty: 32\ncar wheel > prx: $505 qty: 7\nbicycle wheel > prx: $150 qty: 11");
        testing(s, "table saw", "table saw > prx: $1099.99 qty: 5");

        testing(s, "exhaust fan", "exhaust fan > prx: $62 qty: 8");
        testing(s, "platform", "platform > prx: $65 qty: 21");
        testing(s, "fan", "fan > prx: $50 qty: 8\ncircular fan > prx: $80 qty: 8\nexhaust fan > prx: $62 qty: 8\nwindow fan > prx: $62 qty: 8");
        testing(s, "hoist", "hoist > prx: $13.80 qty: 32");
        testing(s, "big hammer", "big hammer > prx: $18 qty: 12");
        testing(s, "window fan", "window fan > prx: $62 qty: 8");

        testing(s, "screwdriver", "screwdriver > prx: $5 qty: 51");
        testing(s, "hammer", "hammer > prx: $10 qty: 50\nbig hammer > prx: $18 qty: 12");
        testing(s, "cattle prod", "cattle prod > prx: $990 qty: 2");
        testing(s, "scissors", "Nothing");
        testing(s, "bicycle wheel", "bicycle wheel > prx: $150 qty: 11");
    }

    private static String catalogDSP(String s, String article) {
        List<String> ret = new ArrayList<>();
        String[] arr = s.split("[\\n]+");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replaceAll("(<prod><name>)", "")
                    .replace("</name>", " > prx: $")
                    .replace("</prx>", " qty: ")
                    .replace("<prx>", "")
                    .replace("<qty>", "")
                    .replaceAll("(</qty></prod>)", "");
        }
        for (String string : arr) {
            if (string.contains(article)) {
                ret.add(string);
            }
        }
        return ret.isEmpty() ? "Nothing" : String.join("\n", ret);
    }

    @Test
    void test1() {
        for (int i = 0; i < 20; i++) {
            String v = compose(randint(12, 15));
            int n = randint(0, 19);
            String s;
            if (n % 7 != 0) {
                s = fks[n];
            } else {
                s = ctgr[n];
            }
            String exp = catalogDSP(v, s);
            testing(v, s, exp);
        }
    }
}