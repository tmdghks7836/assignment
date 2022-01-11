package com.book.assignment.model.type.converter;

import com.book.assignment.model.type.ContractStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ContractStatusConverter implements AttributeConverter<ContractStatus, String> {

    @Override
    public String convertToDatabaseColumn(ContractStatus contractStatus) {
        return contractStatus.getCode();
    }

    @Override
    public ContractStatus convertToEntityAttribute(String code) {
        return Stream.of(ContractStatus.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}