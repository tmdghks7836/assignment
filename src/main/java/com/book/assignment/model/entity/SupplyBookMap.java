package com.book.assignment.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "supply_book_map")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SupplyBookMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supply_book_map_id", length = 50)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Supply supply;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    public SupplyBookMap(Supply supply, Book book) {
        this.book = book;
        this.supply = supply;
    }
}
