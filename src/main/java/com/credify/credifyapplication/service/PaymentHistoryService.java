package com.credify.credifyapplication.service;

import com.credify.credifyapplication.dto.PaymentHistoryListDTO;
import com.credify.credifyapplication.model.PaymentHistory;
import com.credify.credifyapplication.repository.PaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentHistoryService {

    private final PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    public PaymentHistoryService(PaymentHistoryRepository paymentHistoryRepository) {
        this.paymentHistoryRepository = paymentHistoryRepository;
    }

    public List<PaymentHistoryListDTO> getAllPaymentHistories() {
        return paymentHistoryRepository.findAll().stream().map(payment -> {
            PaymentHistoryListDTO dto = new PaymentHistoryListDTO();

            // User info
            if (payment.getUser() != null) {
                dto.setName(payment.getUser().getName());
                dto.setEmail(payment.getUser().getEmail());
                dto.setPhone(payment.getUser().getPhone());
                dto.setNationalId(payment.getUser().getNationalId());
                dto.setDateOfBirth(payment.getUser().getDateOfBirth());
            }

            // Payment info
            dto.setPaymentType(payment.getPaymentType());
            dto.setPaymentDate(payment.getPaymentDate());
            dto.setAmountPaid(payment.getAmountPaid());
            dto.setWasLate(payment.isWasLate());

            return dto;
        }).collect(Collectors.toList());
    }
}
