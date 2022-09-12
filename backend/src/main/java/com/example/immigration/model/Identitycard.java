package com.example.immigration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "identitycard")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Identitycard {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "number_of_identitycard")
    @NotBlank(message = "Identity card number is mandatory")
    @Size(min = 12, max = 12, message = "ID number must be 12 digits")
    private String numberOfIdentitycard;
    @Basic
    @Column(name = "place_of_issue")
    @NotBlank(message = " Place Of Issue is mandatory")
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
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users usersByUserId;

}
