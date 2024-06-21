package org.czareg.codewars.product.discount.discounts.total;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class TotalDiscountCalculator {

    private final List<TotalDiscount> totalDiscountList;

    public BigDecimal calculate(@NonNull BigDecimal sumAfterItemDiscounts) {
        BigDecimal partialSum = sumAfterItemDiscounts;
        BigDecimal totalDiscounts = BigDecimal.ZERO;
        for (TotalDiscount totalDiscount : totalDiscountList) {
            BigDecimal discount = totalDiscount.calculate(partialSum);
            totalDiscounts = totalDiscounts.add(discount);
            partialSum = partialSum.subtract(discount);
        }
        return totalDiscounts;
    }
}
