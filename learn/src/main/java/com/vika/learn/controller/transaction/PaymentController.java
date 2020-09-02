package com.vika.learn.controller.transaction;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vika.learn.model.account.Account;
import com.vika.learn.model.transaction.Payment;
import com.vika.learn.model.transaction.PaymentInquiryRequest;
import com.vika.learn.model.transaction.PaymentInquiryResponse;
import com.vika.learn.model.transaction.PaymentRequest;
import com.vika.learn.model.transaction.PaymentResponse;
import com.vika.learn.repository.account.AccountRepository;
import com.vika.learn.repository.transaction.PaymentRepository;

@RestController
@RequestMapping("/api/v1/payment/")
public class PaymentController {

	@Value("${api.url}")
	private String apiUrl;
	
	@Autowired
	private AccountRepository accountRepos;
	
	@Autowired
	private PaymentRepository paymentRepos;
	
	@PostMapping("inquiry")
	public PaymentInquiryResponse inquiryBiller(@RequestBody PaymentInquiryRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		
		PaymentInquiryResponse response = restTemplate.postForObject(apiUrl, request, PaymentInquiryResponse.class);
		
		return response;
	}
	
	@PostMapping("pay")
	public PaymentResponse payBiller(@RequestBody PaymentRequest request) {
		Account account = accountRepos.findByAccountId(request.getAccountId());
		
		PaymentResponse payResp = new PaymentResponse();
		
		Payment payment = new Payment();
		payment.setAccountId(request.getAccountId());
		payment.setAmount(request.getAmount());
		payment.setBillerCode(request.getBillerCode());
		payment.setCustomerId(request.getCustomerId());
		payment.setStatus("00");
		payment.setTransactionDate(new Date());
		
		if(request.getAmount() > account.getBalance())
		{
			payment.setStatus("55");
			
			paymentRepos.save(payment);
			
			payResp.setResponseCode("55");
		}
		else
		{
			account.setBalance(account.getBalance() - request.getAmount());
			accountRepos.save(account);
			
			paymentRepos.save(payment);
			
			PaymentInquiryRequest payReq = new PaymentInquiryRequest(request.getCustomerId(), request.getBillerCode());
			
			RestTemplate restTemplate = new RestTemplate();
			PaymentInquiryResponse response = restTemplate.postForObject(apiUrl, payReq, PaymentInquiryResponse.class);
			
			payResp.setResponseCode(response.getResponseCode());
			
		}
		
		payResp.setTransactionDate(payment.getTransactionDate().toString());
		
		return payResp;
	}
	
	
}
