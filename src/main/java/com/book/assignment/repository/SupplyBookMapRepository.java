package com.book.assignment.repository;

import com.book.assignment.model.entity.SupplyBookMap;
import com.book.assignment.repository.support.custom.SupplyBookMapRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyBookMapRepository extends JpaRepository<SupplyBookMap, Long>, SupplyBookMapRepositoryCustom {

}
