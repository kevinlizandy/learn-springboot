package com.vika.learn.model.transaction;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "account_id")
	private String accountId;
	
	@Column(name = "amount")
	private long amount;
	
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "biller_code")
	private String billerCode;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	@Column(name = "status")
	private String status;

	
	
	public Payment() {
		super();
	}

	public Payment(String accountId, long amount, String customerId, String billerCode, Date transactionDate,
			String status) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.customerId = customerId;
		this.billerCode = billerCode;
		this.transactionDate = transactionDate;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getBillerCode() {
		return billerCode;
	}

	public void setBillerCode(String billerCode) {
		this.billerCode = billerCode;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
