package com.example.immigration.repository;


import com.example.immigration.model.ImmigrationInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ImmigrationInformationRepository extends JpaRepository<ImmigrationInformation,Long> {

    //Thống kê lượt xuất nhập cảnh  theo loại giấy tờ
    @Query(value = "select count (i.id) from ImmigrationInformation  i inner join Identitycard ic " +
            "on i.identitycardByIdentirycardId.id = ic.id inner join TypeofIdentitycard tIc " +
            "on ic.typeofIdentitycardByTypeId.id = tIc.id where tIc.name = ?1 ")
    Long countImmigrationByCardName(String typeOfCardName);

    //Thông tin  xuất nhập cảnh  theo loại giấy tờ
    @Query(value = "select i from ImmigrationInformation  i inner join Identitycard ic " +
            "on i.identitycardByIdentirycardId.id = ic.id inner join TypeofIdentitycard tIc " +
            "on ic.typeofIdentitycardByTypeId.id = tIc.id where tIc.name = ?1 ")
    List<ImmigrationInformation> ImmigrationByCardName(String typeOfCardName);

    //Thông tin số lần xuất nhập cảnh theo quốc tịch
    @Query(value = "select count (i.id) from ImmigrationInformation i inner join Users u " +
            "on u.id = i.usersByUserId.id where u.nationality = ?1")
    Long countImmigrationByNationality(String nationality);

    //Thông tin xuất nhập cảnh theo quốc tịch
    @Query(value = "select i from ImmigrationInformation i inner join Users u " +
            "on u.id = i.usersByUserId.id where u.nationality = ?1")
    List<ImmigrationInformation> ImmigrationInformationByNationality(String nationality);

    //Thông tin số lần xuất nhập cảnh theo loại giấy phép
    @Query(value = "select count (i.id) from ImmigrationInformation i inner join License l " +
            "on i.licenseByLicenseId.id = l.id inner join TypeOfLicense tl " +
            "on l.typeOfLicenseByTypeId.id = tl.id where tl.name = ?1")
    Long countImmigrationByTypeOfLicense(String typeOfLicense);

    //Thông tin xuất nhập cảnh theo loại giấy phép
    @Query(value = "select  i from ImmigrationInformation i inner join License l " +
            "on i.licenseByLicenseId.id = l.id inner join TypeOfLicense tl " +
            "on l.typeOfLicenseByTypeId.id = tl.id where tl.name = ?1")
    List<ImmigrationInformation> ImmigrationInformationByTypeOfLicense(String typeOfLicense);

    //Thông tin số lần xuất nhập cảnh theo mục đích
    @Query(value = "select count (i.id) from ImmigrationInformation i inner join Purpose p " +
            "on i.purposeByPurposeId.id = p.id where p.name = ?1")
    Long countImmigrationByPurpose(String purposeName);

    //Thông tin xuất nhập cảnh theo mục đích
    @Query(value = "select i from ImmigrationInformation i inner join Purpose p " +
            "on i.purposeByPurposeId.id = p.id where p.name = ?1")
    List<ImmigrationInformation> ImmigrationInformationByPurpose(String purposeName);



    //Thông tin xuất nhập cảnh theo chiều
    @Query(value = "select i from ImmigrationInformation  i inner join Direction d " +
            "on i.directionByDirectionId.id = d.id where d.name = ?1")
    List<ImmigrationInformation> ImmigrationInformationByDirection(String direction);

    //Lịch sử xuất nhập cảnh của từng người
    @Query(value = "select i from ImmigrationInformation i inner join Users u " +
            "on i.usersByUserId.id = i.id where i.id =?1")
    List<ImmigrationInformation> ImmigrationInformationByUserId(Long userId);

}
