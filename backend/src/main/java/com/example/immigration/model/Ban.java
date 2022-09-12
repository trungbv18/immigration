package com.example.immigration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "effectFrom Date is mandatory")
//    @PastOrPresent(message = "effectFrom not found") không nhập được ngày tương lai
    private Date effectFrom;
    @Basic
    @Column(name = "expire_date")
    @NotNull(message = "expire Date is mandatory")
    private Date expireDate;
    @ManyToOne
    @JoinColumn(name = "identirycard_id", referencedColumnName = "id")
    @NotNull(message = "IdentityCardId is mandatory")
    private Identitycard identitycardByIdentirycardId;

}
