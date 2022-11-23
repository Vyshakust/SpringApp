package com.ust.claims.api.hospital;

import com.ust.claims.api.patient.Patient;
import com.ust.claims.api.treatment.Treatment;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "hospital_details")
public class Hospital {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int hospitalId;
    private String hospitalName;
    private String hospitalLocation;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private boolean status;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "hospital")
    private Set<Patient> patientList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "hospital")
    private Set<Treatment> treatmentList;
}