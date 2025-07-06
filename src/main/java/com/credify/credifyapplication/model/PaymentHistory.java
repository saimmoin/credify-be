package com.credify.credifyapplication.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "payment_history")

@NoArgsConstructor
@Getter
@Setter

public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate paymentDate;
    private double amountPaid;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private boolean wasLate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public enum PaymentType {
        LOAN, CREDIT_CARD, UTILITY, OTHER
    }
}

