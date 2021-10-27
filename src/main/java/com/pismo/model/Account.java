package com.pismo.model;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.pismo.dto.AccountDTO;

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
	
	public AccountDTO toResponseFind() {
		return AccountDTO.builder().id(this.id).documentNumber(this.documentNumber).build();
		
	}
	
	public AccountDTO toResponseCreated() {
		return AccountDTO.builder().id(this.id).documentNumber(this.documentNumber).build();
		
	}
}
