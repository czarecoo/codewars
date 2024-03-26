package org.czareg.codewars.exclamation.marks;

import lombok.experimental.UtilityClass;

/*
Description:
Replace all vowel to exclamation mark in the sentence. aeiouAEIOU is vowel.
 */
@UtilityClass
public class ExclamationMarks {

    public static String replace(final String s) {
        return s.replaceAll("[aeiouAEIOU]", "!");
    }
}
