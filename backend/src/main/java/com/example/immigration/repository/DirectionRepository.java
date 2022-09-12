package com.example.immigration.repository;

import com.example.immigration.model.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends JpaRepository<Direction,Integer> {
}
