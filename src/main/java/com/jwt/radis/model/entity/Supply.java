package com.jwt.radis.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supply")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supply_id")
    private Long id;

    @Column(name = "contract", length = 50, unique = true)
    private String contract;

    public Supply(String username, String password) {
    }
}
