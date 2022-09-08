package com.example.immigration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Table(name = "typeof_identitycard")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeofIdentitycard {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    @NotEmpty(message = "name is mandatory")
    private String name;
    @Basic
    @Column(name = "description")
    @NotEmpty(message = "description is mandatory")
    private String description;
    @OneToMany(mappedBy = "typeofIdentitycardByTypeId")
    @JsonIgnore
    private Collection<Identitycard> identitycardsById;

}
