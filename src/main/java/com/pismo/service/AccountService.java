package com.pismo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pismo.dto.AccountDTO;
import com.pismo.exception.AccountNotFoundExcpt;
import com.pismo.model.Account;
import com.pismo.repository.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepo;

	public AccountDTO getAccountById(Long id) {
		return accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundExcpt(id)).toResponseFind();
	}

	public AccountDTO createAccount(AccountDTO accountRequestDTO) {
		var entity = Account.builder().documentNumber(accountRequestDTO.getDocumentNumber()).build();
		return accountRepo.save(entity).toResponseCreated();

	}

}
