package com.payments.service.repository.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payments.service.domain.Payment;
import com.payments.service.repository.PaymentRepositoryCustom;

@Repository
@Transactional(readOnly = true)
public class PaymentRepositoryCustomImpl implements PaymentRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> findPaymentsByCustomerId(Long customerId) {
		Query query = entityManager.createNativeQuery(
				"select * from payments  where customer_id =? ORDER BY payment_date DESC ", Payment.class);
		query.setParameter(1, customerId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> getPaymentsByDate(Date paymentDate) {
		Query query = entityManager.createNativeQuery(
				"select * from payments  where payment_date =? ORDER BY payment_date DESC ", Payment.class);
		query.setParameter(1, paymentDate);
		return query.getResultList();
	}

}
