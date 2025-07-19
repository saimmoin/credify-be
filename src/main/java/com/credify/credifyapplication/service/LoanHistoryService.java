package com.credify.credifyapplication.service;

import com.credify.credifyapplication.dto.LoanHistoryListDTO;
import com.credify.credifyapplication.model.LoanHistory;
import com.credify.credifyapplication.repository.LoanHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanHistoryService {

    private final LoanHistoryRepository loanHistoryRepository;

    @Autowired
    public LoanHistoryService(LoanHistoryRepository loanHistoryRepository) {
        this.loanHistoryRepository = loanHistoryRepository;
    }

    public List<LoanHistoryListDTO> getAllLoanHistories() {
        return loanHistoryRepository.findAll().stream().map(loan -> {
            LoanHistoryListDTO dto = new LoanHistoryListDTO();

            // User info
            if (loan.getUser() != null) {
                dto.setName(loan.getUser().getName());
                dto.setEmail(loan.getUser().getEmail());
                dto.setPhone(loan.getUser().getPhone());
                dto.setNationalId(loan.getUser().getNationalId());
                dto.setDateOfBirth(loan.getUser().getDateOfBirth());
            }

            // Payment info
            dto.setStatus(loan.getStatus());
            dto.setLoanType(loan.getLoanType());
            dto.setLoanAmount(loan.getLoanAmount());
            dto.setStartDate(loan.getStartDate());
            dto.setEndDate(loan.getEndDate());

            return dto;
        }).collect(Collectors.toList());
    }
}
