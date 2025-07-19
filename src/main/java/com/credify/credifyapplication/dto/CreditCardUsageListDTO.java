package com.credify.credifyapplication.dto;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreditCardUsageListDTO {

    private String name;
    private String email;
    private String phone;
    private String nationalId;
    private LocalDate dateOfBirth;

    private double cardLimit;
    private double currentBalance;
    private LocalDateTime lastUpdated;

}
