package com.example.immigration.repository;

import com.example.immigration.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    @Query(value = "SELECT id FROM Users ORDER BY id DESC LIMIT 1;", nativeQuery = true)
    Long selectLastId();
}