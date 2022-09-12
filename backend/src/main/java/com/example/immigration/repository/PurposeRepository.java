package com.example.immigration.repository;

import com.example.immigration.model.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurposeRepository extends JpaRepository<Purpose,Long> {
}
