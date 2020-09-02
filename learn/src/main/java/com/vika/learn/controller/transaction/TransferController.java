package com.vika.learn.controller.transaction;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vika.learn.model.account.Account;
import com.vika.learn.model.transaction.Transfer;
import com.vika.learn.model.transaction.TransferHistory;
import com.vika.learn.model.transaction.TransferInquiry;
import com.vika.learn.model.transaction.TransferRequest;
import com.vika.learn.model.transaction.TransferResponse;
import com.vika.learn.repository.account.AccountRepository;
import com.vika.learn.repository.transaction.TransferRepository;

@RestController
@RequestMapping("/api/v1/")
public class TransferController {
	
	@Autowired
	private TransferRepository transferRepo;
	
	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("transfer/inquiry/{id}")
	public TransferInquiry inquiryTransfer(@PathVariable(value = "id") String beneficiaryId) {
		TransferInquiry transferInq = new TransferInquiry();
		
		Account account = accountRepository.findByAccountId(beneficiaryId);
		
		transferInq.setAccountId(account.getAccountId());
		transferInq.setFirstName(account.getFirstName());
		transferInq.setLastName(account.getLastName());
		transferInq.setResponseCode("00");
		
		return transferInq;
	}
	
	@PostMapping("transfer/commit")
	public TransferResponse transferCommit(@RequestBody TransferRequest transferRequest) {
		TransferResponse transferResp = new TransferResponse();
		
		Long fromBalance = accountRepository.findByAccountId(transferRequest.getFrom()).getBalance();
		
		Date transDate = new Date();
		
		Long fromId = accountRepository.findByAccountId(transferRequest.getFrom()).getId();
		Long toId = accountRepository.findByAccountId(transferRequest.getTo()).getId();
		
		Transfer transfer = new Transfer();
		transfer.setAmount(transferRequest.getAmount());
		transfer.setBeneficiaryId(toId);
		transfer.setSenderId(fromId);
		transfer.setStatus("00");
		transfer.setTransactionDate(transDate);
		
		if(fromBalance < transferRequest.getAmount())
		{
			transfer.setStatus("55");
			
			transferResp.setResponseCode("55");
			transferResp.setTransactionDate(transDate.toString());
		}
		else
		{
			Account accountFrom = accountRepository.findByAccountId(transferRequest.getFrom());
			Account accountTo = accountRepository.findByAccountId(transferRequest.getTo());
			
			accountFrom.setBalance(accountFrom.getBalance() - transferRequest.getAmount());
			accountTo.setBalance(accountTo.getBalance() + transferRequest.getAmount());
			
			this.accountRepository.save(accountFrom);
			this.accountRepository.save(accountTo);
			
			transferResp.setResponseCode("00");
			transferResp.setTransactionDate(transDate.toString());	
		}
		
		this.transferRepo.save(transfer);
		
		return transferResp;
	}
	
	@GetMapping("transfer/history/{id}")
	public List<Transfer> getTransferHistory(@PathVariable(value = "id") Long id) {
		return transferRepo.getHistoryById(id);
	}
	
}
