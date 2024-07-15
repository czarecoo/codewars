package org.czareg.codewars.without.numbers

import java.time.DayOfWeek

/*
Write a function that always returns 5

Sounds easy right? Just bear in mind that you can't use any of the following characters: 0123456789*+-/
 */

class Five {

    static int unusualFive() {
        DayOfWeek.FRIDAY.getValue()
    }
}
