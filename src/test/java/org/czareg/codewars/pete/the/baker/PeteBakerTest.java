package org.czareg.codewars.pete.the.baker;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PeteBakerTest {

    private void runTest(Map<String, Integer> m1, Map<String, Integer> m2, int result) {
        assertEquals(result, PeteBaker.cakes(new HashMap<>(m1), new HashMap<>(m2)), "For recipe " + m1 + " and ingredients " + m2);
    }

    private int batches(Map<String, Integer> recipe, Map<String, Integer> available) {
        int batches = Integer.MAX_VALUE;
        for (String ingredient : recipe.keySet()) {
            if (!available.containsKey(ingredient)) {
                return 0;
            }
            int required = recipe.get(ingredient);
            int amount = available.get(ingredient);
            batches = Math.min(batches, amount / required);
        }
        return batches;
    }

    @Order(1)
    @Test
    void basicTest() {
        Map<String, Integer> recipe = Map.of(
                "flour", 500,
                "sugar", 200,
                "eggs", 1);
        Map<String, Integer> available = Map.of(
                "flour", 1200,
                "sugar", 1200,
                "eggs", 5,
                "milk", 200);
        assertEquals(2, PeteBaker.cakes(recipe, available), "For recipe " + recipe + " and ingredients " + available);
    }

    @Order(2)
    @Test
    void missingIngredient() {
        Map<String, Integer> recipe = Map.of(
                "flour", 500,
                "sugar", 200,
                "eggs", 1,
                "cinnamon", 300);
        Map<String, Integer> available = Map.of(
                "flour", 1200,
                "sugar", 1200,
                "eggs", 5,
                "milk", 200);
        assertEquals(0, PeteBaker.cakes(recipe, available), "For recipe " + recipe + " and ingredients " + available);
    }

    @Order(3)
    @Test
    void staticTests() {
        Map<String, Integer> recipe = new HashMap<>();
        Map<String, Integer> available = new HashMap<>();
        recipe.put("flour", 1500);
        recipe.put("sugar", 200);
        recipe.put("eggs", 1);
        recipe.put("oil", 300);
        available.put("flour", 5000);
        available.put("sugar", 1200);
        available.put("eggs", 5);
        available.put("milk", 200);
        available.put("cream", 1000);
        runTest(recipe, available, 0);

        available.put("oil", 21000);
        runTest(recipe, available, 3);

        available.put("flour", 10000);
        runTest(recipe, available, 5);

        recipe.put("apples", 100);
        runTest(recipe, available, 0);

        available.put("apples", 99);
        runTest(recipe, available, 0);

        runTest(recipe, Map.of(), 0);

        available = recipe;
        runTest(recipe, available, 1);
    }

    @Order(4)
    @Test
    void randomTests() {
        Random r = new Random();
        String[] list = {"flour", "eggs", "sugar", "milk", "oil", "cinnamon", "cream"};
        List<String> ingredients = Arrays.asList(list);
        for (int i = 0; i < 100; i++) {
            Map<String, Integer> recipe = new HashMap<>();
            Map<String, Integer> available = new HashMap<>();

            Collections.shuffle(ingredients);
            int recipeNumber = r.nextInt(3, list.length);
            for (int j = 0; j < recipeNumber; j++) {
                recipe.put(ingredients.get(j), r.nextInt(1, 1001));
            }

            int availableNumber = r.nextInt(5 * list.length);
            for (int j = 0; j < availableNumber; j++) {
                int idx = r.nextInt(list.length);
                available.merge(ingredients.get(idx), r.nextInt(10001), Integer::sum);
            }

            int expected = batches(recipe, available);
            runTest(recipe, available, expected);
        }
    }
}