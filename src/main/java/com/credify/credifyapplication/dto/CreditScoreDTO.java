package com.credify.credifyapplication.dto;

import com.credify.credifyapplication.model.CreditScore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreditScoreDTO {

    private int score;
    private CreditScore.RiskLevel riskLevel;
    private LocalDateTime lastUpdated;
}
