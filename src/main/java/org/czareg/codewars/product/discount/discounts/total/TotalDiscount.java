package org.czareg.codewars.product.discount.discounts.total;

import lombok.NonNull;

import java.math.BigDecimal;

public interface TotalDiscount {

    BigDecimal calculate(@NonNull BigDecimal totalSum);
}
