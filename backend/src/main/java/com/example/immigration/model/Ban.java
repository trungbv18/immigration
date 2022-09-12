package com.example.immigration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name = "ban")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ban {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "effect_from")
    private Date effectFrom;
    @Basic
    @Column(name = "expire_date")
    private Date expireDate;
    @ManyToOne
    @JoinColumn(name = "identirycard_id", referencedColumnName = "id")
    private Identitycard identitycardByIdentirycardId;

}
