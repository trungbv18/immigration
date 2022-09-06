package com.example.immigration.controller;

import com.example.immigration.model.TypeOfLicense;
import com.example.immigration.service.TypeOfLicenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/typeOfLicense")
public class TypeOfLicenseController {
    @Autowired
    TypeOfLicenseServiceImpl typeOfLicenseService;

    @GetMapping
    public ResponseEntity<List<TypeOfLicense>> getAllTypeOfLicense(){
        List<TypeOfLicense> typeOfLicenses = typeOfLicenseService.getAllTypeOfLicense();
        return new ResponseEntity<>(typeOfLicenses, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TypeOfLicense> addTypeOfLicense(@RequestBody TypeOfLicense typeOfLicense){
        return new ResponseEntity<>(typeOfLicenseService.saveTypeOfLicense(typeOfLicense),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public Object deleteLicense(@PathVariable("id") Integer id){
        if(typeOfLicenseService.getTypeOfLicenseById(id).isPresent()){
            typeOfLicenseService.deleteTypeOfLicenseById(id);
            return ResponseEntity.ok("Deleted user with id = "+id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
