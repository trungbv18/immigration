package com.example.immigration.controller;

import com.example.immigration.model.ImmigrationInformation;
import com.example.immigration.service.ImmigrationInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/immigrationInformation")
@CrossOrigin(value = "*", maxAge = 3600)

public class ImmigrationInformationController {
    @Autowired
    ImmigrationInformationServiceImpl immigrationInformationService;

    @PostMapping
    public ResponseEntity<ImmigrationInformation> addImmigrationInformation(@RequestBody ImmigrationInformation immigration){
         immigrationInformationService.saveImmigration(immigration);
         return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ImmigrationInformation> updateImmigration(@PathVariable("id") Long id, @RequestBody ImmigrationInformation immigration){
        if(immigrationInformationService.getImmigrationById(id).isPresent()){
            immigrationInformationService.updateImmigrationById(immigration, id);
            return  ResponseEntity.ok(immigrationInformationService.updateImmigrationById(immigration, id));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteImmigration(@PathVariable("id") Long id){
        if(immigrationInformationService.getImmigrationById(id).isPresent()){
            immigrationInformationService.DeleteImmigrationById(id);
            return ResponseEntity.ok("Deleted Immigration with id = "+id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //Thông tin xuất nhập cảnh theo loại giấy tờ
    @GetMapping("/identitycard/{identitycard}")
    public ResponseEntity<List<ImmigrationInformation>> getImmigrationInforByCardName(@PathVariable("identitycard") String typeOfCardName){
        List<ImmigrationInformation> immigrations = immigrationInformationService.getImmigrationInforByCardName(typeOfCardName);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh trong ngày theo loại giấy tờ
    @GetMapping("/today/identitycard/{identitycard}")
    public ResponseEntity<List<ImmigrationInformation>> getImmigrationInforOnDayByCarName(@PathVariable("identitycard") String typeOfCardName){
        List<ImmigrationInformation> immigrations = immigrationInformationService.getImmigrationInforOnDayByCarName(typeOfCardName);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh theo quốc tịch
    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<ImmigrationInformation>> getImmigrationInformationByNationality(@PathVariable("nationality") String nationality){
        List<ImmigrationInformation> immigrations = immigrationInformationService.ImmigrationInformationByNationality(nationality);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh trong ngày theo quóc tịch
    @GetMapping("/today/nationality/{nationality}")
    public ResponseEntity<List<ImmigrationInformation>> getImmigrationInforOnDayByNationality(@PathVariable("nationality") String nationality){
        List<ImmigrationInformation> immigrations = immigrationInformationService.ImmigrationInforOnDayByNationality(nationality);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh theo loại giấy phép
    @GetMapping("/license/{license}")
    public ResponseEntity<List<ImmigrationInformation>> getImmigrationInformationByTypeOfLicense(@PathVariable("license") String license){
        List<ImmigrationInformation> immigrations = immigrationInformationService.ImmigrationInformationByTypeOfLicense(license);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh trong ngày theo loại giấy phép
    @GetMapping("/today/liscense/{liscense}")
    public ResponseEntity<List<ImmigrationInformation>> getImmigrationInforOnDayByTypeOfLicense(@PathVariable("license") String license){
        List<ImmigrationInformation> immigrations = immigrationInformationService.ImmigrationInforOnDayByTypeOfLicense(license);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh theo mục đích
    @GetMapping("/purpose/{purpose}")
    public ResponseEntity<List<ImmigrationInformation>> getImmigrationInformationByPurpose(@PathVariable("purpose") String purpose){
        List<ImmigrationInformation> immigrations = immigrationInformationService.ImmigrationInformationByPurpose(purpose);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh trong ngày theo mục dích
    @GetMapping("/today/purpose/{purpose}")
    public ResponseEntity<List<ImmigrationInformation>> getImmigrationInforOnDayByPurpose(@PathVariable("purpose") String purpose){
        List<ImmigrationInformation> immigrations = immigrationInformationService.ImmigrationInforOnDayByPurpose(purpose);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh theo chiều
    @GetMapping("/direction/{direction}")
    public ResponseEntity<List<ImmigrationInformation>> getImmigrationInformationByDirection(@PathVariable("direction") String direction){
        List<ImmigrationInformation> immigrations = immigrationInformationService.ImmigrationInformationByDirection(direction);
        return ResponseEntity.ok(immigrations);
    }
}
