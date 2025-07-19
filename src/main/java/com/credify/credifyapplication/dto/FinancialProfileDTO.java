package com.credify.credifyapplication.dto;

import com.credify.credifyapplication.model.FinancialProfile;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FinancialProfileDTO {

    private FinancialProfile.EmploymentStatus employmentStatus;
    private double monthlyIncome;
    private double monthlyExpenses;
    private double currentDebt;
    private double assetsValue;
    private LocalDateTime updatedAt;

}
