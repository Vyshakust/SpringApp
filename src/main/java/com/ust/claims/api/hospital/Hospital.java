package com.ust.claims.api.hospital;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "hospital_details")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hospitalId;
    private String hospitalName;
    private String hospitalLocation;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private boolean status;
}