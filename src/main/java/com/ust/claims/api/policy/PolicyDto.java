package com.ust.claims.api.policy;

import lombok.Data;

@Data
public class PolicyDto {
    private int policyId;
    private String policyName;
    private long policyPremiumAmount;
    private String insuranceName;
}
