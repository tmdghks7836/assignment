package com.book.assignment.controller;

import com.book.assignment.service.ContractorService;
import com.book.assignment.service.SupplyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/supply-books")
public class SupplyBooksController {

    @Autowired
    private SupplyService supplyService;

    @GetMapping(value = "/supply-books")
    @ApiOperation(value = "계약 업체별 공급된 도서 조회")
    public ResponseEntity get(@RequestParam(value = "author", required = false) String author,
                              @PageableDefault Pageable pageable) {

        return ResponseEntity.ok(supplyService.getSupplyBooksByAuthor(author));
    }
}
