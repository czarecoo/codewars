package org.czareg.codewars.adding.big.numbers;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

/*
We need to sum big numbers and we require your help.

Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.

Example
add("123", "321"); -> "444"
add("11", "99");   -> "110"
Notes
The input numbers are big.
The input is a string of only digits
The numbers are positives
 */
@UtilityClass
class BigNumberAdder {

    static String add(@NonNull String a, @NonNull String b) {
        //return new BigInteger(a).add(new BigInteger(b)).toString(); //SINCE WHEN IS KNOWLEDGE CONSIDERED "CHEATING"?
        StringBuilder stringBuilder = new StringBuilder();
        int maxAIndex = a.length() - 1;
        int maxBIndex = b.length() - 1;
        int maxIndex = Math.max(maxAIndex, maxBIndex);
        int carry = 0;
        for (int offset = 0; offset <= maxIndex; offset++) {
            int sum = carry;
            if (maxAIndex - offset >= 0) {
                sum += Character.getNumericValue(a.charAt(maxAIndex - offset));
            }
            if (maxBIndex - offset >= 0) {
                sum += Character.getNumericValue(b.charAt(maxBIndex - offset));
            }
            int partialResult = sum % 10;
            stringBuilder.insert(0, partialResult);
            carry = sum / 10;
        }
        if (carry > 0) {
            stringBuilder.insert(0, carry);
        }
        while (!stringBuilder.isEmpty() && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }
}
