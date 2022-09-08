package com.example.immigration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Table(name = "direction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Direction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    @NotEmpty(message = "name is mandatory")
    private String name;
    @OneToMany(mappedBy = "directionByDirectionId")
    @JsonIgnore
    private Collection<ImmigrationInformation> immigrationInformationsById;

}

