package com.ust.claims.api.hospital;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class HospitalDto {
    private int hospitalId;
    private String hospitalName;
    private String hospitalLocation;
    private LocalDateTime modifiedDate;
}
