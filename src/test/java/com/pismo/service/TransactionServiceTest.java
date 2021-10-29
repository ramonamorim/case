package com.pismo.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
import org.springframework.beans.factory.annotation.Autowired;

import com.pismo.dto.AccountDTO;
import com.pismo.dto.TransactionDTO;
import com.pismo.exception.AccountInvalidDocumentExcpt;
import com.pismo.exception.AccountNotFoundExcpt;
import com.pismo.model.Account;
import com.pismo.model.OperationType;
import com.pismo.model.Transaction;
import com.pismo.repository.AccountRepo;
import com.pismo.repository.TransactionRepo;
import com.pismo.service.AccountService;
import com.pismo.service.OperationTypeService;
import com.pismo.service.TransactionService;

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

}
