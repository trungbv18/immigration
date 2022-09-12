package com.example.immigration.service;

import com.example.immigration.model.Users;

import java.util.List;

public interface UserService {
    List<Users> getAll();
    void add(Users user);
    Long getLastId();


}
