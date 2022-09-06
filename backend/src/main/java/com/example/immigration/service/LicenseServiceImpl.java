package com.example.immigration.service;

import com.example.immigration.model.License;
import com.example.immigration.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseServiceImpl implements LicenseService{
    @Autowired
    LicenseRepository licenseRepository;


    @Override
    public List<License> getAllLicense() {
        return licenseRepository.findAll();
    }

    @Override
    public License saveLicense(License license) {
        return licenseRepository.save(license);
    }

    @Override
    public License updateLicense(License license, Long id) {
        license.setId(id);
        return licenseRepository.save(license);
    }

    @Override
    public void deleteLicenseById(Long id) {
        licenseRepository.deleteById(id);
    }

    @Override
    public Optional<License> getLicenseById(Long id) {
        return licenseRepository.findById(id);
    }


}
