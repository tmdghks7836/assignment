package com.book.assignment.model.mapper;

import com.book.assignment.model.dto.book.ContractorResponse;
import com.book.assignment.model.dto.supply.SupplyCreationRequest;
import com.book.assignment.model.dto.supply.SupplyResponse;
import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.entity.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface SupplyMapper {

    SupplyMapper INSTANCE = Mappers.getMapper(SupplyMapper.class);

    @Mapping(ignore = true, target = "supplyBookMaps")
    @Mapping(ignore = true, target = "contractor")
    Supply dtoToEntity(SupplyCreationRequest supplyCreationRequest);

    @Mapping(source = "contractor", target = "contractor", qualifiedByName = "qualifiedContractor")
    SupplyResponse entityToDto(Supply supply);

    @Named("qualifiedContractor")
    default ContractorResponse qualifiedThumbnail(Contractor contractor) {

        return ContractorMapper.INSTANCE.entityToDto(contractor);
    }
}