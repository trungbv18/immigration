package com.example.immigration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "type_of_license")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOfLicense {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
//    @Basic
    @Column(name = "name")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToMany(mappedBy = "typeOfLicenseByTypeId")
    @JsonIgnore
    private Collection<License> licensesById;

}
