package org.czareg.codewars.product.discount.discounts.item;

import lombok.NonNull;
import org.czareg.codewars.product.discount.pojo.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ItemDiscount {

    BigDecimal calculate(@NonNull List<Product> products);
}
