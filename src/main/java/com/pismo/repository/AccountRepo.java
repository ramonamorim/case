package com.pismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pismo.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	Account save(Account entity);

}
