package com.example.immigration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountByLicense {
    private Date startDate;
    private String directionName;
    private String license;
    private Long countByLicense;
}
