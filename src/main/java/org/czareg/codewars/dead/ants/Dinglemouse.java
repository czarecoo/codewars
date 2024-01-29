package org.czareg.codewars.dead.ants;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
An orderly trail of ants is marching across the park picnic area.

It looks something like this:

..ant..ant.ant...ant.ant..ant.ant....ant..ant.ant.ant...ant..
But suddenly there is a rumour that a dropped chicken sandwich has been spotted on the ground ahead. The ants surge forward! Oh No, it's an ant stampede!!

Some of the slower ants are trampled, and their poor little ant bodies are broken up into scattered bits.

The resulting carnage looks like this:

...ant...ant..nat.ant.t..ant...ant..ant..ant.anant..t
Can you find how many ants have died?

Notes
When in doubt, assume that the scattered bits are from the same ant. e.g. 2 heads and 1 body = 2 dead ants, not 3
 */
@UtilityClass
public class Dinglemouse {

    private static final Pattern ANT = Pattern.compile("ant");
    private static final Pattern A = Pattern.compile("a");
    private static final Pattern N = Pattern.compile("n");
    private static final Pattern T = Pattern.compile("t");

    public static int deadAntCount(final String ants) {
        if (ants == null || ants.isBlank()) {
            return 0;
        }
        int livingAnts = count(ANT.matcher(ants));
        return max(count(A.matcher(ants)), count(N.matcher(ants)), count(T.matcher(ants))) - livingAnts;
    }

    private static int count(Matcher matcher) {
        return (int) matcher.results().count();
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
