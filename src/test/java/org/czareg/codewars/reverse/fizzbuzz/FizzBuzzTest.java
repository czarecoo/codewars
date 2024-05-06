package org.czareg.codewars.reverse.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @Test
    void basicTestCases() {
        assertEquals(List.of(1, 2, 3, 4, 5), FizzBuzz.reverseFizzBuzz("1 2 Fizz 4 Buzz"));
        assertEquals(List.of(687, 688, 689, 690), FizzBuzz.reverseFizzBuzz("Fizz 688 689 FizzBuzz"));
        assertEquals(List.of(9, 10), FizzBuzz.reverseFizzBuzz("Fizz Buzz"));
        assertEquals(Arrays.asList(56075, 56076, 56077, 56078, 56079, 56080, 56081, 56082, 56083, 56084, 56085, 56086, 56087, 56088, 56089, 56090, 56091, 56092, 56093, 56094, 56095, 56096, 56097, 56098, 56099, 56100, 56101, 56102, 56103, 56104, 56105, 56106, 56107, 56108, 56109, 56110, 56111, 56112, 56113, 56114, 56115, 56116, 56117, 56118, 56119, 56120, 56121, 56122, 56123, 56124, 56125, 56126, 56127, 56128, 56129, 56130, 56131, 56132, 56133, 56134, 56135, 56136, 56137, 56138, 56139, 56140, 56141, 56142, 56143, 56144, 56145, 56146, 56147, 56148, 56149, 56150, 56151, 56152, 56153), FizzBuzz.reverseFizzBuzz("Buzz Fizz 56077 56078 Fizz Buzz 56081 Fizz 56083 56084 FizzBuzz 56086 56087 Fizz 56089 Buzz Fizz 56092 56093 Fizz Buzz 56096 Fizz 56098 56099 FizzBuzz 56101 56102 Fizz 56104 Buzz Fizz 56107 56108 Fizz Buzz 56111 Fizz 56113 56114 FizzBuzz 56116 56117 Fizz 56119 Buzz Fizz 56122 56123 Fizz Buzz 56126 Fizz 56128 56129 FizzBuzz 56131 56132 Fizz 56134 Buzz Fizz 56137 56138 Fizz Buzz 56141 Fizz 56143 56144 FizzBuzz 56146 56147 Fizz 56149 Buzz Fizz 56152 56153"));
        assertEquals(Arrays.asList(176408, 176409, 176410, 176411, 176412, 176413, 176414, 176415, 176416, 176417, 176418, 176419, 176420, 176421, 176422, 176423, 176424, 176425, 176426, 176427, 176428, 176429, 176430, 176431, 176432, 176433), FizzBuzz.reverseFizzBuzz("176408 Fizz Buzz 176411 Fizz 176413 176414 FizzBuzz 176416 176417 Fizz 176419 Buzz Fizz 176422 176423 Fizz Buzz 176426 Fizz 176428 176429 FizzBuzz 176431 176432 Fizz"));
    }
}