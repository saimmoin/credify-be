package com.credify.credifyapplication.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    @Column(name = "national_id", unique = true)
    private String nationalId;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private FinancialProfile financialProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private CreditScore creditScore;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LoanHistory> loanHistory;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PaymentHistory> paymentHistory;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CreditCardUsage> creditCardUsage;

}

