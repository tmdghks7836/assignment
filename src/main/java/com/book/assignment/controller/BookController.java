package com.book.assignment.controller;

import com.book.assignment.model.dto.book.BookCreationRequest;
import com.book.assignment.model.dto.book.BookUpdateRequest;
import com.book.assignment.service.BookService;
import com.book.assignment.service.SupplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "기본 도서 API")
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private SupplyService supplyService;

    @ApiOperation(value = "도서 등록")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody BookCreationRequest bookCreationRequest) {

        bookService.create(bookCreationRequest);
    }

    @ApiOperation(value = "도서 조회")
    @GetMapping
    public ResponseEntity getList(@PageableDefault Pageable pageable) {

        return ResponseEntity.ok(bookService.getList(pageable));
    }

    @ApiOperation(value = "도서 수정")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id,
                       @RequestBody BookUpdateRequest bookUpdateRequest) {

        bookService.update(id, bookUpdateRequest);
    }
}
