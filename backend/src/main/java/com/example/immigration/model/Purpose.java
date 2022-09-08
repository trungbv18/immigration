package com.example.immigration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "purpose")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purpose {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    @NotBlank(message = "name is mandatory")
    private String name;
    @Basic
    @Column(name = "description")
    @NotBlank(message = "description is mandatory")
    private String description;
    @OneToMany(mappedBy = "purposeByPurposeId")
    @JsonIgnore
    private Collection<ImmigrationInformation> immigrationInformationsById;

}
