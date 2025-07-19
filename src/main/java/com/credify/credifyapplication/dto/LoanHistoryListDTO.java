package com.credify.credifyapplication.dto;

import com.credify.credifyapplication.model.LoanHistory;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class LoanHistoryListDTO {

    private String name;
    private String email;
    private String phone;
    private String nationalId;
    private LocalDate dateOfBirth;

    private LoanHistory.Status status;
    private String loanType;
    private double loanAmount;
    private LocalDate startDate;
    private LocalDate endDate;

}
