package org.czareg.codewars.elephants.on.spider.web;

public class SpiderWeb {

    private final int strength;
    private final int width;

    public SpiderWeb(int strength, int width) {
        this.strength = strength;
        this.width = width;
    }

    public int getElephantToleranceNumber() {
        int totalWeight = 0;
        int totalElephants = 0;
        for (int level = 1, maxElephantsThisLevel = width; level <= width; level++, maxElephantsThisLevel--) {
            int elephantWeightThisLevel = level * 1000;
            int currentWeight = 0;
            int currentElephants = 0;
            while (totalWeight + currentWeight + elephantWeightThisLevel <= strength && currentElephants < maxElephantsThisLevel) {
                currentWeight += elephantWeightThisLevel;
                currentElephants++;
            }
            totalWeight += currentWeight;
            totalElephants += currentElephants;
        }
        return totalElephants;
    }
}
