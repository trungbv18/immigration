package com.example.immigration.service;

import com.example.immigration.model.License;

import java.util.List;
import java.util.Optional;

public interface LicenseService {
    List<License> getAllLicense();

    License saveLicense(License license);

    License updateLicense(License license, Long id);

    void deleteLicenseById(Long id);

    Optional<License> getLicenseById(Long id);
}
