package com.example.immigration.service;

import com.example.immigration.dto.CountByLicense;
import com.example.immigration.dto.CountByNationality;
import com.example.immigration.dto.CountByPurpose;
import com.example.immigration.dto.CountIdentityCardName;
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

    //Thong tin xuat nhap canh theo loai giay to
    @Override
    public List<ImmigrationInformation> getImmigrationInforByCardName(String typeOfCardName) {
        return immigrationRepository.ImmigrationInformationByCardName(typeOfCardName);
    }

    //Thống kê lượt xnc trong ngày theo loại giấy tờ
    @Override
    public List<CountIdentityCardName> countIdentityCardNameOnDay() {
        Date date = new  java.util.Date();
        List<CountIdentityCardName> countIdentityCardNames = immigrationRepository.countIdentityCardNameOnDay();
        List<CountIdentityCardName> countIdentityCardNamesOnDay = new ArrayList<>();
        Date finalDate = date;

        countIdentityCardNames.forEach(i->{
            if(i.getStartDate().getDate() == finalDate.getDate()
                    && i.getStartDate().getMonth() == finalDate.getMonth()
                    && i.getStartDate().getYear() == finalDate.getYear()){
                countIdentityCardNamesOnDay.add(i);
            }
        });
        return countIdentityCardNamesOnDay;
    }

    //Thống kê lượt xnc form ngày to ngày theo loại giấy tờ
    @Override
    public List<CountIdentityCardName> countIdentityCardName(String name, Date startDate, Date endDate) {
        return immigrationRepository.countIdentityCardName(name, startDate, endDate);
    }

    //Thống kê lượt xnc form ngày to ngày theo quốc tịch
    @Override
    public List<CountByNationality> countByNationality(String name, Date startDate, Date endDate) {
        return immigrationRepository.countByNationality(name, startDate, endDate);
    }
    //Thống kê lượt xnc form ngày to ngày theo loại giấy phép
    @Override
    public List<CountByLicense> countByLicense(String name, Date startDate, Date endDate) {
        return immigrationRepository.countByLicense(name, startDate, endDate);
    }
    //Thống kê lượt xnc form ngày to ngày theo mục đích
    @Override
    public List<CountByPurpose> countByPurpose(String name, Date startDate, Date endDate) {
        return immigrationRepository.countByPurpose(name, startDate, endDate);
    }

    //Thong tin xuat nhap canh trong ngày theo loai giay to
    @Override
    public List<ImmigrationInformation> getImmigrationInforOnDayByCarName(String typeOfCardName) {
        Date date = new  java.util.Date();
        List<ImmigrationInformation> immigrations = immigrationRepository.ImmigrationInformationByCardName(typeOfCardName);
        List<ImmigrationInformation> immigrationsOnDay = new ArrayList<>();
        Date finalDate = date;
        immigrations.forEach(i->{
            if(i.getStartDate().getDate() == finalDate.getDate()
                    && i.getStartDate().getMonth() == finalDate.getMonth()
                    && i.getStartDate().getYear() == finalDate.getYear()){
                immigrationsOnDay.add(i);
            }
        });
        return immigrationsOnDay;
    }

    //Thông tin xuât nhập cảnh theo quốc tịch
    @Override
    public List<ImmigrationInformation> ImmigrationInformationByNationality(String nationality) {
        return immigrationRepository.ImmigrationInformationByNationality(nationality);
    }

    //Thông tin xuất nhập cảnh trong ngày theo quốc tịch
    @Override
    public List<ImmigrationInformation> ImmigrationInforOnDayByNationality(String nationality) {
        Date date = new  java.util.Date();
        List<ImmigrationInformation> immigrations = immigrationRepository.ImmigrationInformationByNationality(nationality);
        List<ImmigrationInformation> immigrationsOnDay = new ArrayList<>();
        Date finalDate = date;
        immigrations.forEach(i->{
            if(     i.getStartDate().getDate() == finalDate.getDate()
                    && i.getStartDate().getMonth() == finalDate.getMonth()
                    && i.getStartDate().getYear() == finalDate.getYear()){
                immigrationsOnDay.add(i);
            }
        });
        return immigrationsOnDay;
    }

    //Thông tin xuất nhập cảnh theo loại giấy phép
    @Override
    public List<ImmigrationInformation> ImmigrationInformationByTypeOfLicense(String typeOfLicense) {
        return immigrationRepository.ImmigrationInformationByTypeOfLicense(typeOfLicense);
    }

    //Thông tin xuất nhập cảnh trong ngày theo loại giấy phép
    @Override
    public List<ImmigrationInformation> ImmigrationInforOnDayByTypeOfLicense(String typeOfLicense) {
        Date date = new java.util.Date();
        List<ImmigrationInformation> immigrations = immigrationRepository.ImmigrationInformationByTypeOfLicense(typeOfLicense);
        List<ImmigrationInformation> immigrationsOnDay = new ArrayList<>();
        Date finalDate = date;
        immigrations.forEach(i -> {
            if (i.getStartDate().getDate() == finalDate.getDate()
                    && i.getStartDate().getMonth() == finalDate.getMonth()
                    && i.getStartDate().getYear() == finalDate.getYear()) {
                immigrationsOnDay.add(i);
            }
        });
        return immigrationsOnDay;
    }

    //Thông tin xuất nhập cảnh theo mục đích
    @Override
    public List<ImmigrationInformation> ImmigrationInformationByPurpose(String purposeName) {
        return immigrationRepository.ImmigrationInformationByPurpose(purposeName);
    }

    //Thông tin xuất nhập cảnh trong ngày theo mục đích
    @Override
    public List<ImmigrationInformation> ImmigrationInforOnDayByPurpose(String purposeName) {
        Date date = new java.util.Date();
        List<ImmigrationInformation> immigrations = immigrationRepository.ImmigrationInformationByPurpose(purposeName);
        List<ImmigrationInformation> immigrationsOnDay = new ArrayList<>();
        Date finalDate = date;
        immigrations.forEach(i -> {
            if (i.getStartDate().getDate() == finalDate.getDate()
                    && i.getStartDate().getMonth() == finalDate.getMonth()
                    && i.getStartDate().getYear() == finalDate.getYear()) {
                immigrationsOnDay.add(i);
            }
        });
        return immigrationsOnDay;
    }

    //Thông tin xuất nhập chảnh theo chiều
    @Override
    public List<ImmigrationInformation> ImmigrationInformationByDirection(String direction) {
        return immigrationRepository.ImmigrationInformationByDirection(direction);
    }


}
