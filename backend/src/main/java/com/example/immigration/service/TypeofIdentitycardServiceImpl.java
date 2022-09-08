package com.example.immigration.service;

import com.example.immigration.model.TypeofIdentitycard;
import com.example.immigration.repository.TypeofIdentitycardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeofIdentitycardServiceImpl implements TypeofIdentitycardService{
    @Autowired
    TypeofIdentitycardRepository typeofIdentitycardRepository;

    @Override
    public List<TypeofIdentitycard> findAll() {
        return typeofIdentitycardRepository.findAll();
    }

    @Override
    public void save(TypeofIdentitycard typeofIdentitycard) {
        typeofIdentitycardRepository.save(typeofIdentitycard);
    }

    @Override
    public Optional<TypeofIdentitycard> findById(Long id) {
        return typeofIdentitycardRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
    typeofIdentitycardRepository.deleteById(id);
    }
}
