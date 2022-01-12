package com.book.assignment.model.entity;

import com.book.assignment.model.type.ContractStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 계약 업체
 */
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
    @Column(name = "CONTRACT_DATE")
    private LocalDateTime contractDateTime;

    // 최저가 비율
    @Column(name = "lowest_price_ratio")
    private Float lowestPriceRatio;

    //상태 코드
    @Column(name = "status_code")
    private ContractStatus statusCode;

    @JsonManagedReference
    @OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY)
    private List<Supply> supplies;

    public Contractor(LocalDateTime contractDateTime, Float lowestPriceRatio, ContractStatus contractStatus) {

        this.statusCode = contractStatus;
        this.lowestPriceRatio = lowestPriceRatio;
        this.contractDateTime = contractDateTime;
    }
}
