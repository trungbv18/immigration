package com.example.immigration.repository;


import com.example.immigration.dto.CountByLicense;
import com.example.immigration.dto.CountByNationality;
import com.example.immigration.dto.CountByPurpose;
import com.example.immigration.dto.CountIdentityCardName;
import com.example.immigration.model.ImmigrationInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ImmigrationInformationRepository extends JpaRepository<ImmigrationInformation,Long> {

    //Thông tin xuất nhập cảnh  theo loại giấy tờ
    @Query(value = "select i from ImmigrationInformation  i inner join Identitycard ic " +
            "on i.identitycardByIdentirycardId.id = ic.id inner join TypeofIdentitycard tIc " +
            "on ic.typeofIdentitycardByTypeId.id = tIc.id where tIc.name = ?1 ")
    List<ImmigrationInformation> ImmigrationInformationByCardName(String typeOfCardName);

    //Thông tin xuất nhập cảnh theo quốc tịch
    @Query(value = "select i from ImmigrationInformation i inner join Users u " +
            "on u.id = i.usersByUserId.id where u.nationality = ?1")
    List<ImmigrationInformation> ImmigrationInformationByNationality(String nationality);

    //Thông tin xuất nhập cảnh theo loại giấy phép
    @Query(value = "select  i from ImmigrationInformation i inner join License l " +
            "on i.licenseByLicenseId.id = l.id inner join TypeOfLicense tl " +
            "on l.typeOfLicenseByTypeId.id = tl.id where tl.name = ?1")
    List<ImmigrationInformation> ImmigrationInformationByTypeOfLicense(String typeOfLicense);

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

    //Thống kê lượt xnc trong ngày theo loại giấy tờ
    @Query("select new com.example.immigration.dto.CountIdentityCardName (ii.startDate, d.name, ti.name, count(ti.name))" +
            "from ImmigrationInformation ii inner join Identitycard i on ii.identityCardId = i.id " +
            "inner join TypeofIdentitycard ti on i.typeOfIdentityCardId = ti.id " +
            "inner join Direction d on ii.directionId = d.id group by ii.startDate, d.name, ti.name")
    List<CountIdentityCardName> countIdentityCardNameOnDay();

    //Thống kê lượt xnc form ngày to ngày theo loại giấy tờ
    @Query("select new com.example.immigration.dto.CountIdentityCardName (ii.startDate, d.name, ti.name, count(ti.name))" +
            "from ImmigrationInformation ii inner join Identitycard i on ii.identityCardId = i.id " +
            "inner join TypeofIdentitycard ti on i.typeOfIdentityCardId = ti.id " +
            "inner join Direction d on ii.directionId = d.id where d.name=:direction and ti.name=:name AND ii.startDate BETWEEN :start AND :end  group by ii.startDate, d.name, ti.name")
    List<CountIdentityCardName> countIdentityCardName(@Param("direction") String direction,  @Param("name") String name,
                                                      @Param("start") Date startDate, @Param("end") Date endDate);

    //Thống kê lượt xnc form ngày to ngày theo quốc tịch
    @Query("select new com.example.immigration.dto.CountByNationality (ii.startDate, d.name, u.nationality, count(u.nationality))" +
            "from ImmigrationInformation ii inner join Users u on ii.userId = u.id " +
            "inner join Direction d on ii.directionId = d.id where d.name=:direction and d.name=:direction and u.nationality=:name AND ii.startDate BETWEEN :start AND :end  group by ii.startDate, d.name, u.nationality")
    List<CountByNationality> countByNationality(@Param("direction") String direction, @Param("name") String name,
                                                @Param("start") Date startDate, @Param("end") Date endDate);

    //Thống kê lượt xnc form ngày to ngày theo loại giấy phép
    @Query("select new com.example.immigration.dto.CountByLicense (ii.startDate, d.name, tl.name, count(tl.name))" +
            "from ImmigrationInformation ii inner join License l on ii.licenseId = l.id inner join TypeOfLicense tl on l.typeId = tl.id" +
            " inner join Direction d on ii.directionId = d.id where d.name=:direction and d.name=:direction and tl.name=:name AND ii.startDate BETWEEN :start AND :end  group by ii.startDate, d.name, tl.name")
    List<CountByLicense> countByLicense(@Param("direction") String direction, @Param("name") String name,
                                        @Param("start") Date startDate, @Param("end") Date endDate);

    //Thống kê lượt xnc form ngày to ngày theo mục đích
    @Query("select new com.example.immigration.dto.CountByPurpose (ii.startDate, d.name, p.name, count(p.name))" +
            "from ImmigrationInformation ii inner join Purpose p on ii.purposeId = p.id " +
            "inner join Direction d on ii.directionId = d.id where d.name=:direction and p.name=:name AND ii.startDate BETWEEN :start AND :end  group by ii.startDate, d.name, p.name")
    List<CountByPurpose> countByPurpose(@Param("direction") String direction, @Param("name") String name,
                                        @Param("start") Date startDate, @Param("end") Date endDate);

}
