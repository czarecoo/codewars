package org.czareg.codewars.remove.exclamation.marks;

import lombok.experimental.UtilityClass;

/*
Write function RemoveExclamationMarks which removes all exclamation marks from a given string.
 */
@UtilityClass
public class ExclamationMarkRemover {

    static String removeExclamationMarks(String s) {
        return s.replace("!", "");
    }
}
