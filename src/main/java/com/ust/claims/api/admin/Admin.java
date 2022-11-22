package com.ust.claims.api.admin;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="admin_details")
public class Admin {
    private int adminId;
    private String adminName;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private boolean status;
}
