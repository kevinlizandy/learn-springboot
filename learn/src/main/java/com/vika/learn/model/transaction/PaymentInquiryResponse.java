package com.vika.learn.model.transaction;

public class PaymentInquiryResponse {


	private String id;
	private String responseCode;
	private String billerCode;
	private Long amount;
	
	
	
	public PaymentInquiryResponse() {
		super();
	}
	public PaymentInquiryResponse(String id, String responseCode, String billerCode, Long amount) {
		super();
		this.id = id;
		this.responseCode = responseCode;
		this.billerCode = billerCode;
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getBillerCode() {
		return billerCode;
	}
	public void setBillerCode(String billerCode) {
		this.billerCode = billerCode;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
}
