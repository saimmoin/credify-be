package com.credify.credifyapplication.service;

import com.credify.credifyapplication.dto.CreditCardUsageListDTO;
import com.credify.credifyapplication.model.LoanHistory;
import com.credify.credifyapplication.repository.CreditCardUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditCardUsageService {

    private final CreditCardUsageRepository creditCardUsageRepository;

    @Autowired
    public CreditCardUsageService(CreditCardUsageRepository creditCardUsageRepository) {
        this.creditCardUsageRepository = creditCardUsageRepository;
    }

    public List<CreditCardUsageListDTO> getAllCreditCardUsages() {
        return creditCardUsageRepository.findAll().stream().map(usage -> {
            CreditCardUsageListDTO dto = new CreditCardUsageListDTO();

            // User info
            if (usage.getUser() != null) {
                dto.setName(usage.getUser().getName());
                dto.setEmail(usage.getUser().getEmail());
                dto.setPhone(usage.getUser().getPhone());
                dto.setNationalId(usage.getUser().getNationalId());
                dto.setDateOfBirth(usage.getUser().getDateOfBirth());
            }

            // Payment info
            dto.setCardLimit(usage.getCardLimit());
            dto.setCurrentBalance(usage.getCurrentBalance());
            dto.setLastUpdated(usage.getLastUpdated());

            return dto;
        }).collect(Collectors.toList());
    }
}
