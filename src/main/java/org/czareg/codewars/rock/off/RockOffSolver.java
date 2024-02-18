package org.czareg.codewars.rock.off;

import lombok.experimental.UtilityClass;

/*
Alice and Bob have participated to a Rock Off with their bands. A jury of true metalheads rates the two challenges, awarding points to the bands on a scale from 1 to 50 for three categories: Song Heaviness, Originality, and Members' outfits.

For each one of these 3 categories they are going to be awarded one point, should they get a better judgement from the jury. No point is awarded in case of an equal vote.

You are going to receive two arrays, containing first the score of Alice's band and then those of Bob's. Your task is to find their total score by comparing them in a single line.

Example:

Alice's band plays a Nirvana inspired grunge and has been rated 20 for Heaviness, 32 for Originality and only 18 for Outfits. Bob listens to Slayer and has gotten a good 48 for Heaviness, 25 for Originality and a rather honest 40 for Outfits.

The total score should be followed by a colon : and by one of the following quotes: if Alice's band wins: Alice made "Kurt" proud! if Bob's band wins: Bob made "Jeff" proud! if they end up with a draw: that looks like a "draw"! Rock on!

The solution to the example above should therefore appear like '1, 2: Bob made "Jeff" proud!'.
 */
@UtilityClass
public class RockOffSolver {

    private static final String DRAW = "that looks like a \"draw\"! Rock on!";
    private static final String ALICE_WON = "Alice made \"Kurt\" proud!";
    private static final String BOB_WON = "Bob made \"Jeff\" proud!";

    public static String solveRockOff(final int[] alice, final int[] bob) {
        if (alice == null || bob == null || alice.length != 3 || bob.length != 3) {
            throw new IllegalArgumentException();
        }
        int aliceScore = 0;
        int bobScore = 0;
        for (int i = 0; i < alice.length; i++) {
            if (alice[i] == bob[i]) {
                continue;
            }
            if (alice[i] > bob[i]) {
                aliceScore++;
            } else {
                bobScore++;
            }
        }
        String outcomeText = decideWhoWon(aliceScore, bobScore);
        return "%s, %s: %s".formatted(aliceScore, bobScore, outcomeText);
    }

    private static String decideWhoWon(int aliceScore, int bobScore) {
        if (aliceScore == bobScore) {
            return DRAW;
        }
        return aliceScore > bobScore ? ALICE_WON : BOB_WON;
    }
}
