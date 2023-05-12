package br.com.marceltessarini.data;

import java.util.UUID;

import br.com.marceltessarini.model.Customer;

public class CustomerView {

	public static CustomerView fromCustomer(Customer customer) {
		UUID id = customer.getId();
		String name = customer.getName();
		String email = customer.getEmail();
		String creditLimit = customer.getCreditLimit().toString();

		return new CustomerView(id, name, email, creditLimit);
	}

	private UUID id;
	private String name;
	private String email;
	private String creditLimit;

	private CustomerView(UUID id, String name, String email, String creditLimit) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.creditLimit = creditLimit;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

}
