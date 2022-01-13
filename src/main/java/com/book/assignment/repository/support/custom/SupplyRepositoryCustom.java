package com.book.assignment.repository.support.custom;

import com.book.assignment.model.entity.Supply;

import java.util.Optional;

public interface SupplyRepositoryCustom {

    Optional<Supply> findByIdWithFetchJoin(Long supplyId);
}
