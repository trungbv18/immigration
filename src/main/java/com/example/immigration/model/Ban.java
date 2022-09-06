package com.example.immigration.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEffectFrom() {
        return effectFrom;
    }

    public void setEffectFrom(Date effectFrom) {
        this.effectFrom = effectFrom;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ban ban = (Ban) o;

        if (id != ban.id) return false;
        if (effectFrom != null ? !effectFrom.equals(ban.effectFrom) : ban.effectFrom != null) return false;
        if (expireDate != null ? !expireDate.equals(ban.expireDate) : ban.expireDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (effectFrom != null ? effectFrom.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        return result;
    }

    public Identitycard getIdentitycardByIdentirycardId() {
        return identitycardByIdentirycardId;
    }

    public void setIdentitycardByIdentirycardId(Identitycard identitycardByIdentirycardId) {
        this.identitycardByIdentirycardId = identitycardByIdentirycardId;
    }
}
