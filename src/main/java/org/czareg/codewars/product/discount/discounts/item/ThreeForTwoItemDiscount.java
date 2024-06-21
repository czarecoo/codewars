package org.czareg.codewars.product.discount.discounts.item;

import lombok.NonNull;
import org.czareg.codewars.product.discount.pojo.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThreeForTwoItemDiscount implements ItemDiscount {

    private static final int FREE_PRODUCT_EVERY = 3;

    @Override
    public BigDecimal calculate(@NonNull List<Product> products) {
        Map<Product, Long> productByCount = products.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(Product::price, Collectors.counting())));
        BigDecimal totalDiscount = BigDecimal.ZERO;
        for (Map.Entry<Product, Long> productLongEntry : productByCount.entrySet()) {
            Long productCount = productLongEntry.getValue();
            long freeCount = productCount / FREE_PRODUCT_EVERY;
            BigDecimal productPrice = productLongEntry.getKey().price();
            BigDecimal discountPerProduct = productPrice.multiply(BigDecimal.valueOf(freeCount));
            totalDiscount = totalDiscount.add(discountPerProduct);
        }
        return totalDiscount;
    }
}
