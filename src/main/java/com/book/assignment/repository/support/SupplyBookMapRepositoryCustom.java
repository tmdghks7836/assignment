package com.book.assignment.repository.support;

import com.book.assignment.model.dto.book.BookResponse;

import java.util.List;

public interface SupplyBookMapRepositoryCustom {

    List<BookResponse> findSupplyBooksByContractor(Long contractorId);

    List<BookResponse> findBooksByAuthor(String author);
}
