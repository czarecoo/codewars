package org.czareg.codewars.sum.of.positives

class PositivesSum {

    static positiveSum(list) {
        list.findAll { it > 0 }.sum(0)
    }
}
