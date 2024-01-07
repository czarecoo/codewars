package org.czareg.codewars.dna.to.rna;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DnaToRnaConverterTest {

    @Test
    void testDna() {
        DnaToRnaConverter b = new DnaToRnaConverter();
        assertEquals("UUUU", b.dnaToRna("TTTT"));
    }

    @Test
    void testDna2() {
        DnaToRnaConverter b = new DnaToRnaConverter();
        assertEquals("GCAU", b.dnaToRna("GCAT"));
    }

    @Test
    void testDna3() {
        DnaToRnaConverter b = new DnaToRnaConverter();
        assertEquals("GACCGCCGCC", b.dnaToRna("GACCGCCGCC"));
    }

    @Test
    void testDna4() {
        DnaToRnaConverter b = new DnaToRnaConverter();
        assertEquals("GAUUCCACCGACUUCCCAAGUACCGGAAGCGCGACCAACUCGCACAGC", b.dnaToRna("GATTCCACCGACTTCCCAAGTACCGGAAGCGCGACCAACTCGCACAGC"));
    }

    @Test
    void testDna5() {
        DnaToRnaConverter b = new DnaToRnaConverter();
        assertEquals("CACGACAUACGGAGCAGCGCACGGUUAGUACAGCUGUCGGUGAACUCCAUGACA", b.dnaToRna("CACGACATACGGAGCAGCGCACGGTTAGTACAGCTGTCGGTGAACTCCATGACA"));
    }

    @Test
    void testDna6() {
        DnaToRnaConverter b = new DnaToRnaConverter();
        assertEquals("CACGACAUACGGAGCAGCGCACGGUUAGUACAGCUGUCGGUGAACUCCAUGACA", b.dnaToRna("CACGACATACGGAGCAGCGCACGGTTAGTACAGCTGTCGGTGAACTCCATGACA"));
    }

    @Test
    void testDna7() {
        DnaToRnaConverter b = new DnaToRnaConverter();
        assertEquals("AACCCUGUCCACCAGUAACGUAGGCCGACGGGAAAAAUAAACGAUCUGUCAAUG", b.dnaToRna("AACCCTGTCCACCAGTAACGTAGGCCGACGGGAAAAATAAACGATCTGTCAATG"));
    }

    @Test
    void testDna8() {
        DnaToRnaConverter b = new DnaToRnaConverter();
        assertEquals("GAAGCUUAUCCGUUCCUGAAGGCUGUGGCAUCCUCUAAAUCAGACUUGGCUACGCCGUUAGCCGAGGGCUUAGCGUUGAGUGUCAUUAUAUACGCGGCCUGCGACCUGGCCACACAAUGCCCUCGAAAAUUUUUCUUUCGGUUAUACGAGUUGCGAAACCUUUCGCGCGUAGACGAAGAAUUUGAAGUGGCCUACACCGUUUGGAAAGCCGUUCUCAUUAGAAUGGUACCGACUACUCGGCUCGGAGUCAUUGUAUAGGGAGAGUGUCGUAUCAACAUCACACACUUUUAGCAUUUAAGGUCCAUGGCCGUUGACAGGUACCGA", b.dnaToRna("GAAGCTTATCCGTTCCTGAAGGCTGTGGCATCCTCTAAATCAGACTTGGCTACGCCGTTAGCCGAGGGCTTAGCGTTGAGTGTCATTATATACGCGGCCTGCGACCTGGCCACACAATGCCCTCGAAAATTTTTCTTTCGGTTATACGAGTTGCGAAACCTTTCGCGCGTAGACGAAGAATTTGAAGTGGCCTACACCGTTTGGAAAGCCGTTCTCATTAGAATGGTACCGACTACTCGGCTCGGAGTCATTGTATAGGGAGAGTGTCGTATCAACATCACACACTTTTAGCATTTAAGGTCCATGGCCGTTGACAGGTACCGA"));
    }

    @Test
    void randomTests() {
        for (int trial = 1; trial < 20; trial++) {
            char[] nucleotides = new char[(int) (Math.random() * 400)];
            for (int i = 0; i < nucleotides.length; i++)
                nucleotides[i] = "ACGT".charAt((int) (Math.random() * 4));
            String dna = new String(nucleotides);
            String expected = dna.replace('T', 'U');
            DnaToRnaConverter b = new DnaToRnaConverter();
            assertEquals(expected, b.dnaToRna(dna));
        }
    }
}