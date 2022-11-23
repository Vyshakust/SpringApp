package com.ust.claims.api.specialist;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SpecialistDto {
    private int specialistID;
    private String specialistName;
    private String qualification;
    private long specialistContactNumber;
    private LocalDateTime modifiedDate;
}
