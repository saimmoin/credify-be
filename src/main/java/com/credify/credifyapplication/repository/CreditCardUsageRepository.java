package com.credify.credifyapplication.repository;
import com.credify.credifyapplication.model.CreditCardUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CreditCardUsageRepository extends JpaRepository<CreditCardUsage, Long> {
    List<CreditCardUsage> findByUserId(Long userId);
}

