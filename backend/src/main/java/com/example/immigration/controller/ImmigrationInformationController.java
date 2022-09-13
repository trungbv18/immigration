package com.example.immigration.controller;

import com.example.immigration.model.ImmigrationInformation;
import com.example.immigration.service.ImmigrationInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/immigrationInformation")
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
    @GetMapping("/count/identitycard/{identitycard}")
    public ResponseEntity<Long> getImmigrationInforByCardName(@PathVariable("identitycard") String typeOfCardName){
        Long immigrations = immigrationInformationService.countImmigrationByCardName(typeOfCardName);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh trong ngày theo loại giấy tờ
    @GetMapping("/count/byday/identitycard/{identitycard}")
    public ResponseEntity<Integer> getImmigrationInforOnDayByCarName(@PathVariable("identitycard") String typeOfCardName,
                                                                     @RequestParam(value = "from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
                                                                     @RequestParam(value = "to") @DateTimeFormat(pattern="yyyy-MM-dd") Date to){
        Integer immigrations = immigrationInformationService.getImmigrationInforByDayByCardName(typeOfCardName,from,to);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh theo quốc tịch
    @GetMapping("/count/nationality/{nationality}")
    public ResponseEntity<Long> getImmigrationInformationByNationality(@PathVariable("nationality") String nationality){
        Long immigrations = immigrationInformationService.countImmigrationByNationality(nationality);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh theo ngày theo quóc tịch
    @GetMapping("/count/byday/nationality/{nationality}")
    public ResponseEntity<Integer> getImmigrationInforOnDayByNationality(@PathVariable("nationality") String nationality,
                                                                      @RequestParam(value = "from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
                                                                      @RequestParam(value = "to") @DateTimeFormat(pattern="yyyy-MM-dd") Date to){
        Integer immigrations = immigrationInformationService.countImmigrationByDayByNationality(nationality,from,to);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh theo loại giấy phép
    @GetMapping("/count/license/{license}")
    public ResponseEntity<Long> countImmigrationByTypeOfLicense(@PathVariable("license") String license){
        Long immigrations = immigrationInformationService.countImmigrationByTypeOfLicense(license);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh trong ngày theo loại giấy phép
    @GetMapping("/count/byday/liscense/{liscense}")
    public ResponseEntity<Integer> getImmigrationInforOnDayByTypeOfLicense(@PathVariable("license") String license,
                                                                           @RequestParam(value = "from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
                                                                           @RequestParam(value = "to") @DateTimeFormat(pattern="yyyy-MM-dd") Date to){
        Integer immigrations = immigrationInformationService.countImmigrationByDayByTypeOfLicense(license,from,to);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh theo mục đích
    @GetMapping("/count/purpose/{purpose}")
    public ResponseEntity<Long> countImmigrationIByPurpose(@PathVariable("purpose") String purpose){
        Long immigrations = immigrationInformationService.countImmigrationByPurpose(purpose);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh trong ngày theo mục dích
    @GetMapping("/count/byday/purpose/{purpose}")
    public ResponseEntity<Integer> getImmigrationInforOnDayByPurpose(@PathVariable("purpose") String purpose,
                                                                     @RequestParam(value = "from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
                                                                     @RequestParam(value = "to") @DateTimeFormat(pattern="yyyy-MM-dd") Date to
    ){
        Integer immigrations = immigrationInformationService.countImmigrationByDayByPurpose(purpose,from,to);
        return ResponseEntity.ok(immigrations);
    }
    //Thông tin xuất nhập cảnh theo chiều
    @GetMapping("/direction/{direction}")
    public ResponseEntity<List<ImmigrationInformation>> getImmigrationInformationByDirection(@PathVariable("direction") String direction){
        List<ImmigrationInformation> immigrations = immigrationInformationService.ImmigrationByDirection(direction);
        return ResponseEntity.ok(immigrations);
    }

    @GetMapping("/count/direction/{direction}")
    public ResponseEntity<Integer> countImmigrationByDirection(@PathVariable("direction") String direction){
        Integer immigrations = immigrationInformationService.countImmigrationByDirection(direction);
        return ResponseEntity.ok(immigrations);
    }

}
