package org.czareg.codewars.product.discount;

import java.math.BigDecimal;

public record Product(int id, BigDecimal price) {

    public Product {
        if (id < 0) {
            throw new IllegalArgumentException("Id has to be 0 or above");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price has to be above 0");
        }
    }
}

