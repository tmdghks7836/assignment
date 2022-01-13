package com.book.assignment.strategy;

import com.book.assignment.model.Product;

/**
 * 도서 할인 관련 Strategy
 * */
public interface DiscountStrategy {

    long calculation(Product product);
}
