package com.example.immigration.controller;

import com.example.immigration.model.TypeofIdentitycard;
import com.example.immigration.service.TypeofIdentitycardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/typeofIdentityCard")
@CrossOrigin(value = "*", maxAge = 3600)

public class TypeofIdentitycardController {
    @Autowired
    TypeofIdentitycardService typeofIdentitycardService;

    @GetMapping("/get-all")
    public ResponseEntity<List<TypeofIdentitycard>> getAll() {
        List<TypeofIdentitycard> typeofIdentitycardLists = typeofIdentitycardService.findAll();

        return new ResponseEntity<>(typeofIdentitycardLists, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<TypeofIdentitycard> save(@Valid
            @RequestBody TypeofIdentitycard typeofIdentitycard
    ) {
        try {
            typeofIdentitycardService.save(typeofIdentitycard);
            return ResponseEntity.ok(typeofIdentitycard);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TypeofIdentitycard> update(@Valid
            @PathVariable("id") Long id,
            @RequestBody TypeofIdentitycard typeofIdentitycard
    ) {
        Optional<TypeofIdentitycard> typeofIdentitycardOptional = typeofIdentitycardService.findById(id);
        if(typeofIdentitycardOptional.isPresent()){
            typeofIdentitycardOptional.get().setIdentitycardsById(typeofIdentitycard.getIdentitycardsById());
            typeofIdentitycardOptional.get().setDescription(typeofIdentitycard.getDescription());
            typeofIdentitycardOptional.get().setName(typeofIdentitycard.getName());
            return ResponseEntity.ok(typeofIdentitycardOptional.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<TypeofIdentitycard> delete(
            @PathVariable("id") Long id
    ) {
        Optional<TypeofIdentitycard> typeofIdentitycardOptional = typeofIdentitycardService.findById(id);

        if(typeofIdentitycardOptional.isPresent()) {
            typeofIdentitycardService.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
