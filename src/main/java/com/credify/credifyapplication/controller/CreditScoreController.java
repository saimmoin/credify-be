package com.credify.credifyapplication.controller;

import com.credify.credifyapplication.dto.CreditScoreListDTO;
import com.credify.credifyapplication.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-score")
public class CreditScoreController {

    private final CreditScoreService creditScoreService;

    @Autowired
    public CreditScoreController(CreditScoreService creditScoreService) {
        this.creditScoreService = creditScoreService;
    }

    @GetMapping
    public List<CreditScoreListDTO> getAllCreditScore() {
        return creditScoreService.getAllCreditScores();
    }
}
