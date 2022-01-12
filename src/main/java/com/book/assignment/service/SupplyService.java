package com.book.assignment.service;

import com.book.assignment.model.dto.supply.SupplyCreationRequest;
import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.entity.Supply;
import com.book.assignment.model.mapper.SupplyMapper;
import com.book.assignment.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
public class SupplyService {

    @Autowired
    private SupplyRepository supplyRepository;

    /**
     * @return supply id
     */
    @Transactional
    public long create(Contractor contractor, LocalDateTime supplyDateTime) {

        Supply supply = new Supply(contractor, supplyDateTime);

        supplyRepository.save(supply);

        return supply.getId();
    }
}
