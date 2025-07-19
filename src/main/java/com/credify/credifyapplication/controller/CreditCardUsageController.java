package com.credify.credifyapplication.controller;

import com.credify.credifyapplication.dto.CreditCardUsageListDTO;
import com.credify.credifyapplication.service.CreditCardUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-card-usage")
public class CreditCardUsageController {

    private final CreditCardUsageService creditCardUsageService;

    @Autowired
    public CreditCardUsageController(CreditCardUsageService creditCardUsageService) {
        this.creditCardUsageService = creditCardUsageService;
    }

    @GetMapping
    public List<CreditCardUsageListDTO> getAllCreditCardUsages() {
        return creditCardUsageService.getAllCreditCardUsages();
    }
}
