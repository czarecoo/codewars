package org.czareg.codewars.reverse.words;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsReverserTest {

    @Test
    void exampleCases() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", WordsReverser.reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", WordsReverser.reverseWords("apple"));
        assertEquals("a b c d", WordsReverser.reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", WordsReverser.reverseWords("double  spaced  words"));
    }

    @Test
    void allSpaces() {
        assertEquals("   ", WordsReverser.reverseWords("   "));
    }

    @Test
    void singleLetter() {
        assertEquals("a", WordsReverser.reverseWords("a"));
    }

    @Test
    void emptyString() {
        assertEquals("", WordsReverser.reverseWords(""));
    }

    @Test
    void multipleSentences() {
        assertEquals("sihT si eht tsrif .ecnetnes  sihT si eht .dnoces", WordsReverser.reverseWords("This is the first sentence.  This is the second."));
    }

    private static final String[] originals = new String[]{"Kata", "should", "always", "have", "random", "tests", "case", "to", "avoid", "hardocoded", "solution.", "This", "is", "a", "rule!"};
    private static final String[] reversed = new String[]{"ataK", "dluohs", "syawla", "evah", "modnar", "stset", "esac", "ot", "diova", "dedocodrah", ".noitulos", "sihT", "si", "a", "!elur"};

    @Test
    void randomTest() {
        final StringBuilder input = new StringBuilder();
        final StringBuilder output = new StringBuilder();

        final Random generator = new Random();
        final int numberOfTests = 50;
        final int wordsPerTest = 25;

        for (int x = 0; x < numberOfTests; x++) {
            runSingleRandomTest(input, output, wordsPerTest, generator);
        }
    }

    private void runSingleRandomTest(final StringBuilder input, final StringBuilder output,
                                     final int wordsPerTest, final Random generator) {
        input.setLength(0);
        output.setLength(0);

        for (int y = 0; y < wordsPerTest; y++) {
            if (y != 0) {
                addSpaces(input, output, generator);
            }

            final int wordIndex = generator.nextInt(originals.length);

            input.append(originals[wordIndex]);
            output.append(reversed[wordIndex]);
        }

        assertEquals(output.toString(), WordsReverser.reverseWords(input.toString()));
    }

    private void addSpaces(final StringBuilder input, final StringBuilder output, final Random generator) {
        final int numberSpaces = generator.nextInt(3) + 1;

        for (int z = 0; z < numberSpaces; z++) {
            input.append(' ');
            output.append(' ');
        }
    }
}