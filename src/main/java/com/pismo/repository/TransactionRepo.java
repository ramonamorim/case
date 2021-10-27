package com.pismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pismo.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

}
