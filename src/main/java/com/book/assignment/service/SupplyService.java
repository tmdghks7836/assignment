package com.book.assignment.service;

import com.book.assignment.exception.ResourceNotFoundException;
import com.book.assignment.model.dto.book.BookResponse;
import com.book.assignment.model.dto.supply.SimpleSupplyResponse;
import com.book.assignment.model.dto.supply.SupplyBookSearchCriteria;
import com.book.assignment.model.dto.supply.SupplyResponse;
import com.book.assignment.model.entity.Book;
import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.entity.Supply;
import com.book.assignment.model.entity.SupplyBookMap;
import com.book.assignment.model.mapper.BookMapper;
import com.book.assignment.model.mapper.SupplyMapper;
import com.book.assignment.repository.BookRepository;
import com.book.assignment.repository.ContractorRepository;
import com.book.assignment.repository.SupplyBookMapRepository;
import com.book.assignment.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 업체 공급 관련 서비스
 */
@Service
@Transactional(readOnly = true)
public class SupplyService {

    @Autowired
    private SupplyRepository supplyRepository;

    @Autowired
    private SupplyBookMapRepository supplyBookMapRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ContractorRepository contractorRepository;

    /**
     * @return supply id
     */
    @Transactional
    public long create(Contractor contractor, LocalDateTime supplyDateTime) {

        Supply supply = new Supply(contractor, supplyDateTime);

        supplyRepository.save(supply);

        return supply.getId();
    }

    public List<SimpleSupplyResponse> getAllByContractorId(Long contractorId) {

        Contractor contractor = contractorRepository.findById(contractorId).orElseThrow(() ->
                new ResourceNotFoundException());

        List<Supply> supplies = supplyRepository.findAllByContractor(contractor);

        return supplies.stream()
                .map(supply -> SupplyMapper.INSTANCE.entityToSimpleDto(supply)).collect(Collectors.toList());
    }

    /**
     * 도서 공급
     *
     * @return supplyBookMap id
     */
    @Transactional
    public long supplyBook(Long supplyId, Long bookId) {

        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new ResourceNotFoundException(
                        new StringBuilder("book Id가 ").append(bookId).append(" 입니다.").toString()
                ));

        Supply supply = supplyRepository.findById(supplyId).orElseThrow(() ->
                new ResourceNotFoundException(
                        new StringBuilder("supply Id가 ").append(supplyId).append(" 입니다.").toString()
                ));

        SupplyBookMap supplyBookMap = new SupplyBookMap(supply, book);
        supplyBookMapRepository.save(supplyBookMap);

        return supplyBookMap.getId();
    }

    /**
     * 업체별 공급된 도서 조회
     */
    public Page<BookResponse> getSuppliedBooks(SupplyBookSearchCriteria condition, Pageable pageable) {

        Page<Book> bookPage = supplyBookMapRepository.findSupplyBooks(condition, pageable);

        return bookPage.map(book -> BookMapper.INSTANCE.entityToDto(book));
    }

    public Page<SupplyResponse> getAll(Pageable pageable) {

        Page<Supply> supplies = supplyRepository.findAll(pageable);

        return supplies.map(supply -> new SupplyResponse(supply));
    }

    public SupplyResponse get(Long supplyId) {

        Supply supply = supplyRepository.findByIdWithFetchJoin(supplyId).orElseThrow(() ->
                new ResourceNotFoundException());

        return new SupplyResponse(supply);
    }
}
