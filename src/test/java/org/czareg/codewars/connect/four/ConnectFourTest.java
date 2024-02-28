package org.czareg.codewars.connect.four;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConnectFourTest {

    /*
    - - - - - - -
    - - - - - - -
    - - - - - - -
    - Y - - - - -
    R Y - - - - -
    R Y - - - - -
    R Y - - - - R
     */
    @Test
    void firstTest() {
        List<String> myList = new ArrayList<String>(Arrays.asList("A_Red", "B_Yellow", "A_Red", "B_Yellow", "A_Red",
                "B_Yellow", "G_Red", "B_Yellow"));
        assertEquals("Yellow", ConnectFour.whoIsWinner(myList));
    }

    /*
    - - - - - - -
    - - - Y - - -
    - - - R - - -
    R Y R Y - - Y <- Y wins diagonally
    Y Y R R R Y R
    Y R Y Y Y R R
    R R Y Y R R Y
     */
    @Test
    void secondTest() {
        List<String> myList = new ArrayList<String>(Arrays.asList("C_Yellow", "E_Red", "G_Yellow", "B_Red", "D_Yellow",
                "B_Red", "B_Yellow", "G_Red", "C_Yellow", "C_Red", "D_Yellow", "F_Red", "E_Yellow", "A_Red", "A_Yellow",
                "G_Red", "A_Yellow", "F_Red", "F_Yellow", "D_Red", "B_Yellow", "E_Red", "D_Yellow", "A_Red", "G_Yellow",
                "D_Red", "D_Yellow", "C_Red"));
        assertEquals("Yellow", ConnectFour.whoIsWinner(myList));
    }

    /*
    - - - - - - -
    - - - - - - -
    - - - - - - -
    - - - Y - - -
    - - Y R - - Y
    - Y R R - - Y
    Y R R R R Y Y <- Red wins vertically
     */
    @Test
    void thirdTest() {
        List<String> myList = new ArrayList<String>(Arrays.asList("A_Yellow", "B_Red", "B_Yellow", "C_Red", "G_Yellow",
                "C_Red", "C_Yellow", "D_Red", "G_Yellow", "D_Red", "G_Yellow", "D_Red", "F_Yellow", "E_Red", "D_Yellow"));
        assertEquals("Red", ConnectFour.whoIsWinner(myList));
    }

}