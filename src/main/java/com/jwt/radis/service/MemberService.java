package com.jwt.radis.service;

import com.jwt.radis.exception.AssignmentRuntimeException;
import com.jwt.radis.exception.ErrorCode;
import com.jwt.radis.model.dto.AuthenticationRequest;
import com.jwt.radis.model.dto.MemberCreationRequest;
import com.jwt.radis.model.dto.MemberResponse;
import com.jwt.radis.model.entity.SupplyBook;
import com.jwt.radis.model.mapper.MemberMapper;
import com.jwt.radis.repository.MemberRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepositorySupport memberRepositorySupport;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberResponse signIn(AuthenticationRequest authenticationRequest) {

        Optional<SupplyBook> memberOptional = memberRepositorySupport.findByUsername(authenticationRequest.getUsername());

        if (!memberOptional.isPresent()) {
            throw new AssignmentRuntimeException(ErrorCode.RESOURCE_NOT_FOUND);
        }

        SupplyBook supplyBook = memberOptional.get();

        if (!bCryptPasswordEncoder.matches(authenticationRequest.getPassword(), supplyBook.getPassword())) {
            throw new AssignmentRuntimeException(ErrorCode.NOT_MATCHED_PASSWORD);
        }

        return MemberMapper.INSTANCE.modelToDto(supplyBook);

    }

    @Transactional
    public void signUp(MemberCreationRequest memberCreationRequest) {

        SupplyBook supplyBook = new SupplyBook(
                memberCreationRequest.getUsername(),
                bCryptPasswordEncoder.encode(memberCreationRequest.getPassword())
        );

        memberRepositorySupport.save(supplyBook);
    }

    public MemberResponse getById(Long id){

        SupplyBook supplyBook = memberRepositorySupport.findById(id)
                .orElseThrow(() ->
                        new AssignmentRuntimeException(ErrorCode.RESOURCE_NOT_FOUND));

        return MemberMapper.INSTANCE.modelToDto(supplyBook);
    }
}
