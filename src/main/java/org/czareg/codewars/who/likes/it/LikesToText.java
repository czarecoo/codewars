package org.czareg.codewars.who.likes.it;

import lombok.experimental.UtilityClass;

/*
You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.

Implement the function which takes an array containing the names of people that like an item. It must return the display text as shown in the examples:

[]                                -->  "no one likes this"
["Peter"]                         -->  "Peter likes this"
["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
Note: For 4 or more names, the number in "and 2 others" simply increases.
 */
@UtilityClass
public class LikesToText {

    public static String whoLikesIt(String... names) {
        return switch (names.length) {
            case 0 -> "no one likes this";
            case 1 -> "%s likes this".formatted(names[0]);
            case 2 -> "%s and %s like this".formatted(names[0], names[1]);
            case 3 -> "%s, %s and %s like this".formatted(names[0], names[1], names[2]);
            default -> "%s, %s and %s others like this".formatted(names[0], names[1], names.length - 2);
        };
    }
}
