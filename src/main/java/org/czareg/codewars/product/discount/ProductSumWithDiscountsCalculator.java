package org.czareg.codewars.product.discount;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/*
Write a calculator for a list of products (id, price) that will sum all the prices of given products, applying discounts:
a) three for two - for each 2 products with same id the third one is free (no limit)
b) ten percent off over 100 - if the sum of given product prices (after applying discount above) is over 100, we remove 10% of the sum
 */
@UtilityClass
public class ProductSumWithDiscountsCalculator {

    private static final int FREE_PRODUCT_EVERY = 3;

    private static final BigDecimal DISCOUNT_TRIGGER_IF_OVER = new BigDecimal("100");
    private static final BigDecimal DISCOUNT_PERCENT = new BigDecimal("0.10");

    public static BigDecimal sum(List<Product> products) {
        Map<Product, Long> productByCount = products.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(Product::price, counting())));

        for (Map.Entry<Product, Long> productLongEntry : productByCount.entrySet()) {
            Long count = productLongEntry.getValue();
            long freebies = count / FREE_PRODUCT_EVERY;
            productLongEntry.setValue(count - freebies);
        }

        BigDecimal totalSum = productByCount.entrySet()
                .stream()
                .map(entry -> entry.getKey().price().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (totalSum.compareTo(DISCOUNT_TRIGGER_IF_OVER) > 0) {
            BigDecimal discount = totalSum.multiply(DISCOUNT_PERCENT);
            return totalSum.subtract(discount);
        }
        return totalSum;
    }
}
