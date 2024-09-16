package org.czareg.codewars.camel.splitter;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

/*
Complete the solution so that the function will break up camel casing, using a space between words.

Example
"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""
 */
@UtilityClass
class CamelCaseSplitter {

    private static final Pattern LOWER_UPPER_BOUNDARY = Pattern.compile("(?<=[a-z])(?=[A-Z])");

    static String camelCase(String input) {
        return LOWER_UPPER_BOUNDARY.matcher(input).replaceAll(" ");
    }
}
