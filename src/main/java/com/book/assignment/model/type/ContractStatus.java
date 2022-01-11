package com.book.assignment.model.type;

import lombok.Getter;

@Getter
public enum ContractStatus {

    PENDING("P", "미결"),
    APPROVAL("A", "승인"),
    CANCELLATION("C", "취소");

    private String code;
    private String desc;

    ContractStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
