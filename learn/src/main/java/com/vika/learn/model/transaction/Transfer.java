package com.vika.learn.model.transaction;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transfers")
public class Transfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "sender_id")
	private long senderId;
	
	@Column(name = "amount")
	private long amount;
	
	@Column(name = "beneficiary_id")
	private long beneficiaryId;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	@Column(name = "status")
	private String status;

	
	public Transfer() {
		super();
	}

	public Transfer(long senderId, long amount, long beneficiaryId, Date transactionDate, String status) {
		super();
		this.senderId = senderId;
		this.amount = amount;
		this.beneficiaryId = beneficiaryId;
		this.transactionDate = transactionDate;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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
