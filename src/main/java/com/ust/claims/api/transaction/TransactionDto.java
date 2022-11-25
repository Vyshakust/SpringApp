package com.ust.claims.api.transaction;

import lombok.Data;
@Data
public class TransactionDto {
    private int claimId;
    private int patientId;
    private int hospitalId;
    private int policyId;
    private int treatmentId;
    private int specialistId;
    private int capableAmount;
}
