package com.book.assignment.repository.support.custom;

import com.book.assignment.model.dto.supply.SupplyBookSearchCriteria;
import com.book.assignment.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplyBookMapRepositoryCustom {

    Page<Book> findSupplyBooks(SupplyBookSearchCriteria condition, Pageable pageable);
}
