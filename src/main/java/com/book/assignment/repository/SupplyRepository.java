package com.book.assignment.repository;

import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.entity.Supply;
import com.book.assignment.repository.support.custom.SupplyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplyRepository extends JpaRepository<Supply, Long>, SupplyRepositoryCustom {

    List<Supply> findAllByContractor(Contractor contractor);
}
