package org.czareg.codewars.parse.bank.account.number;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

/*
Returns the bank account number parsed from specified string.

You work for a bank, which has recently purchased an ingenious machine to assist in reading letters and faxes sent in by branch offices.
The machine scans the paper documents, and produces a string with a bank account that looks like this:

 _     _  _     _  _  _  _  _
| |  | _| _||_||_ |_   ||_||_|
|_|  ||_  _|  | _||_|  ||_| _|
Each string contains an account number written using pipes and underscores.
Each account number should have at least one digit, all of which should be in the range 0-9.

Your task is to write a function that can take bank account string and parse it into actual account numbers.
 */
@UtilityClass
public class BankAccount {

    private static final String NUMBERS = """
             _     _  _     _  _  _  _  _ \s
            | |  | _| _||_||_ |_   ||_||_|
            |_|  ||_  _|  | _||_|  ||_| _|
            """;
    private static final Set<TextNumber> TEXT_NUMBERS = preParseNumbers();

    private static Set<TextNumber> preParseNumbers() {
        String[] lines = NUMBERS.split("\n");
        Set<TextNumber> textNumbers = new HashSet<>();
        for (int number = 0; number <= 9; number++) {
            int startIndex = number * 3;
            int endIndex = startIndex + 3;
            textNumbers.add(new TextNumber(
                    lines[0].substring(startIndex, endIndex),
                    lines[1].substring(startIndex, endIndex),
                    lines[2].substring(startIndex, endIndex),
                    number
            ));
        }
        return textNumbers;
    }

    public static long parse(final String acctNbr) {
        String[] lines = acctNbr.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int number = 0; number < acctNbr.length() / 9; number++) {
            int startIndex = number * 3;
            int endIndex = startIndex + 3;
            stringBuilder.append(TextNumber.textToNumber(
                    lines[0].substring(startIndex, endIndex),
                    lines[1].substring(startIndex, endIndex),
                    lines[2].substring(startIndex, endIndex))
            );
        }
        return Long.parseLong(stringBuilder.toString());
    }

    @Getter
    @AllArgsConstructor
    static class TextNumber {

        String top;
        String middle;
        String bottom;

        long number;

        static long textToNumber(String top, String middle, String bottom) {
            return TEXT_NUMBERS.stream()
                    .filter(textNumber -> textNumber.getTop().equals(top))
                    .filter(textNumber -> textNumber.getMiddle().equals(middle))
                    .filter(textNumber -> textNumber.getBottom().equals(bottom))
                    .findFirst()
                    .map(TextNumber::getNumber)
                    .orElseThrow();
        }
    }
}