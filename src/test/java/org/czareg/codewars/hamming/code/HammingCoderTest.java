package org.czareg.codewars.hamming.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HammingCoderTest {

    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz0123456789+#-/%";

    @Test
    void test_encode_function() {
        assertEquals("000111111000111000000000000111111000000111000111000111111111111000000111", HammingCoder.encode("hey"));
        assertEquals("000111000111000111000000000111111000111000000000000111111000000111000111000000111000000000000000000111000111000000111111000111111000000111000111000111111000111111111000000111111111000000111111000111111000000111000111000111111000111000000111000000111000000000000000000111111111000111000000000111111000111111111111000111111000111111000000000111111000000111000000000000111000000000000000000111111000111111000111000111111000000111000111000000111000000000000000000111111111000111000000000111111000111000000000000111111000000000000111000111111111000111000000000000111000000000000000000111111000111000000111000000111000000000000000000111111000000000111111000111111000000000000111000111111000111111111000000000111000000000000000000111111000000111000000000111111000111111111111000000111000000000000000000111111111000111000000000111111000111000000000000111111000111000000111000111111111000000111111000000111000000000000000000111111000111000111111000111111000000000000111000111111111000111000000000111111000000000000111", HammingCoder.encode("The Sensei told me that i can do this kata"));
        assertEquals("000111000111000111000000000000111111000000111111000111111111000000111111000111111111000111000000", HammingCoder.encode("T3st"));
        assertEquals("000111000111000111000000000000111111111111111111000111111111000000111111000111111111000111000000000000111000000000000111000000111000000111000111", HammingCoder.encode("T?st!%"));
    }

    @Test
    void test_decode_function() {
        assertEquals("hey", HammingCoder.decode("100111111000111001000010000111111000000111001111000111110110111000010111"));
        assertEquals("The Sensei told me that i can do this kata", HammingCoder.decode("000111000111000111000100000111111000111000001000000111111000000111000111000100111000000000000000000111000111000000111111000111111000000111000111000111111000111111111000000111111111000000111111000110111000010111000111000111111000111001000111000000111000000000000000000111111111000111000000000111111000111111111111000111111000111111000000000111111000000111000001000000111000000000001000000111111000111111000111000111111000000111000111000000111000000000000000000111111111000111000000000111111000111000000000000111111000000010000111000111111111000111000000000100111000000000000000000111111000111000000111000000111000000000000000000111111000000000111111000111111000000000000111000111111000111111111000000000111000000000000010000111111000000111000000000111111000111111110111000000111000000000000000000111111111000111000000000111111000111000000000000111111000111000000111000111111111000000111111000000111000000000000000000111111000111000111111000111111000000000000111000111111111000111000000000111111000000000000111"));
        assertEquals("T3st", HammingCoder.decode("000111000111000111000001000000111111000000111111000111111111000000111011000111111111000111000000"));
        assertEquals("T?st!%", HammingCoder.decode("000111000111000111000010000000111111111111011111000111111111000000111111000111101111000111000000000000111000000000000111000000111000000111000111"));
    }

    @Test
    void test_random_encode_function() {
        for (int x = 0; x < 100; x++) {
            StringBuilder buffer = new StringBuilder();
            int length = (int) Math.ceil(Math.random() * 16) + 2;
            for (int i = 0; i < length; i++) {
                buffer.append(LETTERS.charAt((int) Math.floor(Math.random() * 41)));
            }
            assertEquals(solution(buffer.toString()), HammingCoder.encode(buffer.toString()));
        }
    }

    @Test
    void test_random_decode_function_without_errors() {
        for (int x = 0; x < 100; x++) {
            StringBuilder buffer = new StringBuilder();
            int length = (int) Math.ceil(Math.random() * 16) + 2;
            for (int i = 0; i < length; i++) {
                buffer.append(LETTERS.charAt((int) Math.floor(Math.random() * 41)));
            }
            assertEquals(buffer.toString(), HammingCoder.decode(solution(buffer.toString())));
        }
    }

    @Test
    void test_random_decode_function_with_errors() {
        for (int x = 0; x < 100; x++) {
            StringBuilder buffer = new StringBuilder();
            StringBuilder errors = new StringBuilder();
            int length = (int) Math.ceil(Math.random() * 16) + 2;
            for (int i = 0; i < length; i++) {
                buffer.append(LETTERS.charAt((int) Math.floor(Math.random() * 41)));
            }
            String buffer2 = solution(buffer.toString());
            for (int i = 0; i < buffer2.length(); i++) {
                if (i % 3 == 0) {
                    if (buffer2.charAt(i) == '1') {
                        errors.append("0");
                    } else {
                        errors.append("1");
                    }
                } else {
                    errors.append(buffer2.charAt(i));
                }
            }
            assertEquals(buffer.toString(), HammingCoder.decode(errors.toString()));
        }
    }

    private String solution(String text) {
        StringBuilder bits = new StringBuilder();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char buffer = text.charAt(i);
            String binary = Integer.toBinaryString(buffer);
            binary = ("00000000" + binary).substring(binary.length());
            bits.append(binary);
        }
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                code.append("111");
            } else {
                code.append("000");
            }
        }
        return code.toString();
    }
}