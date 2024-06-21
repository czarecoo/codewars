package org.czareg.codewars.product.discount.pojo;

import lombok.NonNull;

import java.math.BigDecimal;

public record Order(@NonNull BigDecimal productsPriceSumBeforeDiscounts,
                    @NonNull BigDecimal itemDiscounts,
                    @NonNull BigDecimal totalDiscounts,
                    @NonNull BigDecimal totalSumAfterDiscounts) {
    public Order {
        if (productsPriceSumBeforeDiscounts.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("ProductsPriceSumBeforeDiscounts has to be 0 or above");
        }
        if (itemDiscounts.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("ItemDiscounts has to be 0 or above");
        }
        if (totalDiscounts.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("TotalDiscounts has to be 0 or above");
        }
        if (totalSumAfterDiscounts.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("TotalSumAfterDiscounts has to be 0 or above");
        }
    }
}
