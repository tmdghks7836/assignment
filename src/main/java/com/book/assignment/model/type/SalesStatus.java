package com.book.assignment.model.type;

import lombok.Getter;

/**
 * 판매 상태 enum
 * */
@Getter
public enum SalesStatus {

    PROCEEDING("판매진행중"),
    SOLD_OUT("절판");

    private String description;

    SalesStatus(String description) {
        this.description = description;
    }
}
