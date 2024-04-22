package multiples.of.three.or.five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplesFinderTest {

    @Test
    void test() {
        assertEquals(23, MultiplesFinder.solution(10));
        assertEquals(78, MultiplesFinder.solution(20));
        assertEquals(9168, MultiplesFinder.solution(200));
    }
}