package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.PaymentDTO;
import com.frameMyMoments.entity.Payment;
import com.frameMyMoments.repository.PaymentRepository;
import com.frameMyMoments.service.interfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
        return PaymentDTO.fromEntity(payment);
    }

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Payment payment = PaymentDTO.toEntity(paymentDTO);
        payment = paymentRepository.save(payment);
        return PaymentDTO.fromEntity(payment);
    }

    @Override
    public PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
        payment = PaymentDTO.toEntity(paymentDTO);
        payment.setId(id);
        payment = paymentRepository.save(payment);
        return PaymentDTO.fromEntity(payment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream().map(PaymentDTO::fromEntity).collect(Collectors.toList());
    }
}