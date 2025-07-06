package com.credify.credifyapplication.repository;
import com.credify.credifyapplication.model.FinancialProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialProfileRepository extends JpaRepository<FinancialProfile, Long> {
    FinancialProfile findByUserId(Long userId);
}
