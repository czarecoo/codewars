package org.czareg.codewars.the.ify.funtion;

import org.junit.jupiter.api.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LogicUtilTest {

    @DisplayName("Test true")
    @Order(1)
    @Test
    void testTrue() {
        AtomicReference<String> actual = new AtomicReference<>("no function");
        LogicUtil.whenTrueOrElse(true, () -> actual.set("true function"), () -> actual.set("false function"));
        assertEquals("true function", actual.get());
    }

    @DisplayName("Test false")
    @Order(2)
    @Test
    void testFalse() {
        AtomicReference<String> actual = new AtomicReference<>("no function");
        LogicUtil.whenTrueOrElse(false, () -> actual.set("true function"), () -> actual.set("false function"));
        assertEquals("false function", actual.get());
    }

    @DisplayName("Test falsy value (null)")
    @Order(3)
    @Test
    void testFalsy() {
        AtomicReference<String> actual = new AtomicReference<>("no function");
        LogicUtil.whenTrueOrElse(null, () -> actual.set("true function"), () -> actual.set("false function"));
        assertEquals("false function", actual.get());
    }

    @DisplayName("Random test")
    @Order(4)
    @Test
    void testRandom() {
        var rnd = ThreadLocalRandom.current();
        Boolean[] bools = {true, false, null};
        for (int run = 0; run < 20; ++run) {
            Boolean bool = bools[rnd.nextInt(bools.length)];
            String expected = (Boolean.TRUE.equals(bool) ? "true" : "false") + " function";
            AtomicReference<String> actual = new AtomicReference<>("no function");
            LogicUtil.whenTrueOrElse(bool, () -> actual.set("true function"), () -> actual.set("false function"));
            assertEquals(expected, actual.get(), "For bool = " + bool);
        }
    }
}