package org.czareg.codewars.product.discount;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.czareg.codewars.product.discount.discounts.item.ItemDiscountCalculator;
import org.czareg.codewars.product.discount.discounts.total.TotalDiscountCalculator;
import org.czareg.codewars.product.discount.pojo.Order;
import org.czareg.codewars.product.discount.pojo.Product;

import java.math.BigDecimal;
import java.util.List;

/*
Write a calculator for a list of products (id, price) that will sum all the prices of given products, applying discounts:
a) three for two - for each 2 products with same id the third one is free (no limit)
b) ten percent off over 100 - if the sum of given product prices (after applying discount above) is over 100, we remove 10% of the sum
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ProductsToOrderProcessor {

    private final ItemDiscountCalculator itemDiscountCalculator;
    private final TotalDiscountCalculator totalDiscountCalculator;

    public Order process(@NonNull List<Product> products) {
        BigDecimal productsPriceSumBeforeDiscounts = products.stream()
                .map(Product::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal itemDiscounts = itemDiscountCalculator.calculate(products);
        BigDecimal sumAfterItemDiscounts = productsPriceSumBeforeDiscounts.subtract(itemDiscounts);
        BigDecimal totalDiscounts = totalDiscountCalculator.calculate(sumAfterItemDiscounts);
        BigDecimal totalSumAfterDiscounts = sumAfterItemDiscounts.subtract(totalDiscounts);
        return new Order(productsPriceSumBeforeDiscounts, itemDiscounts, totalDiscounts, totalSumAfterDiscounts);
    }
}
