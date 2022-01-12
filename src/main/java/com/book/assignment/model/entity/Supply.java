package com.book.assignment.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 공급
 * */
@Entity
@Table(name = "supply")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supply_id")
    private Long id;

    //공급 일자
    @Column(name = "supply_date_time")
    private LocalDateTime supplyDateTime;

    @JsonManagedReference
    @OneToMany(mappedBy = "supply", fetch = FetchType.LAZY)
    private List<SupplyBookMap> supplyBookMaps;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

    public Supply(Contractor contractor, LocalDateTime supplyDateTime) {

        this.contractor = contractor;
        this.supplyDateTime = supplyDateTime;
    }


}
