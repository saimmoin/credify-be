package com.credify.credifyapplication.service;
import com.credify.credifyapplication.dto.CreditScoreDTO;
import com.credify.credifyapplication.dto.FinancialProfileDTO;
import com.credify.credifyapplication.dto.UserDTO;
import com.credify.credifyapplication.model.User;
import com.credify.credifyapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(user -> {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());
            dto.setNationalId(user.getNationalId());
            dto.setDateOfBirth(user.getDateOfBirth());

            if (user.getFinancialProfile() != null) {
                FinancialProfileDTO financialProfileDTO = new FinancialProfileDTO();
                financialProfileDTO.setMonthlyIncome(user.getFinancialProfile().getMonthlyIncome());
                financialProfileDTO.setMonthlyExpenses(user.getFinancialProfile().getMonthlyExpenses());
                financialProfileDTO.setCurrentDebt(user.getFinancialProfile().getCurrentDebt());
                financialProfileDTO.setAssetsValue(user.getFinancialProfile().getAssetsValue());
                financialProfileDTO.setUpdatedAt(user.getFinancialProfile().getUpdatedAt());
                financialProfileDTO.setEmploymentStatus(user.getFinancialProfile().getEmploymentStatus());
                dto.setFinancialProfile(financialProfileDTO);
            }

            if (user.getCreditScore() != null) {
                CreditScoreDTO creditScoreDTO = new CreditScoreDTO();
                creditScoreDTO.setScore(user.getCreditScore().getScore());
                creditScoreDTO.setRiskLevel(user.getCreditScore().getRiskLevel());
                creditScoreDTO.setLastUpdated(user.getCreditScore().getLastUpdated());
                dto.setCreditScore(creditScoreDTO);
            }

            return dto;
        });
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());
            dto.setNationalId(user.getNationalId());
            dto.setDateOfBirth(user.getDateOfBirth());

            if (user.getFinancialProfile() != null) {
                FinancialProfileDTO financialProfileDTO = new FinancialProfileDTO();
                financialProfileDTO.setMonthlyIncome(user.getFinancialProfile().getMonthlyIncome());
                financialProfileDTO.setMonthlyExpenses(user.getFinancialProfile().getMonthlyExpenses());
                financialProfileDTO.setCurrentDebt(user.getFinancialProfile().getCurrentDebt());
                financialProfileDTO.setAssetsValue(user.getFinancialProfile().getAssetsValue());
                financialProfileDTO.setUpdatedAt(user.getFinancialProfile().getUpdatedAt());
                financialProfileDTO.setEmploymentStatus(user.getFinancialProfile().getEmploymentStatus());
                dto.setFinancialProfile(financialProfileDTO);
            }

            if (user.getCreditScore() != null) {
                CreditScoreDTO creditScoreDTO = new CreditScoreDTO();
                creditScoreDTO.setScore(user.getCreditScore().getScore());
                creditScoreDTO.setRiskLevel(user.getCreditScore().getRiskLevel());
                creditScoreDTO.setLastUpdated(user.getCreditScore().getLastUpdated());
                dto.setCreditScore(creditScoreDTO);
            }

            return dto;
        }).collect(Collectors.toList());
    }
}
