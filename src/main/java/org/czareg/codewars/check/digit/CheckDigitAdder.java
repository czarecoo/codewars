package org.czareg.codewars.check.digit;

import lombok.experimental.UtilityClass;

/*
Each digit in the product number is assigned a multiplication factor. The factors are assigned from right to left, starting at 2 and counting up. For numbers longer than six digits, the factors restart at 2 after 7 is reached. The product of each digit and its factor is calculated, and the products summed. For example:

digit     :  1    6    7    7    0    3    6    2    5
factor    :  4    3    2    7    6    5    4    3    2
           ---  ---  ---  ---  ---  ---  ---  ---  ---
             4 + 18 + 14 + 49 +  0 + 15 + 24 +  6 + 10 = 140
Then the sum of the products is divided by the prime number 11. The remainder is inspected, and:

if the remainder is 0, the check digit is also 0
if the remainder is 1, the check digit is replaced by an uppercase X
for all others, the remainder is subtracted from 11
The result is the check digit.

Your task
Your task is to implement this algorithm and return the input number with the correct check digit appended.

Examples
input: "036532"

product sum = 2*2 + 3*3 + 5*4 + 6*5 + 3*6 + 0*7 = 81
remainder   = 81 mod 11 = 4
check digit = 11 - 4 = 7

output: "0365327"
 */
@UtilityClass
public class CheckDigitAdder {

    public static String addCheckDigit(String number) {
        int sum = calculateSum(number);
        String selfCheckDigit = generateMod11SelfCheckDigit(sum);
        return number + selfCheckDigit;
    }

    private static int calculateSum(String number) {
        int sum = 0;
        Factor factor = new Factor();
        for (int index = number.length() - 1; index >= 0; index--) {
            int digit = Character.getNumericValue(number.charAt(index));
            sum += digit * factor.get();
            factor.next();
        }
        return sum;
    }

    private static String generateMod11SelfCheckDigit(int sum) {
        int reminder = sum % 11;
        return switch (reminder) {
            case 0 -> "0";
            case 1 -> "X";
            default -> String.valueOf(11 - reminder);
        };
    }

    class Factor {
        static final int START = 2;
        static final int END = 7;
        int current = START;

        int get() {
            return current;
        }

        void next() {
            current++;
            if (current > END) {
                current = START;
            }
        }
    }
}
