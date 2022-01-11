package com.book.assignment.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "supply")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supply_id")
    private Long id;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "supply", fetch = FetchType.LAZY)
    private List<SupplyBookMap> supplyBookMaps;

    public Supply(String username, String password) {
    }
}
