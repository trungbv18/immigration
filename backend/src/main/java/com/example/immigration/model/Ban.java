package com.example.immigration.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
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
    @Basic
    @Column (name = "iden_number")
    private String idenNumber;

}
