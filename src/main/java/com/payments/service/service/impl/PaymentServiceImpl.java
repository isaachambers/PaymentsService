package com.payments.service.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.service.domain.Payment;
import com.payments.service.repository.PaymentRepository;
import com.payments.service.service.PaymentsService;

@Service
public class PaymentServiceImpl implements PaymentsService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public List<Payment> getPaymentsByCustomerId(Long customerId) {

		return paymentRepository.findPaymentsByCustomerId(customerId);
	}

	@Override
	public List<Payment> getPaymentsByDate(Date paymentDate) {
		return paymentRepository.getPaymentsByDate(paymentDate);
	}

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> allPayments = new ArrayList<Payment>();
		for (Payment p : paymentRepository.findAll()) {
			allPayments.add(p);
		}
		return allPayments;
	}

	@Override
	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}

}
