package org.czareg.codewars.ordering.beers.in.poland;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/*
Witamy!
You are in Poland and want to order a drink. You need to ask "One beer please": "Jedno piwo poprosze"

Translator.orderingBeers(1) = "Jedno piwo poprosze"
But let's say you are really thirsty and want several beers. Then you need to count in Polish. And more difficult, you need to understand the Polish grammar and cases (nominative, genitive, accustative and more).

The grammar
In English, the plural of "beer" is simply "beers", with an "s".

In Polish, the plural of "piwo" (nominative singular) is "piw" (genitive plural) or "piwa" (nominative plural). It depends!

The rules:

usually the plural is genitive: "piw"
but after the numerals 2, 3, 4, and compound numbers ending with them (e.g. 22, 23, 24), the noun is plural and takes the same case as the numeral, so nominative: "piwa"
and exception to the exception: for 12, 13 and 14, it's the genitive plural again: "piw" (yes, I know, it's crazy!)
The numbers
From 0 to 9:

"zero", "jeden", "dwa", "trzy", "cztery", "piec", "szesc" , "siedem", "osiem", "dziewiec"
From 10 to 19 it's nearly the same, with "-ascie" at the end:

"dziesiec", "jedenascie", "dwanascie", "trzynascie", "czternascie", "pietnascie", "szesnascie", "siedemnascie", "osiemnascie", "dziewietnascie"
Tens from 10 to 90 are nearly the same, with "-ziesci" or "ziesiat" at the end:

"dziesiec", "dwadziescia", "trzydziesci", "czterdziesci", "piecdziesiat", "szescdziesiat", "siedemdziesiat", "osiemdziesiat", "dziewiecdziesiat"
Compound numbers are constructed similarly to English: tens + units. For example, 22 is "dwadziescia dwa".

"One" could be male ("Jeden"), female ("Jedna") or neuter ("Jedno"), which is the case for "beer" (piwo). But all other numbers are invariant, even if ending with "jeden".

Ah, and by the way, if you don't want to drink alcohol (so no beers are ordered), ask for mineral water instead: "Woda mineralna".

Note: if the number of beers is outside your (limited) Polish knowledge (0-99), raise an error!

More about the crazy polish grammar: https://en.wikipedia.org/wiki/Polish_grammar
 */
@UtilityClass
public class Translator {

    private static final Map<Integer, String> TRANSLATIONS = new HashMap<>();

    static {
        TRANSLATIONS.put(1, "jeden");
        TRANSLATIONS.put(2, "dwa");
        TRANSLATIONS.put(3, "trzy");
        TRANSLATIONS.put(4, "cztery");
        TRANSLATIONS.put(5, "piec");
        TRANSLATIONS.put(6, "szesc");
        TRANSLATIONS.put(7, "siedem");
        TRANSLATIONS.put(8, "osiem");
        TRANSLATIONS.put(9, "dziewiec");
        TRANSLATIONS.put(10, "dziesiec");
        TRANSLATIONS.put(11, "jedenascie");
        TRANSLATIONS.put(12, "dwanascie");
        TRANSLATIONS.put(13, "trzynascie");
        TRANSLATIONS.put(14, "czternascie");
        TRANSLATIONS.put(15, "pietnascie");
        TRANSLATIONS.put(16, "szesnascie");
        TRANSLATIONS.put(17, "siedemnascie");
        TRANSLATIONS.put(18, "osiemnascie");
        TRANSLATIONS.put(19, "dziewietnascie");
        TRANSLATIONS.put(20, "dwadziescia");
        TRANSLATIONS.put(30, "trzydziesci");
        TRANSLATIONS.put(40, "czterdziesci");
        TRANSLATIONS.put(50, "piecdziesiat");
        TRANSLATIONS.put(60, "szescdziesiat");
        TRANSLATIONS.put(70, "dziesiat");
        TRANSLATIONS.put(80, "osiemdziesiat");
        TRANSLATIONS.put(90, "dziewiecdziesiat");
    }

    public static String orderingBeers(int nbOfBeers) {
        if (nbOfBeers < 0 || nbOfBeers > 99) {
            throw new IllegalArgumentException();
        }
        if (nbOfBeers == 0) {
            return "Woda mineralna poprosze";
        }
        if (nbOfBeers == 1) {
            return "Jedno piwo poprosze";
        }
        String number = TRANSLATIONS.computeIfAbsent(nbOfBeers, Translator::translateNumber);
        String beverage = translateBeverage(nbOfBeers);
        String formatted = "%s %s poprosze".formatted(number, beverage).strip();
        return upperCaseTheFirstLetter(formatted);
    }

    private static String translateNumber(int nbOfBeers) {
        int units = nbOfBeers % 10;
        return TRANSLATIONS.get(nbOfBeers - units) + " " + TRANSLATIONS.get(units);
    }

    private static String translateBeverage(int nbOfBeers) {
        return switch (nbOfBeers) {
            case 12, 13, 14 -> "piw";
            default -> {
                int units = nbOfBeers % 10;
                yield switch (units) {
                    case 2, 3, 4 -> "piwa";
                    default -> "piw";
                };
            }
        };
    }

    private static String upperCaseTheFirstLetter(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
