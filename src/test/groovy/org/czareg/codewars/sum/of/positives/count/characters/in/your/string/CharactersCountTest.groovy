package org.czareg.codewars.sum.of.positives.count.characters.in.your.string

import org.junit.jupiter.api.Test

class CharactersCountTest {

    @Test
    void "Fixed Tests"() {
        assert CharactersCount.count('') == [:]
        assert CharactersCount.count('aa') == ['a': 2]
        assert CharactersCount.count('aabb') == ['a': 2, 'b': 2]
        assert CharactersCount.count('aabb') == ['b': 2, 'a': 2]
    }

    @Test
    void "Random Tests"() {
        def alphabet = ('a'..'z') + ('A'..'Z')
        def asize = alphabet.size() - 1
        def random = new Random()
        random.with {
            def randomInput = (0..nextInt(100)).collect { alphabet[nextInt(asize)] }.join()
            assert CharactersCount.count(randomInput) == solution(randomInput)
        }
    }

    private static def solution(String string) {
        string.toList().groupBy { it }.collectEntries { k, v -> [(k), v.size()] }
    }
}