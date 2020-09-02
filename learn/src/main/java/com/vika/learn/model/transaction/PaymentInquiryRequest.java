package com.vika.learn.model.transaction;

public class PaymentInquiryRequest {

	private String id;
	private String billerCode;
	
	
	public PaymentInquiryRequest() {
		super();
	}

	public PaymentInquiryRequest(String id, String billerCode) {
		super();
		this.id = id;
		this.billerCode = billerCode;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBillerCode() {
		return billerCode;
	}
	public void setBillerCode(String billerCode) {
		this.billerCode = billerCode;
	}
	
}
