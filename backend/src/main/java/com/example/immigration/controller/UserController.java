package com.example.immigration.controller;

import com.example.immigration.model.Users;
import com.example.immigration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin(value = "*", maxAge = 3600)

public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("")
    public ResponseEntity<List<Users>> getAll(){
        List<Users> userList = userService.getAll();
        if (userList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Users>>(userList, HttpStatus.OK);
    }
    @PostMapping("/add")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Users> add (@RequestBody Users user) {
        try {
            userService.add(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/last-id")
    public ResponseEntity<Long> getLastId(){
        Long id = userService.getLastId();
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
}
