package com.pismo.model;


import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pismo.dto.TransactionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "Transaction")
public class Transaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(updatable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Account account;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private OperationType operationType;

	@Column(nullable = false, updatable = false)
	private BigDecimal amount;

	@Column(nullable = false, updatable = false)
	private LocalDateTime eventDate;
	
	public TransactionDTO getPersistResultTransaction() {
		return TransactionDTO.builder().account(this.account.getId()).operationType(this.operationType.getId()).amount(this.amount).build();
	}


}
