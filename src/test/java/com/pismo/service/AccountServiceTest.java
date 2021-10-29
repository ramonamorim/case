package com.pismo.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pismo.dto.AccountDTO;
import com.pismo.exception.AccountInvalidDocumentExcpt;
import com.pismo.exception.AccountNotFoundExcpt;
import com.pismo.model.Account;
import com.pismo.repository.AccountRepo;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

	@Mock
	private AccountRepo accountRepo;

	@InjectMocks
	private AccountService accountService;

	@Test
	public void createAccountTest() throws Exception {
		Account account = new Account().builder().id(1L).documentNumber("01234567899").build();

		when(accountRepo.save(any(Account.class))).thenReturn(account);

		AccountDTO accountCreated = accountService.createAccount(account.toResponseCreated());

		assertEquals(account.toResponseCreated().getDocumentNumber(), accountCreated.getDocumentNumber());

	}

	@Test
	public void createAccountError() {
		Account account = new Account().builder().id(1L).documentNumber("0123").build();

		assertThrows(AccountInvalidDocumentExcpt.class,
				() -> accountService.createAccount(account.toResponseCreated()));

	}

	@Test
	public void getAccountByIdSucess() {

		when(accountRepo.findById(1L))
				.thenReturn(Optional.of(Account.builder().id(1L).documentNumber("01234567899").build()));

		AccountDTO account = accountService.getAccountById(1L);

		assertEquals(1L, account.getId());

	}

	@Test
	public void getAccountByIdError() {
		when(accountRepo.findById(1L)).thenReturn(Optional.empty());
		
		assertThatThrownBy(() -> accountService.getAccountById(1L)).isExactlyInstanceOf(AccountNotFoundExcpt.class);

	}
}
