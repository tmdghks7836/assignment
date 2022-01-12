package com.book.assignment.repository.support;//package com.jwt.radis.repository;

import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.entity.QContractor;
import com.book.assignment.model.entity.QSupply;
import com.book.assignment.repository.ContractorRepositoryCustom;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Repository;

import static com.book.assignment.model.entity.QContractor.contractor;
import static org.springframework.util.StringUtils.isEmpty;

@Repository
public class ContractorRepositoryImpl extends QuerydslRepositorySupportBasic implements ContractorRepositoryCustom {

    public ContractorRepositoryImpl() {
        super(Contractor.class);

    }

//    public Contractor findSupplyBooksByContractor(Long contractorId) {
//
//        Contractor contractor = getQueryFactory()
//                .selectFrom(QContractor.contractor)
//                .leftJoin(QContractor.contractor.supplies).fetchJoin()
//                .leftJoin(QContractor.contractor.supplies, QSupply.supply).fetchJoin()
//                .where(contractorIdEq(contractorId))
//                .fetchOne();
//
//        return contractor;
//    }


    private BooleanExpression contractorIdEq(Long contractorId) {
        return isEmpty(contractorId) ? null : contractor.id.eq(contractorId);
    }


}
