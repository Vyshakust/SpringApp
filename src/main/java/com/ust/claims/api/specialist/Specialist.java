package com.ust.claims.api.specialist;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="specialist_details")
public class Specialist {
    @Id
    private int specialistID;
    private String specialistName;
    private String qualification;
    private long specialistContactNumber;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private boolean status;
}


