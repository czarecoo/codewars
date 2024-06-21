package org.czareg.codewars.product.discount.discounts.item;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.czareg.codewars.product.discount.pojo.Product;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class ItemDiscountCalculator {

    private final List<ItemDiscount> itemDiscountList;

    public BigDecimal calculate(@NonNull List<Product> products) {
        BigDecimal totalDiscounts = BigDecimal.ZERO;
        for (ItemDiscount itemDiscount : itemDiscountList) {
            totalDiscounts = totalDiscounts.add(itemDiscount.calculate(products));
        }
        return totalDiscounts;
    }
}
