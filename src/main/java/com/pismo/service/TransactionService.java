package com.pismo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pismo.dto.TransactionDTO;
import com.pismo.exception.AccountNotFoundExcpt;
import com.pismo.exception.TransactionExcpt;
import com.pismo.model.Transaction;
import com.pismo.repository.AccountRepo;
import com.pismo.repository.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private OperationTypeService operationTypeService;

	public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
		var account = accountRepo.findById(transactionDTO.getAccount())
				.orElseThrow(() -> new AccountNotFoundExcpt(transactionDTO.getAccount()));
		var operationType = operationTypeService.getOperationTypeBydId(transactionDTO.getOperationType());
		var amount = operationType.isPayment() ? transactionDTO.getAmount() : transactionDTO.getAmount().negate();

		if (operationType.isPayment()) {
			account.setAvailableCreditLimit(account.getAvailableCreditLimit().add(amount));
		}
		BigDecimal availableCreditLimit = account.getAvailableCreditLimit();

		if (availableCreditLimit.add(amount).compareTo(new BigDecimal("0.00")) >= 0) {
			BigDecimal newCreditLimit = availableCreditLimit.add(amount);
			account.setAvailableCreditLimit(newCreditLimit);
		} else {
			throw new TransactionExcpt();

		}

		var entity = Transaction.builder().amount(amount).operationType(operationType).account(account)
				.eventDate(LocalDateTime.now()).build();

		return transactionRepo.save(entity).getPersistResultTransaction();
	}

}
