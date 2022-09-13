package com.example.immigration.repository;

import com.example.immigration.model.Identitycard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IdentitycardRepository extends JpaRepository<Identitycard, Long> {
    @Query(value = "SELECT TOP 1 id FROM Identitycard ORDER BY id DESC", nativeQuery = true)
    Long selectLastId();
}


