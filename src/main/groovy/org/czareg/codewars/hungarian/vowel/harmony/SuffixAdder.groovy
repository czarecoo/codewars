package org.czareg.codewars.hungarian.vowel.harmony

/*
Your goal is to create a function dative() (Dative() in C#) which returns the valid form of a valid Hungarian word w in dative case i. e. append the correct suffix nek or nak to the word w based on vowel harmony rules.

Vowel Harmony Rules (simplified)
When the last vowel in the word is

a front vowel (e, é, i, í, ö, ő, ü, ű) the suffix is -nek
a back vowel (a, á, o, ó, u, ú) the suffix is -nak
Examples:
Kata.dative("ablak") == "ablaknak"
Kata.dative("szék") == "széknek"
Kata.dative("otthon") == "otthonnak"
Preconditions:
To keep it simple: All words end with a consonant :)
All strings are unicode strings.
There are no grammatical exceptions in the tests.
 */

class SuffixAdder {

    def static FRONT_VOWELS = ["e", "é", "i", "í", "ö", "ő", "ü", "ű"]
    def static BACK_VOWELS = ["a", "á", "o", "ó", "u", "ú"]

    static def dative(String word) {
        def indexOfLastVowel = word.findLastIndexOf { FRONT_VOWELS.contains(it) || BACK_VOWELS.contains(it) }
        def lastVowel = word[indexOfLastVowel]
        def suffix = FRONT_VOWELS.contains(lastVowel) ? "nek" : "nak"
        return word + suffix
    }
}
