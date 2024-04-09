package org.czareg.codewars.pete.the.baker;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/*
Pete likes to bake some cakes. He has some recipes and ingredients. Unfortunately he is not good in maths.
Can you help him to find out, how many cakes he could bake considering his recipes?

Write a function cakes(), which takes the recipe (object) and the available ingredients (also an object) and returns
the maximum number of cakes Pete can bake (integer). For simplicity there are no units for the amounts (e.g. 1 lb of flour
or 200 g of sugar are simply 1 or 200). Ingredients that are not present in the objects, can be considered as 0.
 */
@UtilityClass
public class PeteBaker {

    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        Map<String, Integer> leftover = new HashMap<>(available);
        int ableToMake = 0;
        for (; ; ) {
            for (Map.Entry<String, Integer> cakeRecipe : recipe.entrySet()) {
                String ingredientName = cakeRecipe.getKey();
                int requiredAmount = cakeRecipe.getValue();
                int leftoverAmount = leftover.getOrDefault(ingredientName, 0) - requiredAmount;
                if (leftoverAmount < 0) {
                    return ableToMake;
                }
                leftover.put(ingredientName, leftoverAmount);
            }
            ableToMake++;
        }
    }
}
