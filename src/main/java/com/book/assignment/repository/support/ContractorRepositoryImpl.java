package com.book.assignment.repository.support;//package com.jwt.radis.repository;

import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.entity.Supply;
import com.book.assignment.repository.support.custom.ContractorRepositoryCustom;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.book.assignment.model.entity.QContractor.contractor;
import static org.springframework.util.StringUtils.isEmpty;

@Repository
public class ContractorRepositoryImpl extends QuerydslRepositorySupportBasic implements ContractorRepositoryCustom {

    public ContractorRepositoryImpl() {
        super(Contractor.class);
    }
}
