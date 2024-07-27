package org.czareg.codewars.everyone.has.secrets;

import java.lang.reflect.Field;

public class Guesser {

    public void guess() {
        String secret = extractSecret();
        LittleClass.isMySecret(secret);
    }

    private static String extractSecret() {
        try {
            Field secret = LittleClass.class.getDeclaredField("SECRET");
            secret.setAccessible(true);
            return (String) secret.get(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) {
        new Guesser().guess();
    }
}
