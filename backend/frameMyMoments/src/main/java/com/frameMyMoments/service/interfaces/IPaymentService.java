package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.PaymentDTO;

import java.util.List;

public interface IPaymentService {
    PaymentDTO getPaymentById(Long id);
    PaymentDTO createPayment(PaymentDTO paymentDTO);
    PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO);
    void deletePayment(Long id);
    List<PaymentDTO> getAllPayments();
}
