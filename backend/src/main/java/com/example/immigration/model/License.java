package com.example.immigration.model;

import com.example.immigration.Users.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "license")
public class License {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "license_number")
    private String licenseNumber;
    @Basic
    @Column(name = "issued_on")
    private Date issuedOn;
    @Basic
    @Column(name = "date_of_expiry")
    private Date dateOfExpiry;
    @Basic
    @Column(name = "place_of_issue")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(Date issuedOn) {
        this.issuedOn = issuedOn;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        License license = (License) o;

        if (id != license.id) return false;

        if (licenseNumber != null ? !licenseNumber.equals(license.licenseNumber) : license.licenseNumber != null)
            return false;
        if (issuedOn != null ? !issuedOn.equals(license.issuedOn) : license.issuedOn != null) return false;
        if (dateOfExpiry != null ? !dateOfExpiry.equals(license.dateOfExpiry) : license.dateOfExpiry != null)
            return false;
        if (placeOfIssue != null ? !placeOfIssue.equals(license.placeOfIssue) : license.placeOfIssue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        result = 31 * result + (licenseNumber != null ? licenseNumber.hashCode() : 0);
        result = 31 * result + (issuedOn != null ? issuedOn.hashCode() : 0);
        result = 31 * result + (dateOfExpiry != null ? dateOfExpiry.hashCode() : 0);
        result = 31 * result + (placeOfIssue != null ? placeOfIssue.hashCode() : 0);

        return result;
    }

    public Collection<ImmigrationInformation> getImmigrationInformationsById() {
        return immigrationInformationsById;
    }

    public void setImmigrationInformationsById(Collection<ImmigrationInformation> immigrationInformationsById) {
        this.immigrationInformationsById = immigrationInformationsById;
    }

    public TypeOfLicense getTypeOfLicenseByTypeId() {
        return typeOfLicenseByTypeId;
    }

    public void setTypeOfLicenseByTypeId(TypeOfLicense typeOfLicenseByTypeId) {
        this.typeOfLicenseByTypeId = typeOfLicenseByTypeId;
    }

    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
