package com.newweb.model.business;

import javax.persistence.*;

@Entity
@Table(name="t_order_others")
public class OrderOther {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@ManyToOne
	@JoinColumn(name="orderid")
	private Order order;

	@Column
	private String name;

	@Column
	private String unit;

	@Column
	private double count;

	@Column
	private double price;

	@Column
	private String remark;

	@Column
	private String operation; // The way the data is operated (create: the first order submission, add: added when the order is modified, update: updated when the order is modified)

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
}
