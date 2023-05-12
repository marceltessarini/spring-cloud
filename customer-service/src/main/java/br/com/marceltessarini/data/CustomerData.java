package br.com.marceltessarini.data;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import br.com.marceltessarini.model.Customer;

public class CustomerData {

	@NotEmpty
	private String name;

	@NotEmpty
	private String email;

	@NotEmpty
	private String creditLimit;

	public Customer toCustomer() {
		Customer customer = new Customer();

		customer.setName(name);
		customer.setEmail(email);
		customer.setCreditLimit(new BigDecimal(creditLimit));

		return customer;
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

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

}
