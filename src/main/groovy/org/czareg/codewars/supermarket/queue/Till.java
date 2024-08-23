package org.czareg.codewars.supermarket.queue;

interface Till {

    void passTime();

    boolean isFree();

    void assignCustomer(int timeNeeded);
}
