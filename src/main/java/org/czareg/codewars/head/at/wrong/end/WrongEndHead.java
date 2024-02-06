package org.czareg.codewars.head.at.wrong.end;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
You're at the zoo... all the meerkats look weird. Something has gone terribly wrong - someone has gone and switched their heads and tails around!

Save the animals by switching them back. You will be given an array which will have three values (tail, body, head). It is your job to re-arrange the array so that the animal is the right way round (head, body, tail).

Same goes for all the other arrays/lists that you will get in the tests: you have to change the element positions with the same exact logics
 */
@UtilityClass
public class WrongEndHead {

    public static String[] fixTheMeerkat(String[] arr) {
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray(new String[0]);
    }
}
