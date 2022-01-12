package com.book.assignment.model.dto.book;

import com.book.assignment.model.type.ContractStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractorResponse {

    private Long id;

    //계약 일자
    private LocalDateTime contractDateTime;

    // 최저가 비율
    private Float lowestPriceRatio;

    //상태 코드
    private ContractStatus statusCode;
}