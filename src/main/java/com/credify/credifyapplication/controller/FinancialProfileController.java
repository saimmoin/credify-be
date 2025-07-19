package com.credify.credifyapplication.controller;

import com.credify.credifyapplication.dto.FinancialProfileListDTO;
import com.credify.credifyapplication.service.FinancialProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financial-profile")
public class FinancialProfileController {

    private final FinancialProfileService financialProfileService;

    @Autowired
    public FinancialProfileController(FinancialProfileService financialProfileService) {
        this.financialProfileService= financialProfileService;
    }

    @GetMapping
    public List<FinancialProfileListDTO> getAllFinancialProfiles() {
        return financialProfileService.getAllFinancialProfiles();
    }
}
