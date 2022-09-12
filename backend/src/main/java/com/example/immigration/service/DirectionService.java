package com.example.immigration.service;

import com.example.immigration.model.Direction;
import com.example.immigration.model.TypeOfLicense;

import java.util.List;
import java.util.Optional;

public interface DirectionService {
    List<Direction> findAll();

    void save(Direction Direction);

    Optional<Direction> findById(Integer id);

    void deleteById(Integer id);

}
