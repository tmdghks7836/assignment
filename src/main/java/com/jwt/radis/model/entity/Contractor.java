package com.jwt.radis.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "contractor")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contractor {

    //계약 번호
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contractor_id")
    private Long id;

    //계약 일자
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // 최저가 비율
    @Column(name = "lowest_price_ratio")
    private Float lowestPriceRatio;

    //상태 코드
    @Column(name = "status_code")
    private String statusCode;

    public Contractor(Float lowestPriceRatio, String statusCode) {
    }
}
