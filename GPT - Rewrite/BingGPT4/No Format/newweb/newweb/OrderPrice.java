package com.newweb.model.business;

import javax.persistence.*;

@Entity
@Table(name="t_orderprice")
public class OrderPrice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@ManyToOne
	@JoinColumn(name="orderid")
	private Order order;

	@Column(nullable=false)
	private String type;

	@Column(nullable=false)
	private int productId;

	@Column(nullable=false)
	private double price;

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
