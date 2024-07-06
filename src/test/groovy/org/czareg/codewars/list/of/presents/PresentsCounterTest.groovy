package org.czareg.codewars.list.of.presents

import org.junit.jupiter.api.Test

class PresentsCounterTest {

    @Test
    void "Basic Tests"() {
        assert PresentsCounter.howManyGifts(20, [13, 2, 4, 6, 1]) == 4
        assert PresentsCounter.howManyGifts(90, [87, 3, 5, 25, 1, 3, 4, 6, 20]) == 8
        assert PresentsCounter.howManyGifts(100, [6, 94, 10, 45, 2, 4, 5, 6, 8, 1]) == 9
        assert PresentsCounter.howManyGifts(0, [1]) == 0
        assert PresentsCounter.howManyGifts(910238, [1231, 423402324, 9324810, 23948, 19823, 1, 3209, 23894, 1093]) == 7
        assert PresentsCounter.howManyGifts(918, [1, 1, 1, 900, 1, 56, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0]) == 217
        assert PresentsCounter.howManyGifts(10000000, [4, 4, 4, 189189956, 489498, 489489, 6456321, 564156, 231231, 123, 4674, 74987, 45646, 1411, 5496, 9474, 42, 1111, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 478789, 454, 31321, 2222, 33334, 45465, 489479, 989, 4546, 123, 321, 456, 987, 453, 741, 1231, 45468, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 123, 1, 1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 1, 646, 798798, 22, 45, 7897, 45132, 666, 1132, 12, 5478, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42]) == 110
        assert PresentsCounter.howManyGifts(90, [10, 10, 10, 10, 10, 10, 5, 5, 5, 5, 5, 5]) == 12
        assert PresentsCounter.howManyGifts(4, [1, 1, 1, 1]) == 4
        assert PresentsCounter.howManyGifts(1, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]) == 56
    }

    @Test
    void "Random tests"() {
        def random = new Random()
        150.times {
            def gifts = []
            random.nextInt(999).times {
                gifts << random.nextInt(20)
            }
            def maxBudget = random.nextInt(999)
            assert PresentsCounter.howManyGifts(maxBudget, gifts) == solution(maxBudget, gifts)
        }
    }

    private static int solution(maxBudget, gifts) {
        gifts
                .sort()
                .count {
                    maxBudget -= it
                    maxBudget >= 0
                }
    }
}
