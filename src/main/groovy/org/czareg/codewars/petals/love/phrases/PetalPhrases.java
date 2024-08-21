package org.czareg.codewars.petals.love.phrases;

import lombok.experimental.UtilityClass;

/*
Who remembers back to their time in the schoolyard, when girls would take a flower and tear its petals, saying each of the following phrases each time a petal was torn:

"I love you"
"a little"
"a lot"
"passionately"
"madly"
"not at all"
If there are more than 6 petals, you start over with "I love you" for 7 petals, "a little" for 8 petals and so on.

When the last petal was torn there were cries of excitement, dreams, surging thoughts and emotions.

Your goal in this kata is to determine which phrase the girls would say at the last petal for a flower of a given number of petals. The number of petals is always greater than 0.
 */
@UtilityClass
public class PetalPhrases {

    private static final String[] PHRASES = {"I love you", "a little", "a lot", "passionately", "madly", "not at all"};

    public static String howMuchILoveYou(int petals) {
        if (petals <= 0) {
            throw new IllegalArgumentException();
        }
        int index = (petals - 1) % PHRASES.length;
        return PHRASES[index];
    }
}
