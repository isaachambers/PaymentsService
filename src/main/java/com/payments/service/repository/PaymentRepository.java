package com.payments.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payments.service.domain.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>, PaymentRepositoryCustom {

}
