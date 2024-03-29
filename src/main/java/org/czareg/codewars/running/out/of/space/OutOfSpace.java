package org.czareg.codewars.running.out.of.space;

import lombok.experimental.UtilityClass;

/*
Kevin is noticing his space run out! Write a function that removes the spaces from the values and returns an array showing the space decreasing.
For example, running this function on the array ['i', 'have','no','space'] would produce ['i','ihave','ihaveno','ihavenospace']
 */
@UtilityClass
public class OutOfSpace {

    public static String[] spacey(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String previous = array[i - 1];
            array[i] = previous + array[i];
        }
        return array;
    }
}
