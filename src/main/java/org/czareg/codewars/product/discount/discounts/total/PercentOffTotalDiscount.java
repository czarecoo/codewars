package org.czareg.codewars.product.discount.discounts.total;

import lombok.NonNull;

import java.math.BigDecimal;

public class PercentOffTotalDiscount implements TotalDiscount {

    private static final BigDecimal SUM_TO_TRIGGER_DISCOUNT = new BigDecimal("100");
    private static final BigDecimal DISCOUNT_PERCENT = new BigDecimal("0.10");

    @Override
    public BigDecimal calculate(@NonNull BigDecimal totalSum) {
        if (totalSum.compareTo(SUM_TO_TRIGGER_DISCOUNT) > 0) {
            return totalSum.multiply(DISCOUNT_PERCENT);
        }
        return BigDecimal.ZERO;
    }
}
