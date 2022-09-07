package com.example.immigration.service;

import com.example.immigration.model.Purpose;

import java.util.Optional;

public interface PurposeService {
    Purpose savePurpose(Purpose purpose);

    Purpose updatePurpose(Purpose purpose, Long id);

    void deletePurposeById(Long id);
    Optional<Purpose> getPurposeById(Long id);
}
