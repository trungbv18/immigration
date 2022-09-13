package com.example.immigration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Identitycard {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "number_of_identitycard")
    private String numberOfIdentitycard;
    @Basic
    @Column(name = "place_of_issue")
    private String placeOfIssue;

    @Basic
    @Column(name = "date_of_expiry")
    private Date dateOfExpiry;

    @OneToMany(mappedBy = "identitycardByIdentirycardId")
    @JsonIgnore
    private Collection<ImmigrationInformation> immigrationInformationsById;
    @OneToMany(mappedBy = "identitycardByIdentirycardId")
    @JsonIgnore
    private Collection<Ban> bansById;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private TypeofIdentitycard typeofIdentitycardByTypeId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customerByCustomerId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNumberOfIdentitycard() {
        return numberOfIdentitycard;
    }

    public void setNumberOfIdentitycard(String numberOfIdentitycard) {
        this.numberOfIdentitycard = numberOfIdentitycard;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }


    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identitycard that = (Identitycard) o;

        if (id != that.id) return false;

        if (numberOfIdentitycard != null ? !numberOfIdentitycard.equals(that.numberOfIdentitycard) : that.numberOfIdentitycard != null)
            return false;
        if (placeOfIssue != null ? !placeOfIssue.equals(that.placeOfIssue) : that.placeOfIssue != null) return false;

        if (dateOfExpiry != null ? !dateOfExpiry.equals(that.dateOfExpiry) : that.dateOfExpiry != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));

        result = 31 * result + (numberOfIdentitycard != null ? numberOfIdentitycard.hashCode() : 0);
        result = 31 * result + (placeOfIssue != null ? placeOfIssue.hashCode() : 0);

        result = 31 * result + (dateOfExpiry != null ? dateOfExpiry.hashCode() : 0);

        return result;
    }

    public Collection<ImmigrationInformation> getImmigrationInformationsById() {
        return immigrationInformationsById;
    }

    public void setImmigrationInformationsById(Collection<ImmigrationInformation> immigrationInformationsById) {
        this.immigrationInformationsById = immigrationInformationsById;
    }

    public Collection<Ban> getBansById() {
        return bansById;
    }

    public void setBansById(Collection<Ban> bansById) {
        this.bansById = bansById;
    }

    public TypeofIdentitycard getTypeofIdentitycardByTypeId() {
        return typeofIdentitycardByTypeId;
    }

    public void setTypeofIdentitycardByTypeId(TypeofIdentitycard typeofIdentitycardByTypeId) {
        this.typeofIdentitycardByTypeId = typeofIdentitycardByTypeId;
    }

    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
