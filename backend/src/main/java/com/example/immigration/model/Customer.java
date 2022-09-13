package com.example.immigration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "gender")
    private Integer gender;
    @Basic
    @Column(name = "nationality")
    private String nationality;
    @Basic
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "customerByCustomerId")
    @JsonIgnore
    private Collection<ImmigrationInformation> immigrationInformationsById;

    @OneToMany(mappedBy = "customerByCustomerId")
    @JsonIgnore
    private Collection<Identitycard> identitycardsById;

    @OneToMany(mappedBy = "customerByCustomerId")
    @JsonIgnore
    private Collection<License> licensesById;

}
