package com.vika.learn.model.transaction;

public class TransferRequest {

	private String from;
	private String to;
	private Long amount;
	
	
	
	public TransferRequest() {
		super();
	}
	public TransferRequest(String from, String to, Long amount) {
		super();
		this.from = from;
		this.to = to;
		this.amount = amount;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
}
