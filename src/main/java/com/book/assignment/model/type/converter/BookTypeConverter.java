package com.book.assignment.model.type.converter;

import com.book.assignment.model.type.BookType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class BookTypeConverter implements AttributeConverter<BookType, String> {

    @Override
    public String convertToDatabaseColumn(BookType bookType) {
        return bookType.getCode();
    }

    @Override
    public BookType convertToEntityAttribute(String code) {
        return Stream.of(BookType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}