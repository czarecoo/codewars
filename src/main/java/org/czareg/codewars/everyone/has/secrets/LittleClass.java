package org.czareg.codewars.everyone.has.secrets;

import lombok.extern.java.Log;

@Log
public class LittleClass {

    private static final String SECRET = "notVeryWellProtected";

    public static void isMySecret(String input) {
        if (SECRET.equals(input)) {
            log.info("How did you found my secret ?!?");
        } else {
            log.info("Try again");
        }
    }
}
