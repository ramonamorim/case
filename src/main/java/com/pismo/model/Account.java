package com.pismo.model;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.pismo.dto.AccountDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Table(name = "Account")
public class Account implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(updatable = false)
	private Long id;
	
	@NotNull
	@Column(length = 14, nullable = false, updatable = false)
	private String documentNumber;
	
	@NotNull
	@Column(precision = 19, scale = 2, nullable = false)
	private BigDecimal availableCreditLimit = BigDecimal.ZERO;
	
	public AccountDTO toResponseFind() {
		return AccountDTO.builder().id(this.id).documentNumber(this.documentNumber).availableCreditLimit(this.availableCreditLimit).build();
		
	}
	
	public AccountDTO toResponseCreated() {
		return AccountDTO.builder().id(this.id).documentNumber(this.documentNumber).availableCreditLimit(this.availableCreditLimit).build();
		
	}
}
