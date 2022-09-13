package com.example.immigration.repository;

import com.example.immigration.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT TOP 1 id FROM Customer ORDER BY id DESC", nativeQuery = true)
    Long selectLastId();
}
