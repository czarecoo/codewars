package org.czareg.codewars.product.discount;

import lombok.experimental.UtilityClass;
import org.czareg.codewars.product.discount.discounts.item.ItemDiscount;
import org.czareg.codewars.product.discount.discounts.item.ItemDiscountCalculator;
import org.czareg.codewars.product.discount.discounts.item.ThreeForTwoItemDiscount;
import org.czareg.codewars.product.discount.discounts.total.PercentOffTotalDiscount;
import org.czareg.codewars.product.discount.discounts.total.TotalDiscount;
import org.czareg.codewars.product.discount.discounts.total.TotalDiscountCalculator;

import java.util.List;

@UtilityClass
public class ProductsToOrderProcessorFactory {

    public static ProductsToOrderProcessor create() {
        List<ItemDiscount> itemDiscounts = List.of(new ThreeForTwoItemDiscount());
        ItemDiscountCalculator itemDiscountCalculator = new ItemDiscountCalculator(itemDiscounts);
        List<TotalDiscount> totalDiscounts = List.of(new PercentOffTotalDiscount());
        TotalDiscountCalculator totalDiscountCalculator = new TotalDiscountCalculator(totalDiscounts);
        return new ProductsToOrderProcessor(itemDiscountCalculator, totalDiscountCalculator);
    }
}
