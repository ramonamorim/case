package com.pismo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.pismo.model.OperationType;
import com.pismo.repository.AccountRepo;
import com.pismo.repository.OperationTypeRepo;

@ExtendWith(MockitoExtension.class)
public class OperationTypeServiceTest {

	@Mock
	private OperationTypeRepo operationTypeRepo;

	@InjectMocks
	private OperationTypeService operationTypeService;

	@Test
	public void getOperationTypeBydIdSucess() {

		when(operationTypeRepo.findById(1l))
				.thenReturn(Optional.of(OperationType.builder().id(1l).description("SAQUE").build()));

		OperationType operationType = operationTypeService.getOperationTypeBydId(1l);

		assertEquals(1L, operationType.getId());
		assertEquals("SAQUE", operationType.getDescription());

	}

}
