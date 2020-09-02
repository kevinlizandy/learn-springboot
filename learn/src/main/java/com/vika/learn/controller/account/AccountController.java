package com.vika.learn.controller.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vika.learn.exception.ResourceNotFoundException;
import com.vika.learn.model.account.Account;
import com.vika.learn.repository.account.AccountRepository;

@RestController
@RequestMapping("/api/v1/")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	// get account
	@GetMapping("account")
	public List<Account> getAllAccount(){
		return this.accountRepository.findAll(Sort.by("id").descending());
	}
	
	// get account by id
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") Long accountId) throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
					.orElseThrow(() -> new ResourceNotFoundException("Account not found "+accountId.toString()));
		
		return ResponseEntity.ok().body(account);
	}
	
	// save account
	@PostMapping("account")
	public Account createAccount(@RequestBody Account account) {
		
		return this.accountRepository.save(account);
	}
	
	// update account
	@PutMapping("account/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") Long accountId, @Validated @RequestBody Account accountDetails) 
		throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("AccountId not found "+accountId.toString()));
		
		account.setFirstName(accountDetails.getFirstName());
		account.setLastName(accountDetails.getLastName());
		account.setAccountId(accountDetails.getAccountId());
		
		return ResponseEntity.ok(this.accountRepository.save(account));
	}
	
	// delete account
	@DeleteMapping("account/{id}")
	public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") Long accountId) 
			throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("AccountId not found "+accountId.toString()));
		
		this.accountRepository.delete(account);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
	
}
