package com.example.immigration.service;

import com.example.immigration.model.Identitycard;

import java.util.List;
import java.util.Optional;

public interface IdentitycardService {
    List<Identitycard> findAll();

    void save(Identitycard identitycard);

    Optional<Identitycard> findById(Long id);

    void deleteById(Long id);
    Long getLastId();

}