package org.czareg.codewars.product.discount;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductSumWithDiscountsCalculatorTest {

    @Test
    void noDiscounts() {
        List<Product> products = List.of(
                new Product(1, new BigDecimal(5)),
                new Product(2, new BigDecimal(10))
        );

        BigDecimal sum = ProductSumWithDiscountsCalculator.sum(products);

        BigDecimal expected = new BigDecimal(15);
        assertThat(sum).isEqualByComparingTo(expected);
    }

    @Test
    void threeForTwo() {
        Product product = new Product(1, new BigDecimal(10));
        List<Product> products = List.of(product, product, product);

        BigDecimal sum = ProductSumWithDiscountsCalculator.sum(products);

        BigDecimal expected = new BigDecimal(20);
        assertThat(sum).isEqualByComparingTo(expected);
    }

    @Test
    void overHundred() {
        List<Product> products = List.of(
                new Product(1, new BigDecimal(200))
        );

        BigDecimal sum = ProductSumWithDiscountsCalculator.sum(products);

        BigDecimal expected = new BigDecimal(180);
        assertThat(sum).isEqualByComparingTo(expected);
    }

    @Test
    void threeForTwoAndOverHundred() {
        Product product = new Product(1, new BigDecimal(500));
        List<Product> products = List.of(product, product, product);

        BigDecimal sum = ProductSumWithDiscountsCalculator.sum(products);

        BigDecimal expected = new BigDecimal(900);
        assertThat(sum).isEqualByComparingTo(expected);
    }
}