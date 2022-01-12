package com.book.assignment.model.mapper;

import com.book.assignment.model.dto.book.ContractorResponse;
import com.book.assignment.model.dto.contractor.ContractorCreationRequest;
import com.book.assignment.model.dto.supply.SupplyCreationRequest;
import com.book.assignment.model.dto.supply.SupplyResponse;
import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.entity.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface SupplyMapper {

    SupplyMapper INSTANCE = Mappers.getMapper(SupplyMapper.class);

    Supply dtoToEntity(SupplyCreationRequest supplyCreationRequest);

    SupplyResponse entityToDto(Supply contractor);
}