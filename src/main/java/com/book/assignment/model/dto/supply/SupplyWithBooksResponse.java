package com.book.assignment.model.dto.supply;

import com.book.assignment.model.dto.book.BookResponse;
import com.book.assignment.model.entity.Supply;
import com.book.assignment.model.mapper.BookMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyWithBooksResponse {

    private Long supplyId;

    //공급 일자
    private LocalDateTime supplyDateTime;

    private List<BookResponse> books;

    public SupplyWithBooksResponse(Supply supply) {

        this.supplyId = supply.getId();
        this.supplyDateTime = supply.getSupplyDateTime();
        this.books = supply.getSupplyBookMaps().stream()
                .map(supplyBookMap -> BookMapper.INSTANCE.entityToDto(supplyBookMap.getBook())).collect(Collectors.toList());
    }
}