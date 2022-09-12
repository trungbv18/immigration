package com.example.immigration.service;


import com.example.immigration.dto.CountByLicense;
import com.example.immigration.dto.CountByNationality;
import com.example.immigration.dto.CountByPurpose;
import com.example.immigration.dto.CountIdentityCardName;
import com.example.immigration.model.ImmigrationInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ImmigrationInformationService {
    List<ImmigrationInformation> getAllImmigrationInfor();

    //Thông tin xuất nhập cảnh  theo loại giấy tờ
    List<ImmigrationInformation> getImmigrationInforByCardName(String typeOfCardName);
    //Thông tin xuất nhập cảnh trong ngày theo loại giấy tờ
    List<ImmigrationInformation> getImmigrationInforOnDayByCarName(String typeOfCardName);

    //Thông tin xuất nhập cảnh theo quốc tịch
    List<ImmigrationInformation> ImmigrationInformationByNationality(String nationality);
    //Thông tin xuất nhập cảnh trong ngày theo quốc tịch
    List<ImmigrationInformation> ImmigrationInforOnDayByNationality(String nationality);

    //Thông tin xuất nhập cảnh theo loại giấy phép
    List<ImmigrationInformation> ImmigrationInformationByTypeOfLicense(String typeOfLicense);
    //Thông tin xuất nhập cảnh trong ngày theo loại giấy phép
    List<ImmigrationInformation> ImmigrationInforOnDayByTypeOfLicense(String typeOfLicense);

    //Thông tin xuất nhập cảnh theo mục đích
    List<ImmigrationInformation> ImmigrationInformationByPurpose(String purposeName);
    //Thông tin xuất nhập cảnh trong ngày theo mục đích
    List<ImmigrationInformation> ImmigrationInforOnDayByPurpose(String purposeName);

    //Thông tin xuất nhập cảnh theo chiều
    List<ImmigrationInformation> ImmigrationInformationByDirection(String direction);

    //Thêm
    ImmigrationInformation saveImmigration(ImmigrationInformation immigration);
    //Sửa
    ImmigrationInformation updateImmigrationById(ImmigrationInformation newImmigraiton,Long id);
    //Xóa
    void DeleteImmigrationById(Long id);

    Optional<ImmigrationInformation> getImmigrationById(Long id);

    //Thống kê lượt xnc trong ngày theo loại giấy tờ
    List<CountIdentityCardName> countIdentityCardNameOnDay();

    //Thống kê lượt xnc form ngày to ngày theo loại giấy tờ
    List<CountIdentityCardName> countIdentityCardName(@Param("name") String name, @Param("start") Date startDate,
                                                      @Param("end") Date endDate);

    //Thống kê lượt xnc form ngày to ngày theo quốc tịch
    List<CountByNationality> countByNationality(@Param("name") String name, @Param("start") Date startDate,
                                                @Param("end") Date endDate);

    //Thống kê lượt xnc form ngày to ngày theo loại giấy phép
    List<CountByLicense> countByLicense(@Param("name") String name, @Param("start") Date startDate, @Param("end") Date endDate);

    //Thống kê lượt xnc form ngày to ngày theo mục đích
    List<CountByPurpose> countByPurpose(@Param("name") String name, @Param("start") Date startDate, @Param("end") Date endDate);
}
