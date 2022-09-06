package com.example.immigration.repository;

import com.example.immigration.model.License;
import com.example.immigration.model.TypeOfLicense;
import com.example.immigration.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends JpaRepository<License,Long> {
    List<License> getAllByUsersByUserId(Users user);
    List<License> getAllByTypeOfLicenseByTypeId(TypeOfLicense type);
}
