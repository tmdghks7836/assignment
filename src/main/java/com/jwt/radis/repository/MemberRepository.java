package com.jwt.radis.repository;

import com.jwt.radis.model.entity.SupplyBookMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<SupplyBookMap, Long> {

}
