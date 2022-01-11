package com.jwt.radis.repository;

import com.jwt.radis.model.entity.SupplyBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<SupplyBook, Long> {

}
