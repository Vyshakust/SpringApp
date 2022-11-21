package com.ust.claims.api.patient;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PatientDto {
    private int patientId;
    private String patientName;
    private int patientAge;
    private char patientGender;
    private long patientContactNumber;
    private LocalDateTime modifiedDate;
}
