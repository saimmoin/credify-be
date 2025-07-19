package com.credify.credifyapplication.service;

import com.credify.credifyapplication.dto.FinancialProfileDTO;
import com.credify.credifyapplication.dto.FinancialProfileListDTO;
import com.credify.credifyapplication.model.LoanHistory;
import com.credify.credifyapplication.repository.FinancialProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinancialProfileService {

    private final FinancialProfileRepository financialProfileRepository;

    @Autowired
    public FinancialProfileService(FinancialProfileRepository financialProfileRepository) {
        this.financialProfileRepository = financialProfileRepository;
    }

    public List<FinancialProfileListDTO> getAllFinancialProfiles() {
        return financialProfileRepository.findAll().stream().map(fn -> {
            FinancialProfileListDTO dto = new FinancialProfileListDTO();

            // User info
            if (fn.getUser() != null) {
                dto.setName(fn.getUser().getName());
                dto.setEmail(fn.getUser().getEmail());
                dto.setPhone(fn.getUser().getPhone());
                dto.setNationalId(fn.getUser().getNationalId());
                dto.setDateOfBirth(fn.getUser().getDateOfBirth());
            }

            // Payment info
            dto.setEmploymentStatus(fn.getEmploymentStatus());
            dto.setMonthlyIncome(fn.getMonthlyIncome());
            dto.setMonthlyExpenses(fn.getMonthlyExpenses());
            dto.setCurrentDebt(fn.getCurrentDebt());
            dto.setAssetsValue(fn.getAssetsValue());
            dto.setUpdatedAt(fn.getUpdatedAt());

            return dto;
        }).collect(Collectors.toList());
    }
}
