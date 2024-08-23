package org.czareg.codewars.supermarket.queue;

class BasicTill implements Till {

    private int timeNeeded = 0;

    @Override
    public void passTime() {
        if (timeNeeded > 0) {
            timeNeeded--;
        }
    }

    @Override
    public boolean isFree() {
        return timeNeeded == 0;
    }

    @Override
    public void assignCustomer(int timeNeeded) {
        this.timeNeeded = timeNeeded;
    }
}
