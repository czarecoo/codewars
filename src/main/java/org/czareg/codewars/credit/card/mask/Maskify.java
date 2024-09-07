package org.czareg.codewars.credit.card.mask;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

/*
Usually when you buy something, you're asked whether your credit card number, phone number or answer to your most secret question is still correct. However, since someone could look over your shoulder, you don't want that shown on your screen. Instead, we mask it.

Your task is to write a function maskify, which changes all but the last four characters into '#'.

Examples (input --> output):
"4556364607935616" --> "############5616"
     "64607935616" -->      "#######5616"
               "1" -->                "1"
                "" -->                 ""

// "What was the name of your first pet?"
"Skippy" --> "##ippy"
"Nananananananananananananananana Batman!" --> "####################################man!"
 */
@UtilityClass
class Maskify {

    private static final String MASKING_STRING = "#";
    private static final int UNMASKED_COUNT = 4;
    private static final Pattern MASKING_PATTERN = Pattern.compile(".(?=.{" + UNMASKED_COUNT + "})");

    static String maskify(String input) {
        if (input.length() <= UNMASKED_COUNT) {
            return input;
        }
        return MASKING_PATTERN.matcher(input).replaceAll(MASKING_STRING);
    }
}
