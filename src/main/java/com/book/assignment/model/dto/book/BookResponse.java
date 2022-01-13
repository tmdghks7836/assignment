package com.book.assignment.model.dto.book;

import com.book.assignment.model.Product;
import com.book.assignment.model.type.BookType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse implements Product {

    private Long id;

    private String name;

    //도서 구분
    private BookType bookType;

    //수량
    private Long amount;

    //공급단가
    private Long supplyPrice;

    //저자
    private String author;

    //발행일자
    private LocalDateTime issueDate;

    //정가
    private Long regularPrice;

    //적용할인율
    private Float discountRate;

    private Long discountPrice;
}