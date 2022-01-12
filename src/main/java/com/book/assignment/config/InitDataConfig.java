package com.book.assignment.config;

import com.book.assignment.model.dto.book.BookCreationRequest;
import com.book.assignment.model.dto.book.ContractorResponse;
import com.book.assignment.model.dto.contractor.ContractorCreationRequest;
import com.book.assignment.model.dto.supply.SupplyCreationRequest;
import com.book.assignment.model.entity.Supply;
import com.book.assignment.model.type.BookType;
import com.book.assignment.model.type.ContractStatus;
import com.book.assignment.service.BookService;
import com.book.assignment.service.ContractorService;
import com.book.assignment.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * create test data
 */
@Configuration
@RequiredArgsConstructor
public class InitDataConfig {

    private final BookService bookService;

    private final ContractorService contractorService;

    @PostConstruct
    public void init() {

        for (int i = 0; i < 5; i++) {

            //계약업체 생성
            long contractorId = contractorService.create(
                    ContractorCreationRequest.builder()
                            .contractDateTime(LocalDateTime.now().plusDays(i))
                            .lowestPriceRatio(1f * i)
                            .contractStatus(ContractStatus.values()[i % 3])
                            .build()
            );

            ContractorResponse contractorResponse = contractorService.get(contractorId);

            for (int j = 0; j < 5; j++) {

                contractorService.createSupply(
                        contractorResponse.getId(),
                        SupplyCreationRequest.builder()
                                .supplyDateTime(LocalDateTime.now().plusDays(i))
                                .build());
            }





        }

    }

    private void


}
