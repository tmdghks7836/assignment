package com.book.assignment.strategy;

import com.book.assignment.model.Product;

public class BookDiscountStrategyImpl implements BookDiscountStrategy {

    @Override
    public long calculation(Product product) {

        long discountPrice = (long) (product.getSupplyPrice() * (product.getDiscountRate() / 100));
        return product.getSupplyPrice() - discountPrice;
    }
}
