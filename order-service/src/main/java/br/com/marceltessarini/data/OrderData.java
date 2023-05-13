package br.com.marceltessarini.data;

import java.math.BigDecimal;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import br.com.marceltessarini.model.Order;

public class OrderData {

	@NotNull
	private UUID customerId;
	
	@NotNull
	private BigDecimal total;
	
	private String description;

	public Order toOrder() {
		Order order = new Order();
		
		order.setCustomerId(customerId);
		order.setTotal(total);
		order.setDescription(description);
		
		return order;
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

}
