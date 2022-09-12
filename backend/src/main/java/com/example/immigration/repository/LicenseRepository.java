package com.example.immigration.repository;

import com.example.immigration.model.Customer;
import com.example.immigration.model.License;
import com.example.immigration.model.TypeOfLicense;
import com.example.immigration.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends JpaRepository<License,Long> {
    List<License> getAllByCustomerByCustomerId(Customer customer);
    List<License> getAllByTypeOfLicenseByTypeId(TypeOfLicense type);
    @Query(value = "SELECT id FROM License ORDER BY id DESC LIMIT 1;", nativeQuery = true)
    Long selectLastId();
}
