package com.book.assignment.strategy;

import com.book.assignment.model.entity.Book;
import com.book.assignment.model.type.SalesStatus;

/**
 * 상품 판매 상태 Strategy
 */
public interface BookSalesStrategy {

    SalesStatus getSalesStatus(Book book);
}
