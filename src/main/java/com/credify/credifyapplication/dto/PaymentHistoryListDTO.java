package com.credify.credifyapplication.dto;

import com.credify.credifyapplication.model.PaymentHistory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentHistoryListDTO {

    private String name;
    private String email;
    private String phone;
    private String nationalId;
    private LocalDate dateOfBirth;

    private PaymentHistory.PaymentType paymentType;
    private LocalDate paymentDate;
    private double amountPaid;
    private boolean wasLate;

}
