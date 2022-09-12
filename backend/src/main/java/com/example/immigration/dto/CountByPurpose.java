package com.example.immigration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountByPurpose {
    private Date startDate;
    private String directionName;
    private String purpose;
    private Long countByPurpose;
}
