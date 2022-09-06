package com.example.immigration.repository;

import com.example.immigration.model.TypeOfLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfLicenseRepository extends JpaRepository<TypeOfLicense,Integer> {
}
