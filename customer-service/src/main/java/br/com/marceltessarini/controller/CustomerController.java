package br.com.marceltessarini.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.marceltessarini.data.CustomerData;
import br.com.marceltessarini.model.Customer;
import br.com.marceltessarini.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody CustomerData customerData) {
		Customer customer = customerData.toCustomer();

		customerRepository.save(customer);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(customer.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
