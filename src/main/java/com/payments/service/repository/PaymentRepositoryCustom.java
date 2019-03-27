package com.payments.service.repository;

import java.sql.Date;
import java.util.List;

import com.payments.service.domain.Payment;

public interface PaymentRepositoryCustom {

	public List<Payment> findPaymentsByCustomerId(Long customerId);

	public List<Payment> getPaymentsByDate(Date paymentDate);
}
