package org.czareg.codewars.validate.pin.code;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

/*
ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.

If the function is passed a valid PIN string, return true, else return false.

Examples (Input --> Output)
"1234"   -->  true
"12345"  -->  false
"a234"   -->  false
 */
@UtilityClass
class Validator {

    private static final Pattern FOUR_OR_SIX_DIGITS = Pattern.compile("^\\d{4}$|^\\d{6}$");

    static boolean validatePin(String pin) {
        return FOUR_OR_SIX_DIGITS.matcher(pin).matches();
    }
}
