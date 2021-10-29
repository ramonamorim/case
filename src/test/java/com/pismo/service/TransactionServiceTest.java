package com.pismo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pismo.dto.TransactionDTO;
import com.pismo.exception.TransactionExcpt;
import com.pismo.model.Account;
import com.pismo.model.OperationType;
import com.pismo.model.Transaction;
import com.pismo.repository.AccountRepo;
import com.pismo.repository.TransactionRepo;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

	@Mock
	private TransactionRepo transactionRepo;

	@Mock
	private AccountRepo accountRepo;

	@InjectMocks
	private TransactionService transactionService;

	@Mock
	private OperationTypeService operationTypeService;

	@Test
	public void transactionCreateTest() throws Exception {
		Account account = new Account().builder().id(1L).documentNumber("01234567899").build();
		OperationType operation = OperationType.builder().id(1L).description("SAQUE").build();

		Transaction transaction = Transaction.builder().account(account).operationType(operation)
				.amount(new BigDecimal(50)).build();

		when(transactionRepo.save(any(Transaction.class))).thenReturn(transaction);

		when(accountRepo.findById(1L))
				.thenReturn(Optional.of(Account.builder().id(1L).documentNumber("01234567899").build()));

		when(operationTypeService.getOperationTypeBydId(1L)).thenReturn(operation);

		TransactionDTO transactionCreated = transactionService
				.createTransaction(transaction.getPersistResultTransaction());

		assertEquals(transaction.getAccount().getId(), transactionCreated.getAccount());
		assertEquals(transaction.getOperationType().getId(), transactionCreated.getOperationType());
		assertEquals(transaction.getAmount(), transactionCreated.getAmount());

	}

	@Test
	public void transactionCreateError() throws Exception {
		Account account = new Account().builder().id(1L).documentNumber("01234567899")
				.availableCreditLimit(new BigDecimal("100.00")).build();
		OperationType operation = OperationType.builder().id(1L).description("SAQUE").build();

		TransactionDTO transaction = Transaction.builder().account(account).operationType(operation)
				.amount(new BigDecimal("101.00")).build().getPersistResultTransaction();

		when(accountRepo.findById(1L)).thenReturn(Optional.of(account));

		when(operationTypeService.getOperationTypeBydId(1L)).thenReturn(operation);

		assertThrows(TransactionExcpt.class, () -> transactionService.createTransaction(transaction));

	}

}
