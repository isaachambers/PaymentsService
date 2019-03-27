package com.payments.service.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payments.service.domain.Payment;
import com.payments.service.service.PaymentsService;

@RestController()
@RequestMapping(path = "/payments")
public class PaymentController {

	@Autowired
	private PaymentsService customerService;

	@RequestMapping(path = "/getAllPayments", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllCustomers() {
		try {
			List<Payment> customers = customerService.getAllPayments();
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@RequestMapping(path = "/getPaymentsByDate/{paymentDate}", method = RequestMethod.GET)
	public ResponseEntity<Object> getPaymentsByDate(@PathVariable() Date paymentDate) {
		try {
			List<Payment> customers = customerService.getPaymentsByDate(paymentDate);
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@RequestMapping(path = "/getPaymentsByCustomerId/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getPaymentsByCustomerId(@PathVariable() Long customerId) {
		try {

			List<Payment> customers = customerService.getPaymentsByCustomerId(customerId);
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Object> saveCustomer(@RequestBody Payment payment) {
		Payment p;
		try {
			p = customerService.savePayment(payment);
			return new ResponseEntity<>(p, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
