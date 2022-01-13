package com.book.assignment.repository;

import com.book.assignment.model.entity.Contractor;
import com.book.assignment.repository.support.custom.ContractorRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<Contractor, Long>, ContractorRepositoryCustom {

}
