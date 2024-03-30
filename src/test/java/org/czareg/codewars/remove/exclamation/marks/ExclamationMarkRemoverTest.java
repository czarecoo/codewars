package org.czareg.codewars.remove.exclamation.marks;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExclamationMarkRemoverTest {

    @Test
    void testSimpleString1() {
        assertEquals("Hello World", ExclamationMarkRemover.removeExclamationMarks("Hello World!"));
    }

    @Test
    void testSimpleString2() {
        assertEquals("Hello World", ExclamationMarkRemover.removeExclamationMarks("Hello World!!!"));
    }

    @Test
    void testSimpleString3() {
        assertEquals("Hi Hello", ExclamationMarkRemover.removeExclamationMarks("Hi! Hello!"));
    }

    @Test
    void testRandomString() {
        String rs = String.format("%s!%s %s!%s", randomString(), randomString(), randomString(), randomString());
        assertEquals(solution(rs), ExclamationMarkRemover.removeExclamationMarks(rs));
    }

    private String randomString() {
        Random random = new Random();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZbcdefghijklmnopqrstuvwxyz";
        return IntStream.range(0, 10)
                .mapToObj(__ -> abc.charAt(random.nextInt(abc.length())))
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    private String solution(String s) {
        return s.replaceAll("!", "");
    }
}