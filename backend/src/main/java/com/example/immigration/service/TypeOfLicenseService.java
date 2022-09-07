package com.example.immigration.service;

import com.example.immigration.model.TypeOfLicense;

import java.util.List;
import java.util.Optional;

public interface TypeOfLicenseService {
    TypeOfLicense saveTypeOfLicense(TypeOfLicense type);

    void deleteTypeOfLicenseById(Integer id);
    List<TypeOfLicense> getAllTypeOfLicense();
    Optional<TypeOfLicense> getTypeOfLicenseById(Integer id);
}
