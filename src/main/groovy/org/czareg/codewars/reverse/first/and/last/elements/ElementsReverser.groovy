package org.czareg.codewars.reverse.first.and.last.elements

class ElementsReverser {

    static def reverseFirstAndLast(arr) {
        if (arr.size() <= 1) {
            return arr
        }
        arr.swap(0, arr.size() - 1)
    }
}
