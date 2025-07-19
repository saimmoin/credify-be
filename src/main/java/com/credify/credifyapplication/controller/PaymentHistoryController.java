package com.credify.credifyapplication.controller;

import com.credify.credifyapplication.dto.PaymentHistoryListDTO;
import com.credify.credifyapplication.service.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-history")
public class PaymentHistoryController {

    private final PaymentHistoryService paymentHistoryService;

    @Autowired
    public PaymentHistoryController(PaymentHistoryService paymentHistoryService) {
        this.paymentHistoryService = paymentHistoryService;
    }

    @GetMapping
    public List<PaymentHistoryListDTO> getAllPaymentHistories() {
        return paymentHistoryService.getAllPaymentHistories();
    }
}
