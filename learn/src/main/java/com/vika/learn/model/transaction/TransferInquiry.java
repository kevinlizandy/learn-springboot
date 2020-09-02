package com.vika.learn.model.transaction;

public class TransferInquiry {
	
	private String accountId;
	private String firstName;
	private String lastName;
	private String responseCode;
	
	
	public TransferInquiry() {
		super();
	}
	
	public TransferInquiry(String accountId, String firstName, String lastName) {
		super();
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	
	
}
