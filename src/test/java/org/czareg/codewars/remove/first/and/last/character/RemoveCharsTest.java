package org.czareg.codewars.remove.first.and.last.character;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RemoveCharsTest {

    @Test
    void testIncorrectArguments() {
        assertThrows(IllegalArgumentException.class, () -> RemoveChars.remove(null));
        assertThrows(IllegalArgumentException.class, () -> RemoveChars.remove(""));
        assertThrows(IllegalArgumentException.class, () -> RemoveChars.remove(" "));
    }

    @Test
    void testRemoval() {
        assertEquals("loquen", RemoveChars.remove("eloquent"));
        assertEquals("ountr", RemoveChars.remove("country"));
        assertEquals("erso", RemoveChars.remove("person"));
        assertEquals("lac", RemoveChars.remove("place"));
        assertEquals("oopss", RemoveChars.remove("ooopsss"));
    }


    @Test
    void testRemovalWithRandomString() {
        for (int i = 0; i < 6; i++) {
            String randStr = randomString(random.nextInt(21) + 10);
            assertEquals(solution(randStr), RemoveChars.remove(randStr));
        }
    }

    private static final Random random = new SecureRandom();

    private static String randomString(int len) {
        StringBuilder sb = new StringBuilder();

        while (len > 0) {
            // char from '!' to '~'
            sb.append((char) (random.nextInt(94) + 33));
            len--;
        }

        return sb.toString();
    }

    private static String solution(String str) {
        return str.substring(1, str.length() - 1);
    }
}