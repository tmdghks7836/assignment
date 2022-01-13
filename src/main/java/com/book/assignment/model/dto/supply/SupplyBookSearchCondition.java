package com.book.assignment.model.dto.supply;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupplyBookSearchCondition {

    private Long contractorId;
    private String author;
}