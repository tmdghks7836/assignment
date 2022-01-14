package com.book.assignment.model.dto.supply;

import com.book.assignment.model.dto.book.BookDetailResponse;
import com.book.assignment.model.entity.Book;
import com.book.assignment.model.entity.Supply;
import com.book.assignment.model.mapper.BookMapper;
import com.book.assignment.model.type.SalesStatus;
import com.book.assignment.strategy.BookDiscountStrategy;
import com.book.assignment.strategy.BookSalesStrategy;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 공급 내역, 도서 상세 내역 포함 response
 */
@Data
public class SupplyResponse {

    private Long supplyId;

    //공급 일자
    private LocalDateTime supplyDateTime;

    private List<BookDetailResponse> books;

    public SupplyResponse(Supply supply,
                          BookDiscountStrategy bookDiscountStrategy,
                          BookSalesStrategy bookSalesStrategy) {


        this.supplyId = supply.getId();
        this.supplyDateTime = supply.getSupplyDateTime();
        this.books = supply.getSupplyBookMaps().stream()
                .map(supplyBookMap -> {

                    Book book = supplyBookMap.getBook();
                    long discountPrice = bookDiscountStrategy.calculation(book);
                    SalesStatus salesStatus = bookSalesStrategy.getSalesStatus(book);

                    return BookMapper.INSTANCE.entityToDetailDto(book, discountPrice, salesStatus);
                })
                .collect(Collectors.toList());
    }
}