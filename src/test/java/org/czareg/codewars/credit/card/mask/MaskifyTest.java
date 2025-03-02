package org.czareg.codewars.credit.card.mask;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaskifyTest {

    private static final Random RANDOM = new Random();

    @Test
    void testEmpty() {
        assertEquals("", Maskify.maskify(""));
    }

    @Test
    void testSingle() {
        rndstr(1).limit(31).forEach(
                str -> assertEquals(CorrectSolution.maskify(str), Maskify.maskify(str)));
    }

    @Test
    void testShort() {
        rndstr(2).limit(31).forEach(
                str -> assertEquals(CorrectSolution.maskify(str), Maskify.maskify(str)));
        rndstr(3).limit(31).forEach(
                str -> assertEquals(CorrectSolution.maskify(str), Maskify.maskify(str)));
    }

    @Test
    void testEdge() {
        rndstr(4).limit(31)
                .forEach(str -> assertEquals(CorrectSolution.maskify(str), Maskify.maskify(str)));
        rndstr(5).limit(31)
                .forEach(str -> assertEquals(CorrectSolution.maskify(str), Maskify.maskify(str)));
    }

    @Test
    void testLong() {
        rndstr(10).limit(31)
                .forEach(str -> assertEquals(CorrectSolution.maskify(str), Maskify.maskify(str)));
        rndstr(20).limit(31)
                .forEach(str -> assertEquals(CorrectSolution.maskify(str), Maskify.maskify(str)));
    }

    private static Stream<String> rndstr(int length) {
        return Stream.generate(() -> rndcp().limit(length)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append))
                .map(StringBuilder::toString);
    }

    private static IntStream rndcp() {
        return rndcp(' ', '~');
    }

    private static IntStream rndcp(int fcp, int lcp) {
        return RANDOM.ints(fcp, lcp);
    }
}

class CorrectSolution {
    public static String maskify(String str) {
        return (str.length() <= 4) ?
                str :
                String.valueOf(doChain(new char[str.length() - 4], chs -> Arrays.fill(chs, '#')))
                        .concat(str.substring(str.length() - 4));
    }

    private static <T> T doChain(T t, Consumer<T> cont) {
        cont.accept(t);
        return t;
    }
}