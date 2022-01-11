//package com.jwt.radis.service;
//
//import com.jwt.radis.exception.AssignmentRuntimeException;
//import com.jwt.radis.exception.ErrorCode;
//import com.jwt.radis.model.dto.AuthenticationRequest;
//import com.jwt.radis.model.dto.MemberCreationRequest;
//import com.jwt.radis.model.dto.MemberResponse;
//import com.jwt.radis.model.entity.SupplyBookMap;
//import com.jwt.radis.model.mapper.MemberMapper;
//import com.jwt.radis.repository.MemberRepositorySupport;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@Service
//public class MemberService {
//
//    @Autowired
//    private MemberRepositorySupport memberRepositorySupport;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public MemberResponse signIn(AuthenticationRequest authenticationRequest) {
//
//        Optional<SupplyBookMap> memberOptional = memberRepositorySupport.findByUsername(authenticationRequest.getUsername());
//
//        if (!memberOptional.isPresent()) {
//            throw new AssignmentRuntimeException(ErrorCode.RESOURCE_NOT_FOUND);
//        }
//
//        SupplyBookMap supplyBookMap = memberOptional.get();
//
//        if (!bCryptPasswordEncoder.matches(authenticationRequest.getPassword(), supplyBookMap.getPassword())) {
//            throw new AssignmentRuntimeException(ErrorCode.NOT_MATCHED_PASSWORD);
//        }
//
//        return MemberMapper.INSTANCE.modelToDto(supplyBookMap);
//
//    }
//
//    @Transactional
//    public void signUp(MemberCreationRequest memberCreationRequest) {
//
//        SupplyBookMap supplyBookMap = new SupplyBookMap(
//                memberCreationRequest.getUsername(),
//                bCryptPasswordEncoder.encode(memberCreationRequest.getPassword())
//        );
//
//        memberRepositorySupport.save(supplyBookMap);
//    }
//
//    public MemberResponse getById(Long id){
//
//        SupplyBookMap supplyBookMap = memberRepositorySupport.findById(id)
//                .orElseThrow(() ->
//                        new AssignmentRuntimeException(ErrorCode.RESOURCE_NOT_FOUND));
//
//        return MemberMapper.INSTANCE.modelToDto(supplyBookMap);
//    }
//}
