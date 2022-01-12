package com.book.assignment.repository;

import com.book.assignment.model.entity.Contractor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorRepositoryCustom {

    Contractor findSupplyBooksByContractor(Long contractorId);

}
