package com.payments.service.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	@NotNull
	@Column(name = "customer_id")
	private Long customerId;
	@Min(value = 1)
	@Column(name = "payment_amount")
	private double amount;
	@NotNull
	@Column(name = "payment_method")
	private String paymentMethod;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "payment_date")
	private Date paymentDate;

	public Payment(Long paymentId, @NotNull Long customerId, @Min(1) double amount, @NotNull String paymentMethod,
			@NotNull Date paymentDate) {
		super();
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
	}

	public Payment() {

	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
