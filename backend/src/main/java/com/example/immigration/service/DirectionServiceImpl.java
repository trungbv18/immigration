package com.example.immigration.service;

import com.example.immigration.model.Direction;
import com.example.immigration.model.TypeOfLicense;
import com.example.immigration.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectionServiceImpl implements DirectionService {
    @Autowired
    DirectionRepository directionRepository;
    @Override
    public List<Direction> findAll() {
        return directionRepository.findAll();
    }

    @Override
    public void save(Direction direction) {
        directionRepository.save(direction);
    }

    @Override
    public Optional<Direction> findById(Integer id) {
        return directionRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        directionRepository.deleteById(id);
    }
}