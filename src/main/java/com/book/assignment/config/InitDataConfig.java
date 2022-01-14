package com.book.assignment.config;

import com.book.assignment.model.dto.book.BookCreationRequest;
import com.book.assignment.model.dto.book.BookResponse;
import com.book.assignment.model.dto.book.ContractorResponse;
import com.book.assignment.model.dto.contractor.ContractorCreationRequest;
import com.book.assignment.model.dto.supply.SupplyCreationRequest;
import com.book.assignment.model.dto.supply.SimpleSupplyResponse;
import com.book.assignment.model.type.BookType;
import com.book.assignment.model.type.ContractStatus;
import com.book.assignment.service.BookService;
import com.book.assignment.service.ContractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * create test data
 */
@Configuration
@RequiredArgsConstructor
public class InitDataConfig {

    private final BookService bookService;

    private final ContractorService contractorService;

    private List<BookResponse> bookResponses;

    private List<ContractorResponse> contractors = new ArrayList<>();

    @PostConstruct
    public void init() {

        createContractors();
        createSupply();
        createBooks();

        contractors.stream().forEach(contractorResponse -> {

            List<SimpleSupplyResponse> supplies = contractorService.getSupplies(contractorResponse.getId());

            supplies.stream().forEach(supplyResponse -> {
                createSupplyBookMap(supplyResponse.getId());
            });
        });

    }

    //업체 생성
    private void createContractors() {

        for (int i = 0; i < 3; i++) {

            //계약업체 생성
            long contractorId = contractorService.create(
                    ContractorCreationRequest.builder()
                            .contractDateTime(LocalDateTime.now().plusDays(i))
                            .lowestPriceRatio(1f * i)
                            .contractStatus(ContractStatus.values()[i % 3])
                            .build()
            );

            ContractorResponse contractorResponse = contractorService.get(contractorId);
            contractors.add(contractorResponse);
        }
    }

    //도서 생성
    private void createBooks() {
        AtomicInteger num = new AtomicInteger();
        bookResponses = Arrays.stream(BookType.values()).map(bookType -> {

            int numAndIncrement = num.getAndIncrement();
            BookCreationRequest bookCreationRequest = BookCreationRequest.builder()
                    .amount(10000l)
                    .author("이승환" + numAndIncrement)
                    .bookType(bookType)
                    .discountRate(10f)
                    .issueDate(LocalDateTime.now().withYear(2015 + numAndIncrement))
                    .name(bookType.getDesc() + "책")
                    .regularPrice((long) (Math.random() * 30000))
                    .supplyPrice((long) (Math.random() * 30000))
                    .build();

            long bookId = bookService.create(bookCreationRequest);

            return bookService.get(bookId);

        }).collect(Collectors.toList());

    }

    //업체 공급 생성
    private void createSupply() {

        contractors.forEach(contractorResponse -> {

            for (int i = 0; i < 3; i++) {

                contractorService.createSupply(
                        contractorResponse.getId(),
                        SupplyCreationRequest.builder()
                                .supplyDateTime(LocalDateTime.now().plusDays(i))
                                .build());
            }
        });

    }


    private void createSupplyBookMap(Long supplyId) {

        List<Long> bookIds = bookResponses.stream()
                .map(bookResponse -> bookResponse.getId()).collect(Collectors.toList());

        List<Long> insertBookIds = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Long index = bookIds.get((int) (Math.random() * bookIds.size()));

            if (!insertBookIds.contains(index)) {
                insertBookIds.add(index);
            }
        }


        contractorService.supplyBooks(supplyId, insertBookIds);
    }


}
