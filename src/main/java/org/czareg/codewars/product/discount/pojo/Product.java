package org.czareg.codewars.product.discount.pojo;

import lombok.NonNull;

import java.math.BigDecimal;

public record Product(int id, @NonNull BigDecimal price) {

    public Product {
        if (id < 0) {
            throw new IllegalArgumentException("Id has to be 0 or above");
        }
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price has to be above 0");
        }
    }
}

