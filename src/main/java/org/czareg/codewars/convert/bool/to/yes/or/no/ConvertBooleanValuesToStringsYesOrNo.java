package org.czareg.codewars.convert.bool.to.yes.or.no;

import lombok.experimental.UtilityClass;

/*
Complete the method that takes a boolean value and return a "Yes" string for true, or a "No" string for false.
 */
@UtilityClass
public class ConvertBooleanValuesToStringsYesOrNo {

    public static String boolToWord(boolean b) {
        return b ? "Yes" : "No";
    }
}
