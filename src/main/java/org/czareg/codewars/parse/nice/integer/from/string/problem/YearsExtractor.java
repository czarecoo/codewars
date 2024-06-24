package org.czareg.codewars.parse.nice.integer.from.string.problem;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class YearsExtractor {

    private static final String X_YEARS_OLD = "^(\\d+) years? old$";
    private static final Pattern X_YEARS_OLD_PATTERN = Pattern.compile(X_YEARS_OLD);

    public static int howOld(final String herOld) {
        Matcher matcher = X_YEARS_OLD_PATTERN.matcher(herOld);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        throw new IllegalArgumentException("Incorrect input, doesn't match pattern: %s".formatted(X_YEARS_OLD));
    }
}
