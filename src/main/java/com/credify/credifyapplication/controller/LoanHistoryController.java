package com.credify.credifyapplication.controller;

import com.credify.credifyapplication.dto.LoanHistoryListDTO;
import com.credify.credifyapplication.service.LoanHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-history")
public class LoanHistoryController {

    private final LoanHistoryService loanHistoryService;

    @Autowired
    public LoanHistoryController(LoanHistoryService loanHistoryService) {
        this.loanHistoryService = loanHistoryService;
    }

    @GetMapping
    public List<LoanHistoryListDTO> getAllLoanHistories() {
        return loanHistoryService.getAllLoanHistories();
    }
}
