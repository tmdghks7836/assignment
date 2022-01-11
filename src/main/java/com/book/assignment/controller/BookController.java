package com.book.assignment.controller;

import com.book.assignment.model.dto.book.BookCreationRequest;
import com.book.assignment.model.dto.book.BookUpdateRequest;
import com.book.assignment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody BookCreationRequest bookCreationRequest) {

        bookService.create(bookCreationRequest);
    }

    @GetMapping
    public ResponseEntity getList(@PageableDefault Pageable pageable) {

        return ResponseEntity.ok(bookService.getList(pageable));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id,
                       @RequestBody BookUpdateRequest bookUpdateRequest) {

        bookService.update(id, bookUpdateRequest);
    }


}
