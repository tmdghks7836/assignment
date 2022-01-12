package com.book.assignment.service;

import com.book.assignment.exception.CustomRuntimeException;
import com.book.assignment.exception.ErrorCode;
import com.book.assignment.exception.ResourceNotFoundException;
import com.book.assignment.model.dto.book.ContractorResponse;
import com.book.assignment.model.dto.contractor.ContractorCreationRequest;
import com.book.assignment.model.entity.Contractor;
import com.book.assignment.model.mapper.ContractorMapper;
import com.book.assignment.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ContractorService {

    @Autowired
    private ContractorRepository contractorRepository;

    /**
     * @return contractor id
     */
    @Transactional
    public long create(ContractorCreationRequest contractorCreationRequest) {

        Contractor contractor = ContractorMapper.INSTANCE.dtoToEntity(contractorCreationRequest);

        contractorRepository.save(contractor);

        return contractor.getId();
    }

    public Page<ContractorResponse> getList(Pageable pageable) {
        Page<Contractor> contractors = contractorRepository.findAll(pageable);

        return contractors.map(contractor -> ContractorMapper.INSTANCE.entityToDto(contractor));
    }

    public ContractorResponse get(Long contractorId) {
        Contractor contractor = contractorRepository.findById(contractorId).orElseThrow(() ->
                new ResourceNotFoundException());

        return ContractorMapper.INSTANCE.entityToDto(contractor);
    }
}
