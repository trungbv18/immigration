package com.example.immigration.service;

import com.example.immigration.model.Ban;
import com.example.immigration.repository.BanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BanServiceImpl implements BanService{
    @Autowired
    BanRepository banRepository;

    @Override
    public List<Ban> findAll() {
        return banRepository.findAll();
    }

    @Override
    public void save(Ban ban) {
        banRepository.save(ban);
    }

    @Override
    public Optional<Ban> findById(Long id) {
        return banRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        banRepository.deleteById(id);
    }
}
