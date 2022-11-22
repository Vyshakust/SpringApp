package com.ust.claims.policy;


import lombok.Data;

@Data
public class PolicyDto {
    private int policyId;
    private String policyName;
    private long policyPremiumAmount;
    private String insuranceName;
}
