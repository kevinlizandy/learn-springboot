package com.vika.learn.model.transaction;

public class TransferResponse {

	private String responseCode;
	private String transactionDate;
	
	
	
	public TransferResponse() {
		super();
	}
	public TransferResponse(String responseCode, String transactionDate) {
		super();
		this.responseCode = responseCode;
		this.transactionDate = transactionDate;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}
