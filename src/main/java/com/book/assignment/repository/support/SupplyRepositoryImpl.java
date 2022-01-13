package com.book.assignment.repository.support;//package com.jwt.radis.repository;

import com.book.assignment.model.entity.QSupply;
import com.book.assignment.model.entity.QSupplyBookMap;
import com.book.assignment.model.entity.Supply;
import com.book.assignment.repository.support.custom.SupplyRepositoryCustom;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

@Repository
public class SupplyRepositoryImpl extends QuerydslRepositorySupportBasic implements SupplyRepositoryCustom {

    private final QSupply qSupply = QSupply.supply;
    private final QSupplyBookMap qSupplyBookMap = QSupplyBookMap.supplyBookMap;

    public SupplyRepositoryImpl() {
        super(Supply.class);
    }

    @Override
    public Optional<Supply> findByIdWithFetchJoin(Long supplyId) {

        Supply supply = getQueryFactory()
                .selectFrom(qSupply)
                .innerJoin(qSupply.supplyBookMaps, qSupplyBookMap).fetchJoin()
                .innerJoin(qSupplyBookMap.book).fetchJoin()
                .where(
                        supplyIdEq(supplyId)
                )
                .distinct()
                .fetchOne();

        return Optional.ofNullable(supply);
    }

    private BooleanExpression supplyIdEq(Long supplyId) {
        return isEmpty(supplyId) ? null : qSupply.id.eq(supplyId);
    }
}
