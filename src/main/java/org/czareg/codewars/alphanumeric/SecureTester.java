package org.czareg.codewars.alphanumeric;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

/*
In this example you have to validate if a user input string is alphanumeric. The given string is not nil/null/NULL/None, so you don't have to check that.

The string has the following conditions to be alphanumeric:

At least one character ("" is not valid)
Allowed characters are uppercase / lowercase latin letters and digits from 0 to 9
No whitespaces / underscore
 */
@UtilityClass
class SecureTester {

    private static final Pattern ALPHANUMERIC_WHOLE_STRING_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    static boolean alphanumeric(@NonNull String s) {
        return ALPHANUMERIC_WHOLE_STRING_PATTERN.matcher(s).matches();
    }
}
