package com.example.immigration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "license")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class License {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "license_number")
    @NotBlank(message = "license Number is mandatory")
    private String licenseNumber;
    @Basic
    @Column(name = "issued_on")
    @NotNull(message = " issuedOn Date is mandatory")
    private Date issuedOn;
    @Basic
    @Column(name = "date_of_expiry")
    @NotNull(message = " Date Of Expiry is mandatory")
    private Date dateOfExpiry;
    @Basic
    @Column(name = "place_of_issue")
    @NotBlank(message = "place Of Issue is mandatory")
    private String placeOfIssue;
    @OneToMany(mappedBy = "licenseByLicenseId")
    @JsonIgnore
    private Collection<ImmigrationInformation> immigrationInformationsById;

    // nối với class dto
    @Basic
    @Column(name = "type_id", insertable = false, updatable = false)
    private Long typeId;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "typeId is mandatory")
    private TypeOfLicense typeOfLicenseByTypeId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "UserId is mandatory")
    private Users usersByUserId;
}
