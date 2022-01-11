package com.book.assignment.repository;

import com.book.assignment.model.entity.SupplyBookMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<SupplyBookMap, Long> {

}
