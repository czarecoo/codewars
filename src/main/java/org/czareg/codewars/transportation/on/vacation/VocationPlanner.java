package org.czareg.codewars.transportation.on.vacation;

import lombok.experimental.UtilityClass;

/*
After a hard quarter in the office you decide to get some rest on a vacation. So you will book a flight for you and your girlfriend and try to leave all the mess behind you.

You will need a rental car in order for you to get around in your vacation. The manager of the car rental makes you some good offers.

Every day you rent the car costs $40. If you rent the car for 7 or more days, you get $50 off your total. Alternatively, if you rent the car for 3 or more days, you get $20 off your total.

Write a code that gives out the total amount for different days(d).
 */
@UtilityClass
public class VocationPlanner {

    private static final int PRICE_PER_DAY = 40;
    private static final int DISCOUNT_FOR_THREE_OR_MORE_DAYS = 20;
    private static final int DISCOUNT_FOR_SEVEN_OR_MORE_DAYS = 50;

    public static int rentalCarCost(int days) {
        if (days < 1) {
            return 0;
        }
        int costBeforeDiscount = PRICE_PER_DAY * days;
        return switch (days) {
            case 1, 2 -> costBeforeDiscount;
            case 3, 4, 5, 6 -> costBeforeDiscount - DISCOUNT_FOR_THREE_OR_MORE_DAYS;
            default -> costBeforeDiscount - DISCOUNT_FOR_SEVEN_OR_MORE_DAYS;
        };
    }
}
