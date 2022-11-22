package com.ust.claims.api.patient;

import com.ust.claims.api.hospital.Hospital;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "patient_details")
public class Patient {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int patientId;
    private String patientName;
    private int patientAge;
    private char patientGender;
    private long patientContactNumber;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
