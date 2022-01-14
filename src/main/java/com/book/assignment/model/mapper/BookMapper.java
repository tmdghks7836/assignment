package com.book.assignment.model.mapper;

import com.book.assignment.model.dto.book.*;
import com.book.assignment.model.entity.Book;
import com.book.assignment.model.entity.Contractor;
import com.book.assignment.utils.TimeUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book dtoToEntity(BookCreationRequest bookCreationRequest);

    BookResponse entityToDto(Book book);

    BookDetailResponse entityToDetailDto(Book book);
}