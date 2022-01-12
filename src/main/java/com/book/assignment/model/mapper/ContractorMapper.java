package com.book.assignment.model.mapper;

import com.book.assignment.model.dto.book.ContractorResponse;
import com.book.assignment.model.dto.contractor.ContractorCreationRequest;
import com.book.assignment.model.entity.Contractor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface ContractorMapper {

    ContractorMapper INSTANCE = Mappers.getMapper(ContractorMapper.class);

    @Mapping(ignore = true, target = "supplies")
    Contractor dtoToEntity(ContractorCreationRequest contractorCreationRequest);

    ContractorResponse entityToDto(Contractor contractor);
}