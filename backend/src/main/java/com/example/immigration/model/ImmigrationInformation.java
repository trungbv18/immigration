package com.example.immigration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "Immigration_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImmigrationInformation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "destination")
    @NotBlank(message = "destination is mandatory")
    @Size(max = 100, message = "destination should not be longer than 100 characters")
    private String destination;
    @Basic
    @Column(name = "return_date")
    private Date returnDate;

    @Basic
    @Column(name = "start_date")
    @CreationTimestamp
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users usersByUserId;
    @ManyToOne
    @JoinColumn(name = "direction_id", referencedColumnName = "id", nullable = false)
    private Direction directionByDirectionId;
    @ManyToOne
    @JoinColumn(name = "purpose_id", referencedColumnName = "id", nullable = false)
    private Purpose purposeByPurposeId;
    @ManyToOne
    @JoinColumn(name = "identirycard_id", referencedColumnName = "id", nullable = false)
    private Identitycard identitycardByIdentirycardId;
    @ManyToOne
    @JoinColumn(name = "license_id", referencedColumnName = "id", nullable = false)
    private License licenseByLicenseId;

}
