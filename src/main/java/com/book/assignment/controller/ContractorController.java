package com.book.assignment.controller;

import com.book.assignment.model.dto.book.BookResponse;
import com.book.assignment.model.dto.supply.SupplyBookSearchCriteria;
import com.book.assignment.model.dto.supply.SupplyResponse;
import com.book.assignment.service.ContractorService;
import com.book.assignment.service.SupplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "계약 업체, 공급 도서 API")
@RestController
@RequestMapping("/api/v1/contractors")
public class ContractorController {

    @Autowired
    private ContractorService contractorService;

    @Autowired
    private SupplyService supplyService;

    @GetMapping
    @ApiOperation(value = "업체 목록 조회", notes = "")
    public ResponseEntity getList(@PageableDefault Pageable pageable) {

        return ResponseEntity.ok(contractorService.getList(pageable));
    }

    @GetMapping("/{contractorId}/supplies/books")
    @ApiOperation(value = "계약 업체별 공급된 도서 조회")
    public ResponseEntity getSuppliedBooksByContractor(@PathVariable Long contractorId,
                                                       @PageableDefault Pageable pageable) {

        Page<BookResponse> supplyBooks = contractorService.getSuppliedBooks(contractorId, pageable);

        return ResponseEntity.ok(supplyBooks);
    }

    @GetMapping("/supplies/books")
    @ApiOperation(value = "공급된 도서 중 특정 저자가 쓴 도서를 조회")
    public ResponseEntity getSupplyBooks(
            @RequestParam(value = "author", required = false) String author,
            @PageableDefault Pageable pageable) {

        Page<BookResponse> supplyBooks = supplyService.getSuppliedBooks(
                SupplyBookSearchCriteria.builder()
                        .author(author)
                        .build(),
                pageable);

        return ResponseEntity.ok(supplyBooks);
    }

    @GetMapping("/supplies")
    @ApiOperation(value = "공급 도서 목록 조회(공급 내역, 도서 상세 내역 포함) ")
    public ResponseEntity getSupplies(
            @PageableDefault Pageable pageable) {

        Page<SupplyResponse> supplyBooksPage = supplyService.getAll(pageable);

        return ResponseEntity.ok(supplyBooksPage);
    }

    @GetMapping("/supplies/{supplyId}")
    @ApiOperation(value = "공급 도서 상세 조회(공급 내역, 도서 상세 내역 포함) ")
    public ResponseEntity getSupplies(@PathVariable Long supplyId) {

        SupplyResponse supplyResponse = supplyService.get(supplyId);

        return ResponseEntity.ok(supplyResponse);
    }
}
