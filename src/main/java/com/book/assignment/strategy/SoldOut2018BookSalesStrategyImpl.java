package com.book.assignment.strategy;

import com.book.assignment.model.entity.Book;
import com.book.assignment.model.type.SalesStatus;

/**
 * 발행 된지 2018년 이전 책은 절판
 */
public class SoldOut2018BookSalesStrategyImpl implements BookSalesStrategy {

    @Override
    public SalesStatus getSalesStatus(Book book) {

        if (book.getIssueDate().getYear() < 2018) {

            return SalesStatus.SOLD_OUT;
        }

        return SalesStatus.PROCEEDING;
    }
}
