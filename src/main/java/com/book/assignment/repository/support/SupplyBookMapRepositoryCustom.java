package com.book.assignment.repository.support;

import com.book.assignment.model.dto.supply.SupplyBookSearchCondition;
import com.book.assignment.model.entity.Book;
import com.book.assignment.model.entity.Supply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplyBookMapRepositoryCustom {

    Page<Book> findSupplyBooks(SupplyBookSearchCondition condition, Pageable pageable);

    Page<Supply> findSupplies(Pageable pageable);
}
