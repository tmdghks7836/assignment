package com.book.assignment.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "supply", fetch = FetchType.LAZY)
    private List<SupplyBookMap> supplyBookMaps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

    public Supply(Contractor contractor, LocalDateTime dateTime) {

        this.contractor = contractor;
        this.dateTime = dateTime;
    }
}
