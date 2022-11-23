package com.ust.claims.api.admin;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AdminDto {
    private String adminName;
    private LocalDateTime modifiedDate;
}
