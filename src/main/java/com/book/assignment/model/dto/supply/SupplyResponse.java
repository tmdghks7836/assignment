package com.book.assignment.model.dto.supply;

import com.book.assignment.model.dto.book.ContractorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyResponse {

    private Long id;

    //공급 일자
    private LocalDateTime supplyDateTime;

    private ContractorResponse contractor;
}