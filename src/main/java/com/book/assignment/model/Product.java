package com.book.assignment.model;

import java.time.LocalDateTime;

public interface Product {

    //수량
    Long getAmount();

    //공급단가
    Long getSupplyPrice();

    //발행일자
    LocalDateTime getIssueDate();

    //정가
    Long getRegularPrice();

    //적용할인율
    Float getDiscountRate();
}
