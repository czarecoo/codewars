package org.czareg.codewars.curing.arachnophobia;

import lombok.experimental.UtilityClass;

/*
There is no single treatment that works for every phobia, but some people cure it by being gradually exposed to the phobic situation or object. In this kata we will try curing arachnophobia by drawing primitive spiders.

Our spiders will have legs, body, eyes and a mouth. Here are some examples:

/\((OOwOO))/\

/╲(((0000w0000)))╱\

^(oWo)^
You will be given four values:

leg size where each value stands for its own leg type: 1 for "^ ^", 2 for "/\ /\", 3 for "/╲ ╱\", 4 for "╱╲ ╱╲"
body size where each value stands for its own body type: 1 for "( )", 2 for "(( ))", 3 for "((( )))"
mouth representing the spider's mouth
eye representing the spider's eye
Note: the eyes are symmetric, and their total amount is 2 to the power of body size.

You will also be given only valid data. That's it for the instructions, you can start coding!
 */
@UtilityClass
public class Spiders {

    public static String drawSpider(int legSize, int bodySize, char mouth, char eye) {
        Pair<String> legs = switch (legSize) {
            case 1 -> new Pair<>("^", "^");
            case 2 -> new Pair<>("/\\", "/\\");
            case 3 -> new Pair<>("/╲", "╱\\");
            case 4 -> new Pair<>("╱╲", "╱╲");
            default -> throw new IllegalArgumentException();
        };
        Pair<String> body = new Pair<>("(".repeat(bodySize), ")".repeat(bodySize));
        String eyes = String.valueOf(eye).repeat((int) (Math.pow(2, bodySize) / 2));
        return "%s%s%s%s%s%s%s".formatted(legs.left(), body.left(), eyes, mouth, eyes, body.right(), legs.right());
    }

    record Pair<T>(T left, T right) {
    }
}
