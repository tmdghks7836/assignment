package com.book.assignment.model.dto.supply;

import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.entity.SupplyBookMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplyCreationRequest {

    private LocalDateTime dateTime;

    private List<SupplyBookMap> supplyBookMaps;

    private Contractor contractor;
}