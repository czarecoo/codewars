package org.czareg.codewars.reverse.first.and.last.elements

import org.junit.jupiter.api.Test

class ElementsReverserTest {

    @Test
    void "Fixed Tests"() {
        assert ElementsReverser.reverseFirstAndLast([1, 2, 3, 4, 5]) == [5, 2, 3, 4, 1]
        assert ElementsReverser.reverseFirstAndLast([3, 5, 6, 2]) == [2, 5, 6, 3]
        assert ElementsReverser.reverseFirstAndLast([]) == []
        assert ElementsReverser.reverseFirstAndLast([111]) == [111]
        assert ElementsReverser.reverseFirstAndLast([6, 4, 2, 5, 7]) == [7, 4, 2, 5, 6]
        assert ElementsReverser.reverseFirstAndLast(['one', 'two', 'three']) == ['three', 'two', 'one']
        assert ElementsReverser.reverseFirstAndLast(['Codewars']) == ['Codewars']
        assert ElementsReverser.reverseFirstAndLast([111, 45]) == [45, 111]
    }

    @Test
    void "Random Tests"() {
        def random = new Random()
        random.with {
            def randomInput = (0..nextInt(50)).collect { nextInt(4000) - 2000 }
            assert ElementsReverser.reverseFirstAndLast(randomInput.collect()) == solution(randomInput.collect())
        }
    }

    private static def solution(arr) {
        arr.size() < 2 ? arr : arr.swap(0, arr.size() - 1)
    }
}
