package br.com.marceltessarini.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "customer")
@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
    @Column(nullable = false, length = 255)
    @NotEmpty
	private String name;
    
    @Column(nullable = false, length = 255)
    @NotEmpty
	private String email;
    
    @Column(nullable = false, name = "credit_limit")
    @NotNull
	private BigDecimal creditLimit;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

}
