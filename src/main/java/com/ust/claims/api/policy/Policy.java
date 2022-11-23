package com.ust.claims.api.policy;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="policy_details")
public class Policy {
    @Id
    private int policyId;
    private String policyName;
    private long policyPremiumAmount;
    private String insuranceName;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private boolean status;
}
