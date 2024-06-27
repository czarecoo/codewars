package org.czareg.codewars.fruit.machine;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
You will be given three reels of different images and told at which index the reels stop. From this information your job is to return the score of the resulted reels.

1. There are always exactly three reels
2. Each reel has 10 different items.
3. The three reel inputs may be different.
4. The spin array represents the index of where the reels finish.
5. The three spin inputs may be different
6. Three of the same is worth more than two of the same
7. Two of the same plus one "Wild" is double the score.
8. No matching items returns 0.

Scoring
Item Three of the same Two of the same Two of the same plus one Wild
Wild 100 10 N/A
Star 90 9 18
Bell 80 8 16
Shell 70 7 14
Seven 60 6 12
Cherry 50 5 10
Bar 40 4 8
King 30 3 6
Queen 20 2 4
Jack 10 1 2
 */
@UtilityClass
class FruitMachine {

    static int fruit(final String[][] reels, final int[] spins) {
        Map<ImageScore, Long> imageCount = Stream.of(reels[0][spins[0]], reels[1][spins[1]], reels[2][spins[2]])
                .map(ImageScore::of)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (imageCount.size() == 1) {
            ImageScore threeOfTheSame = findKeyUsingValue(imageCount, 3L);
            return threeOfTheSame.threeOfTheSameScore;
        }
        if (imageCount.size() == 2) {
            ImageScore twoOfTheSame = findKeyUsingValue(imageCount, 2L);
            ImageScore oneOfTheSame = findKeyUsingValue(imageCount, 1L);
            if (oneOfTheSame == ImageScore.WILD) {
                return twoOfTheSame.twoOfTheSamePlusOneWildScore;
            } else {
                return twoOfTheSame.twoOfTheSameScore;
            }
        }
        return 0;
    }

    private static <K, V> K findKeyUsingValue(Map<K, V> map, V entryValue) {
        return map.entrySet()
                .stream()
                .filter(entry -> entryValue.equals(entry.getValue()))
                .findFirst()
                .orElseThrow()
                .getKey();
    }

    @RequiredArgsConstructor
    enum ImageScore {

        WILD(100, 10, 100),
        STAR(90, 9, 18),
        BELL(80, 8, 16),
        SHELL(70, 7, 14),
        SEVEN(60, 6, 12),
        CHERRY(50, 5, 10),
        BAR(40, 4, 8),
        KING(30, 3, 6),
        QUEEN(20, 2, 4),
        JACK(10, 1, 2);

        final int threeOfTheSameScore;
        final int twoOfTheSameScore;
        final int twoOfTheSamePlusOneWildScore;

        static ImageScore of(String search) {
            return Arrays.stream(ImageScore.values())
                    .filter(imageScoreName -> imageScoreName.name().equalsIgnoreCase(search))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
