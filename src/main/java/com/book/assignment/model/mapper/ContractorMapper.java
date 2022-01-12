package com.book.assignment.model.mapper;

import com.book.assignment.model.dto.book.BookCreationRequest;
import com.book.assignment.model.dto.book.BookResponse;
import com.book.assignment.model.dto.book.ContractorResponse;
import com.book.assignment.model.dto.contractor.ContractorCreationRequest;
import com.book.assignment.model.entity.Book;
import com.book.assignment.model.entity.Contractor;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface ContractorMapper {

    ContractorMapper INSTANCE = Mappers.getMapper(ContractorMapper.class);

    Contractor dtoToEntity(ContractorCreationRequest contractorCreationRequest);

    ContractorResponse entityToDto(Contractor contractor);
}