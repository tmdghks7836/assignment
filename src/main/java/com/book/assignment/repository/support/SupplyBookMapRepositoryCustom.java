package com.book.assignment.repository.support;

import com.book.assignment.model.dto.book.BookResponse;
import com.book.assignment.model.dto.supply.SupplyBookSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplyBookMapRepositoryCustom {

    Page<BookResponse> findSupplyBooks(SupplyBookSearchCondition condition, Pageable pageable);
}
