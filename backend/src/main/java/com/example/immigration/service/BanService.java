package com.example.immigration.service;

import com.example.immigration.model.Ban;

import java.util.List;
import java.util.Optional;

public interface BanService {
    List<Ban> findAll();

    void save(Ban ban);

    Optional<Ban> findById(Long id);

    void deleteById(Long id);
    Long findIdenNum(String iden);
}
