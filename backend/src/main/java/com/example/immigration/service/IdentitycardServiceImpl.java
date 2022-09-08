package com.example.immigration.service;

import com.example.immigration.model.Identitycard;
import com.example.immigration.repository.IdentitycardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentitycardServiceImpl implements IdentitycardService{
    @Autowired
    IdentitycardRepository identitycardRepository;

    @Override
    public List<Identitycard> findAll() {
        return identitycardRepository.findAll();
    }

    @Override
    public void save(Identitycard identitycard) {
        identitycardRepository.save(identitycard);
    }

    @Override
    public Optional<Identitycard> findById(Long id) {
        return identitycardRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        identitycardRepository.deleteById(id);
    }

    @Override
    public Long getLastId() {
        return identitycardRepository.selectLastId();

    }
}
