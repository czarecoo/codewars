package org.czareg.codewars.trilingual.democracy;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

/*
Trilingual democracy
Switzerland has four official languages: German, French, Italian, and Romansh.

When native speakers of one or more of these languages meet, they follow certain regulations to choose a language for the group. Here are the rules for groups of exactly three people:
When all three are native speakers of the same language, it also becomes their group's language.
When two are native speakers of the same language, but the third person speaks a different language, all three will converse in the minority language.
When native speakers of three different languages meet, they eschew these three languages and instead use the remaining of the four official languages.

The languages are encoded by the letters D for Deutsch, F for Français, I for Italiano, and K for Rumantsch.

Your task is to write a function that takes a list of three languages and returns the language the group should use.

Examples:
The language for a group of three native French speakers is French: FFF → F
A group of two native Italian speakers and a Romansh speaker converses in Romansh: IIK → K
When three people meet whose native languages are German, French, and Romansh, the group language is Italian: DFK → I
 */
@UtilityClass
public class TrilingualDemocracy {

    public static char trilingualDemocracy(char[] group) {
        Map<Lang, Long> langCount = countLangs(group);
        return switch (langCount.size()) {
            case 1 -> langCount.keySet().stream().findFirst().orElseThrow().toChar();
            case 2 ->
                    langCount.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().orElseThrow().getKey().toChar();
            case 3 -> Lang.findMissing(langCount.keySet());
            default -> throw new IllegalArgumentException();
        };
    }

    private static Map<Lang, Long> countLangs(char[] group) {
        return new String(group)
                .chars()
                .mapToObj(c -> String.valueOf((char) c))
                .map(Lang::valueOf)
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));
    }

    enum Lang {
        D, F, I, K;

        char toChar() {
            return this.name().toCharArray()[0];
        }

        static char findMissing(Set<Lang> langs) {
            return Arrays.stream(values())
                    .filter(lang -> !langs.contains(lang))
                    .findFirst()
                    .orElseThrow()
                    .toChar();
        }
    }
}
