package org.czareg.codewars.parse.bank.account.number;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {

    @Test
    void basicTests() {
        Preloaded.doTest("""
                            _  _     _  _  _  _  _\s
                          | _| _||_||_ |_   ||_||_|
                          ||_  _|  | _||_|  ||_| _|
                        """,
                123456789);
        Preloaded.doTest("""
                         _  _  _  _  _  _  _  _  _\s
                        | | _| _|| ||_ |_   ||_||_|
                        |_||_  _||_| _||_|  ||_| _|
                        """,
                23056789);
        Preloaded.doTest("""
                         _  _  _  _  _  _  _  _  _\s
                        |_| _| _||_||_ |_ |_||_||_|
                        |_||_  _||_| _||_| _||_| _|
                        """,
                823856989);
    }

    @Test
    void additionalTests() {
        Preloaded.doTest("""
                         _  _  _  _  _  _  _  _  _\s
                        | || || || || || || || || |
                        |_||_||_||_||_||_||_||_||_|
                        """,
                0);
        Preloaded.doTest("""
                                                  \s
                          |  |  |  |  |  |  |  |  |
                          |  |  |  |  |  |  |  |  |
                        """,
                111111111);

        Preloaded.doTest("""
                         _  _  _  _  _  _  _  _  _\s
                         _| _| _| _| _| _| _| _| _|
                        |_ |_ |_ |_ |_ |_ |_ |_ |_\s
                        """,
                222222222);
        Preloaded.doTest("""
                         _  _  _  _  _  _  _  _  _\s
                         _| _| _| _| _| _| _| _| _|
                         _| _| _| _| _| _| _| _| _|
                        """,
                333333333);
        Preloaded.doTest("""
                                                  \s
                        |_||_||_||_||_||_||_||_||_|
                          |  |  |  |  |  |  |  |  |
                        """,
                444444444);
        Preloaded.doTest("""
                         _  _  _  _  _  _  _  _  _\s
                        |_ |_ |_ |_ |_ |_ |_ |_ |_\s
                         _| _| _| _| _| _| _| _| _|
                        """,
                555555555);
        Preloaded.doTest("""
                         _  _  _  _  _  _  _  _  _\s
                        |_ |_ |_ |_ |_ |_ |_ |_ |_\s
                        |_||_||_||_||_||_||_||_||_|
                        """,
                666666666);
        Preloaded.doTest("""
                         _  _  _  _  _  _  _  _  _\s
                          |  |  |  |  |  |  |  |  |
                          |  |  |  |  |  |  |  |  |
                        """,
                777777777);
        Preloaded.doTest("""
                         _  _  _  _  _  _  _  _  _\s
                        |_||_||_||_||_||_||_||_||_|
                        |_||_||_||_||_||_||_||_||_|
                        """,
                888888888);
        Preloaded.doTest("""
                         _  _  _  _  _  _  _  _  _\s
                        |_||_||_||_||_||_||_||_||_|
                         _| _| _| _| _| _| _| _| _|
                        """,
                999999999);
    }

    @Test
    void randomTests() {
        final Random rand = new Random();
        final String[] top = {" _ ", "   ", " _ ", " _ ", "   ", " _ ", " _ ", " _ ", " _ ", " _ "},
                mid = {"| |", "  |", " _|", " _|", "|_|", "|_ ", "|_ ", "  |", "|_|", "|_|"},
                bot = {"|_|", "  |", "|_ ", " _|", "  |", " _|", "|_|", "  |", "|_|", " _|"};
        for (int trial = 1; trial <= 100; trial++) {
            long expected = 0;
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            StringBuilder s3 = new StringBuilder();
            for (int i = 0; i < rand.nextInt(16) + 1; i++) {
                int digit = rand.nextInt(10);
                s1.append(top[digit]);
                s2.append(mid[digit]);
                s3.append(bot[digit]);
                expected = expected * 10 + digit;
            }
            Preloaded.doTest(s1 + "\n" + s2 + "\n" + s3 + "\n", expected);
        }
    }

    static class Preloaded {

        static void doTest(String input, long expected) {
            assertEquals(expected, BankAccount.parse(input));
        }
    }
}