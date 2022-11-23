package com.ust.claims.api.claims;

import lombok.Data;
@Data
public class ClaimsDto {
    private int claimId;
    private int patientId;
    private int hospitalId;
    private int policyId;
    private int treatmentId;
    private int specialistId;
    private int capableAmount;
}
