package com.credify.credifyapplication.repository;
import com.credify.credifyapplication.model.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {
    CreditScore findByUserId(Long userId);
}

