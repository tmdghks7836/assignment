package com.book.assignment.controller;

import com.book.assignment.service.ContractorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contractor")
public class ContractorController {

    @Autowired
    private ContractorService contractorService;

    @GetMapping
    @ApiOperation(value = "업체 정보 조회", notes = "")
    public ResponseEntity getList(@PageableDefault Pageable pageable) {

        return ResponseEntity.ok(contractorService.getList(pageable));
    }
}
