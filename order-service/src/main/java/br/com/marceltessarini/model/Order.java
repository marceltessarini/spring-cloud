package br.com.marceltessarini.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "orders")
@Entity
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name = "customer_id", nullable = false)
	@NotNull
	private UUID customerId;
	
    @Column(nullable = false)
    @NotNull
	private BigDecimal total;
    
    @Column(length = 500)
	private String description;
	
    @NotNull
    @Column(nullable = false)
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
