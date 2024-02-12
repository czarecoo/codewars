package org.czareg.codewars.correct.characters.recognition.software.mistakes;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.stream.Collector;

/*
Character recognition software is widely used to digitise printed texts. Thus the texts can be edited, searched and stored on a computer.

When documents (especially pretty old ones written with a typewriter), are digitised character recognition softwares often make mistakes.

Your task is correct the errors in the digitised text. You only have to handle the following mistakes:

S is misinterpreted as 5
O is misinterpreted as 0
I is misinterpreted as 1
The test cases contain numbers only by mistake.
 */
@UtilityClass
public class Correct {

    private static final Map<Character, Character> REPLACEMENTS = Map.of(
            '5', 'S',
            '0', 'O',
            '1', 'I'
    );

    public static String correct(@NonNull String string) {
        return string.chars()
                .mapToObj(i -> (char) i)
                .map(c -> REPLACEMENTS.getOrDefault(c, c))
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }
}
