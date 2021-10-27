package com.pismo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pismo.exception.OperationTypeExcpt;
import com.pismo.model.OperationType;
import com.pismo.repository.OperationTypeRepo;

@Service
public class OperationTypeService {
	
	@Autowired
	private OperationTypeRepo operationTypeRepo;
	
	public OperationType getOperationTypeBydId(Long id){
		return operationTypeRepo.findById(id).orElseThrow(()-> new OperationTypeExcpt(id));
	}
	

}
