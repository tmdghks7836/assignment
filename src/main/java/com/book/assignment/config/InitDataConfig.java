package com.book.assignment.config;

import com.book.assignment.model.dto.contractor.ContractorCreationRequest;
import com.book.assignment.model.type.ContractStatus;
import com.book.assignment.service.BookService;
import com.book.assignment.service.ContractorService;
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

        for (int i = 0; i < 10; i++) {

            contractorService.create(
                    ContractorCreationRequest.builder()
                            .contractDateTime(LocalDateTime.now().plusDays(i))
                            .lowestPriceRatio(1f * i)
                            .contractStatus(ContractStatus.values()[i % 3])
                            .build()
            );
        }

    }


}
