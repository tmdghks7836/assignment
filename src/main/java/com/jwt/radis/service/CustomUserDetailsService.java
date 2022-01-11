//package com.jwt.radis.service;
//
//import com.jwt.radis.model.dto.UserDetailsImpl;
//import com.jwt.radis.model.entity.SupplyBookMap;
//import com.jwt.radis.repository.MemberRepositorySupport;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private MemberRepositorySupport memberRepository;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(final String username) {
//        Optional<SupplyBookMap> memberOptional = memberRepository.findByUsername(username);
//
//        if (!memberOptional.isPresent()) {
//            throw new RuntimeException();
//        }
//
//        SupplyBookMap supplyBookMap = memberOptional.get();
//        return new UserDetailsImpl(supplyBookMap.getId(), supplyBookMap.getUsername());
//    }
//}
