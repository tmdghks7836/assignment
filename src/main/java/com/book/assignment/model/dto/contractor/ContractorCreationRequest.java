package com.book.assignment.model.dto.contractor;

import com.book.assignment.model.type.ContractStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractorCreationRequest {

    //계약 일자
    private LocalDateTime contractDateTime;

    // 최저가 비율
    private Float lowestPriceRatio;

    //상태 코드
    private ContractStatus contractStatus;
}