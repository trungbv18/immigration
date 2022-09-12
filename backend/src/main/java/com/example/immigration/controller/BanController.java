package com.example.immigration.controller;

import com.example.immigration.model.Ban;
import com.example.immigration.service.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ban")
@CrossOrigin(value = "*", maxAge = 3600)

public class BanController {
    @Autowired
    BanService banService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Ban>> getAll() {
        List<Ban> banLists = banService.findAll();

        return new ResponseEntity<>(banLists, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Ban> save(@Valid
            @RequestBody Ban ban
    ) {
        try {
            banService.save(ban);
            return ResponseEntity.ok(ban);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ban> update(@Valid
            @PathVariable("id") Long id,
            @RequestBody Ban newBan
    ) {
        Optional<Ban> ban = banService.findById(id);
        if(ban.isPresent()){
            ban.get().setEffectFrom(newBan.getEffectFrom());
            ban.get().setExpireDate(newBan.getExpireDate());
            ban.get().setIdentitycardByIdentirycardId(newBan.getIdentitycardByIdentirycardId());
//            ban.get().setId(id);
            banService.save(ban.get());
            return ResponseEntity.ok(ban.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Ban> delete(
            @PathVariable("id") Long id
    ) {
        Optional<Ban> ban = banService.findById(id);

        if(ban.isPresent()) {
            banService.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
