package com.book.assignment.model.dto.supply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplyCreationRequest {

    private LocalDateTime supplyDateTime;
}