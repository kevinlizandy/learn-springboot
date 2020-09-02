package com.vika.learn.model.transaction;

public class PaymentRequest {

	private String accountId;
	private Long amount;
	private String customerId;
	private String billerCode;
	
	
	
	public PaymentRequest() {
		super();
	}
	public PaymentRequest(String accountId, Long amount, String customerId, String billerCode) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.customerId = customerId;
		this.billerCode = billerCode;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
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
	
	
}
