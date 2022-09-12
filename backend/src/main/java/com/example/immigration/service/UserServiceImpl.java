package com.example.immigration.service;

import com.example.immigration.model.Users;
import com.example.immigration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Long getLastId() {
        return userRepository.selectLastId();
    }

    @Override
    public void add(Users user) {
        userRepository.save(user);
    }
}
