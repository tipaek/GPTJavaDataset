package com.newweb.model.business;

import com.newweb.model.base.Small;
import javax.persistence.*;

@Entity
@Table(name="t_order_smallgoods")
public class OrderSmall {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@ManyToOne
	@JoinColumn(name="orderID")
	private Order order;

	@ManyToOne
	@JoinColumn(name="smallID")
	private Small small;

	@Column
	private double count;

	@Column
	private String operation; // The way the data is operated (create: the first order submission, add: added when the order is modified, update: updated when the order is modified)

	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
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
	public Small getSmall() {
		return small;
	}
	public void setSmall(Small small) {
		this.small = small;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		OrderSmall that = (OrderSmall) obj;
		return small.getId() == that.small.getId();
	}

	@Override
	public int hashCode() {
		return small.getId();
	}
}
