package com.pismo.model;

import static lombok.AccessLevel.PRIVATE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Table(name = "Operation_Type")
public class OperationType implements Serializable {

	private static String PAYMENT = "PAGAMENTO";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, updatable = false)
	private Long id;

	@Column(length = 100, nullable = false)
	private String description;

	public boolean isPayment() {
		if (PAYMENT.equals(this.description)) {
			return true;
		}
		return false;
	}
}
