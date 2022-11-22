package com.ust.claims.api.treatment;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="treatment_details")
public class Treatment {
    @Id
    private int treatmentId;
    private String treatmentName;
    private String treatmentDescription;
    private double treatmentAmount;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private boolean status;
}
