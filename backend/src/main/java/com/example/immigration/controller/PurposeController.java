package com.example.immigration.controller;

import com.example.immigration.model.Purpose;
import com.example.immigration.service.PurposeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purposes")
public class PurposeController {
    @Autowired
    PurposeServiceImpl purposeService;

    @PostMapping
    public ResponseEntity<Purpose> addPurpose(@RequestBody Purpose purpose){
        return ResponseEntity.ok(purposeService.savePurpose(purpose));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Purpose> updatePurpose(@RequestBody Purpose purpose, @PathVariable("id") Long id){
        if(purposeService.getPurposeById(id).isPresent()){
            purposeService.updatePurpose(purpose,id);
            return ResponseEntity.ok(purpose);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("delete/{id}")
    public Object deletePurpose(@PathVariable("id")Long id){
        if(purposeService.getPurposeById(id).isPresent()){
            purposeService.deletePurposeById(id);
            return ResponseEntity.ok("Deleted purpose with id = "+id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
