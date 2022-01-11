package com.book.assignment.model.mapper;

import com.book.assignment.model.entity.SupplyBookMap;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);


    SupplyBookMap modelToDto(SupplyBookMap supplyBookMap);


}