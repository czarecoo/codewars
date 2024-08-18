package org.czareg.codewars.the.ify.funtion;

import lombok.experimental.UtilityClass;

import static java.lang.Boolean.TRUE;

/*
Create a function called _if which takes 3 arguments: a value bool and 2 functions (which do not take any parameters): func1 and func2

When bool is truthy, func1 should be called, otherwise call the func2.
 */
@UtilityClass
public class LogicUtil {

    public static void whenTrueOrElse(Boolean bool, Runnable func1, Runnable func2) {
        if (bool == TRUE) {
            func1.run();
        } else {
            func2.run();
        }
    }
}
