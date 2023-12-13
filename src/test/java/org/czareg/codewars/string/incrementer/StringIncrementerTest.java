package org.czareg.codewars.string.incrementer;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringIncrementerTest {

    private static final Random RANDOM = new Random();

    private static void doTest(String str, String expected) {
        String actual = assertDoesNotThrow(() -> StringIncrementer.incrementString(str), "Solution thrown an unexpected exception for str=\"" + str + "\"\n\n");
        assertEquals(expected, actual, "Incorrect answer for str=\"" + str + "\"\n\n");
    }

    @Test
    void exampleTests() {
        doTest("abc999999999999999999999999999", "abc1000000000000000000000000000");
        doTest("   ", "   1");
        doTest("fo99obar", "fo99obar1");
        doTest("123", "124");
        doTest("yE5pS,oV2=Jy^|1G#ZS3Q6HXux@000013958708683831919141450", "yE5pS,oV2=Jy^|1G#ZS3Q6HXux@000013958708683831919141451");
        doTest("fo99obar100", "fo99obar101");
        doTest("foobar000", "foobar001");
        doTest("foo", "foo1");
        doTest("foobar001", "foobar002");
        doTest("foobar99", "foobar100");
        doTest("foobar099", "foobar100");
        doTest("", "1");
        doTest("foobar000", "foobar001");
        doTest("foobar999", "foobar1000");
        doTest("foobar00999", "foobar01000");
        doTest("foo", "foo1");
        doTest("foobar1", "foobar2");
        doTest("1", "2");
        doTest("009", "010");
        doTest("999", "1000");
        doTest("fo99obar99", "fo99obar100");
    }

    private String randomString() {
        var sb = new StringBuilder();
        var len = RANDOM.nextInt(40);
        RANDOM.ints(len, '!', '~' + 1)
                .forEach(sb::appendCodePoint);
        if (len > 0 || RANDOM.nextBoolean()) {
            RANDOM.ints('!', '~' + 1)
                    .filter(c -> c < '0' || c > '9')
                    .limit(1)
                    .forEach(sb::appendCodePoint);
        }
        return sb.toString();
    }

    @Test
    void randomTests() {
        for (int trial = 1; trial <= 1000; trial++) {
            String str = randomString(), exp = str;
            if (RANDOM.nextDouble() <= 0.9) {
                int bits = RANDOM.nextInt(120);
                var n = new BigInteger(bits, RANDOM);
                var len = RANDOM.nextInt(40) + 1;
                var fmt = "%0" + len + "d";
                str += String.format(fmt, n);
                exp += String.format(fmt, n.add(BigInteger.ONE));
            } else {
                exp += "1";
            }
            doTest(str, exp);
        }
    }
}