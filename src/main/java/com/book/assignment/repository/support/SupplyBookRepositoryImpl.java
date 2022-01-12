package com.book.assignment.repository.support;//package com.jwt.radis.repository;

import com.book.assignment.model.dto.book.BookResponse;
import com.book.assignment.model.entity.Book;
import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.entity.QBook;
import com.book.assignment.model.entity.QContractor;
import com.book.assignment.model.entity.QSupply;
import com.book.assignment.model.entity.QSupplyBookMap;
import com.book.assignment.model.entity.SupplyBookMap;
import com.book.assignment.model.mapper.BookMapper;
import com.book.assignment.repository.ContractorRepositoryCustom;
import com.book.assignment.repository.SupplyBookMapRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.book.assignment.model.entity.QContractor.contractor;
import static org.springframework.util.StringUtils.isEmpty;

@Repository
public class SupplyBookRepositoryImpl extends QuerydslRepositorySupportBasic implements SupplyBookMapRepositoryCustom {

    private final QSupplyBookMap qSupplyBookMap = QSupplyBookMap.supplyBookMap;

    public SupplyBookRepositoryImpl() {
        super(SupplyBookMap.class);

    }

    public List<BookResponse> findSupplyBooksByContractor(Long contractorId) {

        List<Book> books = getQueryFactory()
                .select(QBook.book)
                .from(qSupplyBookMap)
                .innerJoin(qSupplyBookMap.book)
                .innerJoin(qSupplyBookMap.supply)
                .innerJoin(qSupplyBookMap.supply.contractor)
                .on(qSupplyBookMap.supply.contractor.id.eq(contractorId))
                .fetch();

        return books.stream().map(book -> BookMapper.INSTANCE.entityToDto(book)).collect(Collectors.toList());
    }


    private BooleanExpression contractorIdEq(Long contractorId) {
        return isEmpty(contractorId) ? null : contractor.id.eq(contractorId);
    }


}
