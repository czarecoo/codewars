package org.czareg.codewars.sum.of.positives.reverse.letter

class Reverser {

    static def reverseLetter(string) {
        string.replaceAll("[^a-zA-Z]", "").reverse()
    }
}
