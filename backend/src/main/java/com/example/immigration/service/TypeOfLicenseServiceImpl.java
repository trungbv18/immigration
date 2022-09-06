package com.example.immigration.service;

import com.example.immigration.model.TypeOfLicense;
import com.example.immigration.repository.TypeOfLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOfLicenseServiceImpl implements TypeOfLicenseService{
    @Autowired
    TypeOfLicenseRepository typeOfLicenseRepository;


    @Override
    public TypeOfLicense saveTypeOfLicense(TypeOfLicense type) {
        return typeOfLicenseRepository.save(type);
    }

    @Override
    public void deleteTypeOfLicenseById(Integer id) {
        typeOfLicenseRepository.deleteById(id);
    }

    @Override
    public List<TypeOfLicense> getAllTypeOfLicense() {
        return typeOfLicenseRepository.findAll();
    }

    @Override
    public Optional<TypeOfLicense> getTypeOfLicenseById(Integer id) {
        return typeOfLicenseRepository.findById(id);
    }


}
