package com.example.immigration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "license")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class License {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "license_number")
    @NotBlank(message = "licenseNumber is mandatory")
    private String licenseNumber;
    @Basic
    @Column(name = "issued_on")
    private Date issuedOn;
    @Basic
    @Column(name = "date_of_expiry")
    private Date dateOfExpiry;
    @Basic
    @Column(name = "place_of_issue")
    @NotBlank(message = "placeOfIssue is mandatory")
    private String placeOfIssue;
    @OneToMany(mappedBy = "licenseByLicenseId")
    @JsonIgnore
    private Collection<ImmigrationInformation> immigrationInformationsById;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private TypeOfLicense typeOfLicenseByTypeId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users usersByUserId;

}
