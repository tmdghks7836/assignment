package com.book.assignment.model.entity;

import com.book.assignment.model.dto.book.BookUpdateRequest;
import com.book.assignment.model.type.BookType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", length = 50)
    private Long id;

    //도서명
    @Column(name = "name")
    private String name;

    //도서 구분
    @Column(name = "bookType")
    private BookType bookType;

    //수량
    @Column(name = "amount")
    private Long amount;

    //공급단가
    @Column(name = "supply_price")
    private Long supplyPrice;

    //저자
    @Column(name = "author")
    private String author;

    //발행일자
    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    //정가
    @Column(name = "regular_price")
    private Long regularPrice;

    //적용할인율
    @Column(name = "discount_rate")
    private Float discountRate;

    public Book(String name,
                BookType bookType,
                Long supplyPrice,
                String author,
                LocalDateTime issueDate,
                Long regularPrice,
                Float discountRate) {

        this.name = name;
        this.bookType = bookType;
        this.supplyPrice = supplyPrice;
        this.author = author;
        this.issueDate = issueDate;
        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
    }

    public void update(BookUpdateRequest bookUpdateRequest) {

        this.name = bookUpdateRequest.getName();
        this.bookType = bookUpdateRequest.getBookType();
        this.supplyPrice = bookUpdateRequest.getSupplyPrice();
        this.author = bookUpdateRequest.getAuthor();
        this.issueDate = bookUpdateRequest.getIssueDate();
        this.regularPrice = bookUpdateRequest.getRegularPrice();
        this.discountRate = bookUpdateRequest.getDiscountRate();
    }
}
