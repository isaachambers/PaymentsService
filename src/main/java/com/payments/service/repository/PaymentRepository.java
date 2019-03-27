package com.payments.service.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payments.service.domain.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

	@Query("select p from Payment P where p.customerId =?")
	List<Payment> findPaymentsByCustomerId(Long customerId);

	@Query("select p from Payment P where p.paymentDate =?")
	public List<Payment> getPaymentsByDate(Date paymentDate);

}
