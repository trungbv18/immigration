package com.example.immigration.service;

import com.example.immigration.model.ImmigrationInformation;
import com.example.immigration.repository.ImmigrationInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ImmigrationInformationServiceImpl implements ImmigrationInformationService{

    @Autowired
    ImmigrationInformationRepository immigrationRepository;

    //Thêm Thông tin xuất nhập cảnh
    @Override
    public ImmigrationInformation saveImmigration(ImmigrationInformation immigration){
        return immigrationRepository.save(immigration);
    }

    //Sửa thông tin xuất nhập cảnh
    @Override
    public ImmigrationInformation updateImmigrationById(ImmigrationInformation newImmigraiton,Long id){
        newImmigraiton.setId(id);
        return immigrationRepository.save(newImmigraiton);
    }

    //Xóa thông tin xuất nhập cảnh
    @Override
    public void DeleteImmigrationById(Long id){
       immigrationRepository.deleteById(id);
    }

    @Override
    public Optional<ImmigrationInformation> getImmigrationById(Long id) {
        return immigrationRepository.findById(id);
    }

    @Override
    public List<ImmigrationInformation> getAllImmigrationInfor() {
        return immigrationRepository.findAll();
    }

    //Thong tin xuat nhap canh theo laoi giay to
    @Override
    public Long countImmigrationByCardName(String typeOfCardName) {
        return immigrationRepository.countImmigrationByCardName(typeOfCardName);
    }

    //Thong ke lượt  xuat nhap canh trong ngày theo laoi giay to
    @Override
    public Integer getImmigrationInforByDayByCardName(String typeOfCardName, Date from, Date to) {
        List<ImmigrationInformation> immigrations = immigrationRepository.ImmigrationByCardName(typeOfCardName);
        List<ImmigrationInformation> immigrationsOnDay = new ArrayList<>();
        immigrations.forEach(i->{
            if(from.compareTo(i.getStartDate())<=0 &&i.getStartDate().compareTo(to)<=0 ){
                immigrationsOnDay.add(i);
            }
        });
        return immigrationsOnDay.size();
    }

    //Thông tin xuât nhập cảnh theo quốc tịch
    @Override
    public Long countImmigrationByNationality(String nationality ) {
        return immigrationRepository.countImmigrationByNationality(nationality);
    }

    //Thông tin xuất nhập cảnh theo ngày theo quốc tịch
    @Override
    public Integer countImmigrationByDayByNationality(String nationality, Date from, Date to) {
        List<ImmigrationInformation> immigrations = immigrationRepository.ImmigrationInformationByNationality(nationality);
        List<ImmigrationInformation> immigrationsByDay = new ArrayList<>();
        immigrations.forEach(i->{
            if(from.compareTo(i.getStartDate())<=0 &&i.getStartDate().compareTo(to)<=0 ){
                immigrationsByDay.add(i);
            }
        });
        return immigrationsByDay.size();
    }

    //Thông tin xuất nhập cảnh theo loại giấy phép
    @Override
    public  Long countImmigrationByTypeOfLicense(String typeOfLicense) {
        return immigrationRepository.countImmigrationByTypeOfLicense(typeOfLicense);
    }

    //Thông tin xuất nhập cảnh theo ngày theo loại giấy phép
    @Override
    public Integer countImmigrationByDayByTypeOfLicense(String typeOfLicense , Date from, Date to) {
        List<ImmigrationInformation> immigrations = immigrationRepository.ImmigrationInformationByTypeOfLicense(typeOfLicense);
        List<ImmigrationInformation> immigrationsByDay = new ArrayList<>();
        immigrations.forEach(i->{
            if(from.compareTo(i.getStartDate())<=0 &&i.getStartDate().compareTo(to)<=0 ){
                immigrationsByDay.add(i);
            }
        });
        return immigrationsByDay.size();
    }

    //Thông tin xuất nhập cảnh theo mục đích
    @Override
    public Long countImmigrationByPurpose(String purposeName) {
        return immigrationRepository.countImmigrationByPurpose(purposeName);
    }

    //Thông tin xuất nhập cảnh theo ngày theo mục đích
    @Override
    public Integer countImmigrationByDayByPurpose(String purposeName,Date from, Date to) {
        Date date = new java.util.Date();
        List<ImmigrationInformation> immigrations = immigrationRepository.ImmigrationInformationByPurpose(purposeName);
        List<ImmigrationInformation> immigrationsByDay = new ArrayList<>();
        immigrations.forEach(i->{
            if(from.compareTo(i.getStartDate())<=0 &&i.getStartDate().compareTo(to)<=0 ){
                immigrationsByDay.add(i);
            }
        });
        return immigrationsByDay.size();
    }

    //Thông tin xuất nhập chảnh theo chiều
    @Override
    public List<ImmigrationInformation> ImmigrationByDirection(String direction) {
        return immigrationRepository.ImmigrationInformationByDirection(direction);
    }

    @Override
    public Integer countImmigrationByDirection(String direction) {
        List<ImmigrationInformation> immigrations = immigrationRepository.ImmigrationInformationByDirection(direction);
        return immigrations.size();
    }


}
