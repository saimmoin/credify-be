package com.credify.credifyapplication.service;

import com.credify.credifyapplication.dto.CreditScoreListDTO;
import com.credify.credifyapplication.repository.CreditScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditScoreService {

    private final CreditScoreRepository creditScoreRepository;

    @Autowired
    public CreditScoreService(CreditScoreRepository creditScoreRepository) {
        this.creditScoreRepository = creditScoreRepository;
    }

    public List<CreditScoreListDTO> getAllCreditScores() {
        return creditScoreRepository.findAll().stream().map(credit -> {
            CreditScoreListDTO dto = new CreditScoreListDTO();

            // User info
            if (credit.getUser() != null) {
                dto.setName(credit.getUser().getName());
                dto.setEmail(credit.getUser().getEmail());
                dto.setPhone(credit.getUser().getPhone());
                dto.setNationalId(credit.getUser().getNationalId());
                dto.setDateOfBirth(credit.getUser().getDateOfBirth());
            }

            // Payment info
            dto.setScore(credit.getScore());
            dto.setRiskLevel(credit.getRiskLevel());
            dto.setLastUpdated(credit.getLastUpdated());

            return dto;
        }).collect(Collectors.toList());
    }
}
