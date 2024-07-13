package org.czareg.codewars.drinking.game

/*
Mike and Joe are frat boys that love beer and games that involve drinking. They play the following game: Mike chugs one beer,
then Joe chugs 2 beers, then Mike chugs 3 beers, then Joe chugs 4 beers, and so on. Once someone can't drink what he is supposed to drink, he loses.

Mike can chug at most A beers in total (otherwise he would pass out), while Joe can chug at most B beers in total. Who will win the game?

Write the function game(A,B) that returns the winner, "Mike" or "Joe" accordingly, for any given integer values of A and B.

Note: If either Mike or Joe cannot drink at least 1 beer, return the string "Non-drinkers can't play".
 */

class MikeAndJoeChuggingGame {

    static play(int mikeMaxBeers, int joeMaxBeers) {
        if (mikeMaxBeers < 1 || joeMaxBeers < 1) {
            return "Non-drinkers can't play"
        }
        def currentPlayer = new Player("Mike", mikeMaxBeers)
        def otherPlayer = new Player("Joe", joeMaxBeers)

        for (int beersToDrink = 1; ; beersToDrink++) {
            if (currentPlayer.cannotDrink(beersToDrink)) {
                return otherPlayer.getName()
            }
            currentPlayer.drink(beersToDrink)

            // Swap players
            def temp = currentPlayer
            currentPlayer = otherPlayer
            otherPlayer = temp
        }
    }

    static class Player {

        String name
        int drunkBeers
        int maxBeers

        Player(String name, int maxBeers) {
            this.name = name
            this.drunkBeers = 0
            this.maxBeers = maxBeers
        }

        boolean cannotDrink(int beersToDrink) {
            return drunkBeers + beersToDrink > maxBeers
        }

        void drink(int beersToDrink) {
            drunkBeers += beersToDrink
        }

        String getName() {
            return name
        }
    }
}