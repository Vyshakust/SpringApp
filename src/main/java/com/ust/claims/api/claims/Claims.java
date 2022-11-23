package com.ust.claims.api.claims;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "claims_details")
public class Claims {
    @Id
    private int claimId;
    private int patientId;
    private int hospitalId;
    private int policyId;
    private int treatmentId;
    private int specialistId;
    private int capableAmount;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private boolean status;
}
