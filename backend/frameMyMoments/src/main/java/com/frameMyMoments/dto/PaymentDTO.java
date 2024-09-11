package com.frameMyMoments.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.frameMyMoments.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PaymentDTO {
    private Long id;
    private BigDecimal amount;
    private String provider;
    private LocalDateTime created;
    private LocalDateTime finished;

    public static PaymentDTO fromEntity(Payment payment) {
        return new PaymentDTO(
                payment.getId(),
                payment.getAmount(),
                payment.getProvider(),
                payment.getCreated(),
                payment.getFinished()
        );
    }

    public static Payment toEntity(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setId(paymentDTO.getId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setProvider(paymentDTO.getProvider());
        payment.setCreated(paymentDTO.getCreated());
        payment.setFinished(paymentDTO.getFinished());
        return payment;
    }
}
