package com.example.immigration.controller;

import com.example.immigration.model.License;
import com.example.immigration.service.LicenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/license")
@CrossOrigin(value = "*", maxAge = 3600)

public class LicenseController {
    @Autowired
    LicenseServiceImpl licenseService;

    @GetMapping()
    public ResponseEntity<List<License>> getAllLicense(){
        List<License> licenses = licenseService.getAllLicense();
        return new ResponseEntity<>(licenses, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<License> addLicense(@RequestBody License license){
        return new ResponseEntity<>(licenseService.saveLicense(license),HttpStatus.OK) ;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<License> updateLicense(@RequestBody License license,@PathVariable("id") Long id ){
        if(licenseService.getLicenseById(id).isPresent()){
            licenseService.updateLicense(license,id);
            return ResponseEntity.ok(license);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public Object deleteLicense(@PathVariable("id") Long id){
        if(licenseService.getLicenseById(id).isPresent()){
            licenseService.deleteLicenseById(id);
            return ResponseEntity.ok("Deleted license with id = "+id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/last-id")
    public ResponseEntity<Long> getLastId(){
        Long id = licenseService.getLastId();
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }


}
