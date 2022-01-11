package com.book.assignment.model.entity;

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
    @Column(name = "division")
    private String division;

    //수량
    @Column(name = "amount")
    private String amount;

    //공급단가
    @Column(name = "supply_unit_price")
    private String supplyUnitPrice;

    //저자
    @Column(name = "author")
    private String author;

    //발행일자
    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    //정가
    @Column(name = "regular_price")
    private String regularPrice;

    //적용할인율
    @Column(name = "discount_rate")
    private String discountRate;

    public Book(String name) {

    }
}
