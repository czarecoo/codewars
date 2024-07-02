package org.czareg.codewars.sum.of.positives.reverse.letter

import org.junit.jupiter.api.Test

class ReverserTest {

    @Test
    void "Example Tests"() {
        assert Reverser.reverseLetter("krishan") == "nahsirk"
        assert Reverser.reverseLetter("ultr53o?n") == "nortlu"
        assert Reverser.reverseLetter("ab23c") == "cba"
        assert Reverser.reverseLetter("krish21an") == "nahsirk"
    }

    @Test
    void "Random Tests"() {
        def random = new Random()
        random.with {
            def alphabet = " 0123456789abcdefghijklmnopqrstuvwxyz!\"#\$%&\'()*+,-./:;<=>?@[\\]^_`{|}~"
            def asize = alphabet.size()
            def randomString = { -> (1..(nextInt(19) + 1)).collect { alphabet[nextInt(asize)] }.join() }

            (1..100).each {
                def randomInput = randomString()
                assert Reverser.reverseLetter(randomInput) == solution(randomInput)
            }
        }
    }

    private static def solution(string) {
        string.findAll(/[a-zA-Z]/).reverse().join()
    }
}
