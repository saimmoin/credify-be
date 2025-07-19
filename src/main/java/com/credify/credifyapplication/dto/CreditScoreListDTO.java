package com.credify.credifyapplication.dto;

import com.credify.credifyapplication.model.CreditScore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreditScoreListDTO {

    private String name;
    private String email;
    private String phone;
    private String nationalId;
    private LocalDate dateOfBirth;

    private int score;
    private CreditScore.RiskLevel riskLevel;
    private LocalDateTime lastUpdated;
}
