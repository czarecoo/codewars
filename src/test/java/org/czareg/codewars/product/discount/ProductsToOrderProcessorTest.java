package org.czareg.codewars.product.discount;

import org.czareg.codewars.product.discount.pojo.Order;
import org.czareg.codewars.product.discount.pojo.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductsToOrderProcessorTest {

    ProductsToOrderProcessor productsToOrderProcessor = ProductsToOrderProcessorFactory.create();

    @Test
    void noProducts() {
        List<Product> products = List.of();

        Order order = productsToOrderProcessor.process(products);

        Order expected = new Order(
                new BigDecimal(0),
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                new BigDecimal(0)
        );
        assertOrder(expected, order);
    }

    @Test
    void noDiscounts() {
        List<Product> products = List.of(
                new Product(1, new BigDecimal(5)),
                new Product(2, new BigDecimal(10))
        );

        Order order = productsToOrderProcessor.process(products);

        Order expected = new Order(
                new BigDecimal(15),
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                new BigDecimal(15)
        );
        assertOrder(expected, order);
    }

    @Test
    void threeForTwo() {
        Product product = new Product(1, new BigDecimal(10));
        List<Product> products = List.of(product, product, product);

        Order order = productsToOrderProcessor.process(products);

        Order expected = new Order(
                new BigDecimal(30),
                new BigDecimal(10),
                BigDecimal.ZERO,
                new BigDecimal(20)
        );
        assertOrder(expected, order);
    }

    @Test
    void overHundred() {
        List<Product> products = List.of(
                new Product(1, new BigDecimal(200))
        );

        Order order = productsToOrderProcessor.process(products);

        Order expected = new Order(
                new BigDecimal(200),
                BigDecimal.ZERO,
                new BigDecimal(20),
                new BigDecimal(180)
        );
        assertOrder(expected, order);
    }

    @Test
    void threeForTwoAndOverHundred() {
        Product product = new Product(1, new BigDecimal(500));
        List<Product> products = List.of(product, product, product);

        Order order = productsToOrderProcessor.process(products);

        Order expected = new Order(
                new BigDecimal(1500),
                new BigDecimal(500),
                new BigDecimal(100),
                new BigDecimal(900)
        );
        assertOrder(expected, order);
    }

    void assertOrder(Order expected, Order actual) {
        assertThat(actual.productsPriceSumBeforeDiscounts()).isEqualByComparingTo(expected.productsPriceSumBeforeDiscounts());
        assertThat(actual.itemDiscounts()).isEqualByComparingTo(expected.itemDiscounts());
        assertThat(actual.totalDiscounts()).isEqualByComparingTo(expected.totalDiscounts());
        assertThat(actual.totalSumAfterDiscounts()).isEqualByComparingTo(expected.totalSumAfterDiscounts());
    }
}