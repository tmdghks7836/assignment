package com.book.assignment.service;

import com.book.assignment.model.dto.book.ContractorResponse;
import com.book.assignment.model.dto.contractor.ContractorCreationRequest;
import com.book.assignment.model.dto.supply.SupplyCreationRequest;
import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.entity.Supply;
import com.book.assignment.model.mapper.ContractorMapper;
import com.book.assignment.model.mapper.SupplyMapper;
import com.book.assignment.repository.ContractorRepository;
import com.book.assignment.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SupplyService {

    @Autowired
    private SupplyRepository supplyRepository;

    /**
     * @return supply id
     */
    @Transactional
    public long create(SupplyCreationRequest supplyCreationRequest) {

        Supply supply = SupplyMapper.INSTANCE.dtoToEntity(supplyCreationRequest);

        supplyRepository.save(supply);

        return supply.getId();
    }
}
