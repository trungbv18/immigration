package com.example.immigration.service;


import com.example.immigration.model.ImmigrationInformation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ImmigrationInformationService {
    List<ImmigrationInformation> getAllImmigrationInfor();

    //Thông tin xuất nhập cảnh  theo loại giấy tờ
    Long countImmigrationByCardName(String typeOfCardName);
    //Thông tin xuất nhập cảnh trong ngày theo loại giấy tờ
    Integer getImmigrationInforByDayByCardName(String typeOfCardName, Date from, Date to);

    //Thông tin xuất nhập cảnh theo quốc tịch
    Long countImmigrationByNationality(String nationality);
    //Thông tin xuất nhập cảnh trong ngày theo quốc tịch
    Integer countImmigrationByDayByNationality(String nationality,Date from, Date to);

    //Thông tin xuất nhập cảnh theo loại giấy phép
    Long countImmigrationByTypeOfLicense(String typeOfLicense);
    //Thông tin xuất nhập cảnh theo ngày theo loại giấy phép
    Integer countImmigrationByDayByTypeOfLicense(String typeOfLicense ,Date from, Date to);

    //Thông tin xuất nhập cảnh theo mục đích
    Long countImmigrationByPurpose(String purposeName);
    //Thông tin xuất nhập cảnh theo ngày theo mục đích
    Integer countImmigrationByDayByPurpose(String purposeName,Date from, Date to);

    //Thông tin xuất nhập cảnh theo chiều
    List<ImmigrationInformation> ImmigrationByDirection(String direction);

    //Thông tin xuất nhập cảnh theo chiều
    Integer countImmigrationByDirection(String direction);

    //Thêm
    ImmigrationInformation saveImmigration(ImmigrationInformation immigration);
    //Sửa
    ImmigrationInformation updateImmigrationById(ImmigrationInformation newImmigraiton,Long id);
    //Xóa
    void DeleteImmigrationById(Long id);

    Optional<ImmigrationInformation> getImmigrationById(Long id);

}
