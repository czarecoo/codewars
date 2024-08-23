package org.czareg.codewars.supermarket.queue;

import java.util.Deque;

interface TillsManager {

    void passTime();

    int totalTimePassed();

    Deque<Till> getFreeTills();

    boolean areAllTillsFree();
}
