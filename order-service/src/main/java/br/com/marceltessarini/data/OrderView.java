package br.com.marceltessarini.data;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.marceltessarini.model.Order;
import br.com.marceltessarini.model.OrderStatus;

public class OrderView {
	
	public static OrderView fromOrder(Order order) {
		UUID customerId = order.getCustomerId();
		String description = order.getDescription();
		UUID id = order.getId();
		OrderStatus status = order.getStatus();
		BigDecimal total = order.getTotal();
		
		OrderView orderView = new OrderView();
		
		orderView.setCustomerId(customerId);
		orderView.setDescription(description);
		orderView.setId(id);
		orderView.setStatus(status);
		orderView.setTotal(total);
		
		return orderView;
	}

	private UUID id;

	private UUID customerId;

	private BigDecimal total;

	private String description;

	private OrderStatus status;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
