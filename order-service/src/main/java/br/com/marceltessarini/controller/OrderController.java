package br.com.marceltessarini.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.marceltessarini.data.OrderData;
import br.com.marceltessarini.data.OrderView;
import br.com.marceltessarini.model.Order;
import br.com.marceltessarini.model.OrderStatus;
import br.com.marceltessarini.repository.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
    @RequestMapping(value = "/order", method = RequestMethod.GET)
	public List<OrderView> list() {
    	List<Order> orders = orderRepository.findAll();
    	
    	List<OrderView> ordersView = orders.stream().map(o -> OrderView.fromOrder(o)).collect(Collectors.toList());
    	
    	return ordersView;
    }
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody OrderData orderData) {
		Order order = orderData.toOrder();
		
		order.setStatus(OrderStatus.CREATED);
		orderRepository.save(order);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(order.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

}
