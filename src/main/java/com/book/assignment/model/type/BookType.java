package com.book.assignment.model.type;

import lombok.Getter;

@Getter
public enum BookType {

    GUN("000", "총류"),
    PHILOSOPHY("100", "철학"),
    RELIGION("200", "종교"),
    SOCIAL_SCIENCE("300", "사회과학"),
    NATURAL_SCIENCE("400", "자연과학"),
    TECHNOLOGY_SCIENCE("500", "기술과학"),
    ART("600", "예술"),
    LANGUAGE("700", "언어"),
    LITERATURE("800", "문학"),
    HISTORY("900", "역사");

    private String code;

    private String desc;

    BookType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
