package org.czareg.codewars.ones.and.zeros;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryArrayToNumberTest {

    @Test
    void simpleTests() {
        assertEquals(1, BinaryArrayToNumber.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0, 0, 0, 1))));
        assertEquals(15, BinaryArrayToNumber.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1, 1, 1, 1))));
        assertEquals(6, BinaryArrayToNumber.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0, 1, 1, 0))));
        assertEquals(9, BinaryArrayToNumber.convertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1, 0, 0, 1))));
    }

    @Test
    void randomTests() {
        List<List<Integer>> tests = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < Math.floor(Math.random() * 10) + 4; j++) {
                temp.add((int) Math.round(Math.random() * 1));
            }
            tests.add(temp);
        }
        tests.forEach((test) -> {
            String s = test.toString();
            StringBuilder ans = new StringBuilder();
            for (char c : s.toCharArray()) {
                int value = Character.getNumericValue(c);
                if (value == 1 || value == 0) {
                    ans.append(c);
                }
            }
            int solution = Integer.parseInt(ans.toString(), 2);
            assertEquals(solution, BinaryArrayToNumber.convertBinaryArrayToInt(test));
        });
    }
}