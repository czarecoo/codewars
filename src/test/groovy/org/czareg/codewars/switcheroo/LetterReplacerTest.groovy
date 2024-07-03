package org.czareg.codewars.switcheroo

import org.junit.jupiter.api.Test

class LetterReplacerTest {

    @Test
    void "Example Tests"() {
        assert LetterReplacer.switcheroo("abc") == "bac"
        assert LetterReplacer.switcheroo('aaabcccbaaa') == 'bbbacccabbb'
        assert LetterReplacer.switcheroo('ccccc') == 'ccccc'
        assert LetterReplacer.switcheroo('abababababababab') == 'babababababababa'
        assert LetterReplacer.switcheroo('aaaaa') == 'bbbbb'
    }

    @Test
    void "Random Tests"() {
        def random = new Random()
        random.with {
            (1..100).each {
                def randomInput = (0..nextInt(35)).collect { "abc"[nextInt(3)] }.join()
                assert LetterReplacer.switcheroo(randomInput) == solution(randomInput)
            }
        }
    }

    private static def solution(string) {
        string.tr('ab', 'ba')
    }
}
