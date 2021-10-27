package com.pismo.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pismo.dto.AccountDTO;
import com.pismo.exception.AccountInvalidDocumentExcpt;
import com.pismo.exception.AccountNotFoundExcpt;
import com.pismo.model.Account;
import com.pismo.repository.AccountRepo;

@Service
public class AccountService {
	
	public static final String INVALID_DOCUMENT = "O Número de Documento informado é inválido.";

	@Autowired
	private AccountRepo accountRepo;

	public AccountDTO getAccountById(Long id) {
		return accountRepo.findById(id).orElseThrow(() -> new AccountNotFoundExcpt(id)).toResponseFind();
	}

	public AccountDTO createAccount(AccountDTO accountRequestDTO) {
		if(!Pattern.matches("^([0-9]{11}|[0-9]{14})$", accountRequestDTO.getDocumentNumber())) {
			throw new AccountInvalidDocumentExcpt(INVALID_DOCUMENT);
		}
		
		var entity = Account.builder().documentNumber(accountRequestDTO.getDocumentNumber()).build();
		return accountRepo.save(entity).toResponseCreated();

	}

}
