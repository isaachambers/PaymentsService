package com.payments.service.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payments.service.domain.Payment;

@Service
public interface PaymentsService {

	public List<Payment> getPaymentsByCustomerId(Long customerId);

	public List<Payment> getPaymentsByDate(Date paymentDate);

	public List<Payment> getAllPayments();

	public Payment savePayment(Payment payment);

}
