package org.czareg.codewars.supermarket.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

class BasicTillsManager implements TillsManager {

    private final List<Till> tills;
    private int totalTimePassed;

    BasicTillsManager(int tillsCount) {
        totalTimePassed = 0;
        tills = new ArrayList<>();
        for (int i = 1; i <= tillsCount; i++) {
            tills.add(new BasicTill());
        }
    }

    @Override
    public void passTime() {
        tills.forEach(Till::passTime);
        totalTimePassed++;
    }

    @Override
    public int totalTimePassed() {
        return totalTimePassed;
    }

    @Override
    public Deque<Till> getFreeTills() {
        return tills.stream()
                .filter(Till::isFree)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    @Override
    public boolean areAllTillsFree() {
        return tills.stream()
                .allMatch(Till::isFree);
    }
}
