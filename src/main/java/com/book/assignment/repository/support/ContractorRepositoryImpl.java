package com.book.assignment.repository.support;//package com.jwt.radis.repository;

import com.book.assignment.model.entity.Contractor;
import org.springframework.stereotype.Repository;

@Repository
public class ContractorRepositoryImpl extends QuerydslRepositorySupportBasic {

    public ContractorRepositoryImpl() {
        super(Contractor.class);
    }
}
