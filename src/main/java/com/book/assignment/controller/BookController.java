package com.book.assignment.controller;

import com.book.assignment.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping
    public ResponseEntity create() {

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getList() {

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity update() {

        return ResponseEntity.ok().build();
    }


}
