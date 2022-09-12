package com.example.immigration.repository;

import com.example.immigration.model.Identitycard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IdentitycardRepository extends JpaRepository<Identitycard, Long> {
    @Query(value = "SELECT id FROM Identitycard ORDER BY id DESC LIMIT 1;", nativeQuery = true)
    Long selectLastId();
}


