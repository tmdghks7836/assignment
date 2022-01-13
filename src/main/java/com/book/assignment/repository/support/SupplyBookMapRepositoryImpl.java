package com.book.assignment.repository.support;//package com.jwt.radis.repository;

import com.book.assignment.model.dto.book.BookResponse;
import com.book.assignment.model.dto.supply.SupplyBookSearchCondition;
import com.book.assignment.model.entity.Book;
import com.book.assignment.model.entity.QSupplyBookMap;
import com.book.assignment.model.entity.SupplyBookMap;
import com.book.assignment.model.mapper.BookMapper;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.isEmpty;

@Repository
public class SupplyBookMapRepositoryImpl extends QuerydslRepositorySupportBasic implements SupplyBookMapRepositoryCustom {

    private final QSupplyBookMap qSupplyBookMap = QSupplyBookMap.supplyBookMap;

    public SupplyBookMapRepositoryImpl() {
        super(SupplyBookMap.class);
    }

    public Page<BookResponse> findSupplyBooks(SupplyBookSearchCondition condition, Pageable pageable) {

        Page<Book> bookPage = applyPagination(pageable, query ->
                query
                        .selectDistinct(qSupplyBookMap.book)
                        .from(qSupplyBookMap)
                        .innerJoin(qSupplyBookMap.book)
                        .innerJoin(qSupplyBookMap.supply)
                        .innerJoin(qSupplyBookMap.supply.contractor)
                        .where(
                                contractorIdEq(condition.getContractorId()),
                                authorContains(condition.getAuthor())
                        ));


        return bookPage.map(book -> BookMapper.INSTANCE.entityToDto(book));
    }

    private BooleanExpression contractorIdEq(Long contractorId) {
        return isEmpty(contractorId) ? null : qSupplyBookMap.supply.contractor.id.eq(contractorId);
    }

    private BooleanExpression authorContains(String author) {
        return isEmpty(author) ? null : qSupplyBookMap.book.author.containsIgnoreCase(author);
    }
}
