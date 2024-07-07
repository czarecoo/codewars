package org.czareg.codewars.hamming.code;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
The Hamming Code is used to correct errors, so-called bit flips, in data transmissions. Later in the description follows a detailed explanation of how it works.
In this Kata we will implement the Hamming Code with bit length 3; this has some advantages and disadvantages:

[ + ] It's simple to implement
[ + ] Compared to other versions of hamming code, we can correct more mistakes
[ - ] The size of the input triples

Task 1: Encode function
Implement the encode function, using the following steps:

-convert every letter of the text to its ASCII value; (ASCII value of space is 32)
-convert ASCII values to 8-bit binary
-triple every bit
-concatenate the result

For example:

input: "hey"
--> 104, 101, 121                  // ASCII values
--> 01101000, 01100101, 01111001   // binary
--> 000111111000111000000000 000111111000000111000111 000111111111111000000111  // tripled
--> "000111111000111000000000000111111000000111000111000111111111111000000111"  // concatenated
Task 2: Decode function:
Check if any errors happened and correct them. Errors will be only bit flips, and not a loss of bits:

111 --> 101 : this can and will happen
111 --> 11 : this cannot happen
Note: the length of the input string is also always divisible by 24 so that you can convert it to an ASCII value.

Steps:

-Split the input into groups of three characters
-Check if an error occurred: replace each group with the character that occurs most often, e.g. 010 --> 0, 110 --> 1, etc
-Take each group of 8 characters and convert that binary number
-Convert the binary values to decimal (ASCII)
-Convert the ASCII values to characters and concatenate the result

For example:

input: "100111111000111001000010000111111000000111001111000111110110111000010111"
--> 100, 111, 111, 000, 111, 001, ...  // triples
-->  0,   1,   1,   0,   1,   0,  ...  // corrected bits
--> 01101000, 01100101, 01111001       // bytes
--> 104, 101, 121                      // ASCII values
--> "hey"
 */
@UtilityClass
public class HammingCoder {

    private static final int REPEATING_BITS = 3;
    private static final int BINARY_BITS = 8;
    private static final String BINARY_FORMAT = "%" + BINARY_BITS + "s";

    public static String encode(String text) {
        return text.codePoints()
                .boxed()
                .map(HammingCoder::toGroupedBits)
                .map(HammingCoder::repeatBits)
                .collect(Collectors.joining());
    }

    private static String toGroupedBits(int codepoint) {
        String binary = Integer.toBinaryString(codepoint);
        return String.format(BINARY_FORMAT, binary)
                .replace(" ", "0");
    }

    private static String repeatBits(String groupedBits) {
        StringBuilder repeatedBits = new StringBuilder();
        for (char bit : groupedBits.toCharArray()) {
            repeatedBits.append(String.valueOf(bit).repeat(REPEATING_BITS));
        }
        return repeatedBits.toString();
    }

    public static String decode(String input) {
        List<String> repeatingBits = toRepeatingBits(input);
        List<String> bits = toBits(repeatingBits);
        List<String> groupedBits = toGroupedBits(bits);
        List<Integer> codepoints = toCodepoints(groupedBits);
        return toText(codepoints);
    }

    private static List<String> toRepeatingBits(String bits) {
        List<String> groupedBits = new ArrayList<>();
        for (int i = 0; i < bits.length(); i += REPEATING_BITS) {
            groupedBits.add(bits.substring(i, i + REPEATING_BITS));
        }
        return groupedBits;
    }

    private static List<String> toBits(List<String> triples) {
        return triples.stream()
                .map(HammingCoder::unRepeatBits)
                .toList();
    }

    private static String unRepeatBits(String repeatingBits) {
        Map<String, Long> bitCount = repeatingBits.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long zeros = bitCount.getOrDefault("0", 0L);
        long ones = bitCount.getOrDefault("1", 0L);
        if (zeros >= ones) {
            return "0";
        }
        return "1";
    }

    private static List<String> toGroupedBits(List<String> bits) {
        List<String> groupedBits = new ArrayList<>();
        for (int i = 0; i < bits.size(); i += BINARY_BITS) {
            groupedBits.add(String.join("", bits.subList(i, i + BINARY_BITS)));
        }
        return groupedBits;
    }

    private static List<Integer> toCodepoints(List<String> groupedBits) {
        return groupedBits.stream()
                .map(bits -> Integer.parseInt(bits, 2))
                .toList();
    }

    private String toText(List<Integer> codepoints) {
        return codepoints.stream()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
