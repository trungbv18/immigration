package com.example.immigration.repository;

import com.example.immigration.model.Ban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BanRepository extends JpaRepository<Ban, Long> {
//    @Query(value = "select id from Ban b where b.idenNumber = ?1", nativeQuery = true)
//    Long findIdenNum(String idenNumber);
    @Query("SELECT b.id FROM Ban b WHERE b.idenNumber = :idenNumber")
    Long findIdenNum( @Param("idenNumber" ) String idenNumber
      );
}
