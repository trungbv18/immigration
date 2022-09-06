package com.example.immigration.service;

import com.example.immigration.model.Ban;
import com.example.immigration.model.TypeofIdentitycard;

import java.util.List;
import java.util.Optional;

public interface TypeofIdentitycardService {
    List<TypeofIdentitycard> findAll();

    void save(TypeofIdentitycard typeofIdentitycard);

    Optional<TypeofIdentitycard> findById(Long id);

    void deleteById(Long id);
}
