package com.example.immigration.controller;

import com.example.immigration.model.Identitycard;
import com.example.immigration.service.IdentitycardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/identityCard")
@CrossOrigin(value = "*", maxAge = 3600)

public class IdentitycardController {
    @Autowired
    IdentitycardService identitycardService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Identitycard>> getAll() {
        List<Identitycard> identitycardLists = identitycardService.findAll();

        return new ResponseEntity<>(identitycardLists, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Identitycard> save(
            @RequestBody Identitycard identitycard
    ) {
        try {
            identitycardService.save(identitycard);
            return ResponseEntity.ok(identitycard);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Identitycard> update(
            @PathVariable("id") Long id,
            @RequestBody Identitycard identitycard
    ) {
        Optional<Identitycard> identitycardOptional = identitycardService.findById(id);
        if(identitycardOptional.isPresent()){
            identitycardOptional.get().setNumberOfIdentitycard(identitycard.getNumberOfIdentitycard());
            identitycardOptional.get().setBansById(identitycard.getBansById());
            identitycardOptional.get().setTypeofIdentitycardByTypeId(identitycard.getTypeofIdentitycardByTypeId());
            identitycardOptional.get().setDateOfExpiry(identitycard.getDateOfExpiry());
            identitycardOptional.get().setImmigrationInformationsById(identitycard.getImmigrationInformationsById());
            identitycardOptional.get().setPlaceOfIssue(identitycard.getPlaceOfIssue());
            identitycardOptional.get().setCustomerByCustomerId(identitycard.getCustomerByCustomerId());

//            identitycardOptional.get().setId(id);
            return ResponseEntity.ok(identitycardOptional.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Identitycard> delete(
            @PathVariable("id") Long id
    ) {
        Optional<Identitycard> identitycardOptional = identitycardService.findById(id);

        if(identitycardOptional.isPresent()) {
            identitycardService.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
    @GetMapping("/last-id")
    public ResponseEntity<Long> getLastId(){
        Long id = identitycardService.getLastId();
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
}
