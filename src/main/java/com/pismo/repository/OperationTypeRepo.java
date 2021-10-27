package com.pismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pismo.model.OperationType;

@Repository
public interface OperationTypeRepo extends JpaRepository<OperationType, Long> {

}
