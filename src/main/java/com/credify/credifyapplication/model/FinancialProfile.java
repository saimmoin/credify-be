package com.credify.credifyapplication.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "financial_profiles")

@NoArgsConstructor
@Getter
@Setter

public class FinancialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_status")
    private EmploymentStatus employmentStatus;

    private double monthlyIncome;
    private double monthlyExpenses;
    private double currentDebt;
    private double assetsValue;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public enum EmploymentStatus {
        EMPLOYED, SELF_EMPLOYED, UNEMPLOYED, STUDENT, RETIRED
    }
}
