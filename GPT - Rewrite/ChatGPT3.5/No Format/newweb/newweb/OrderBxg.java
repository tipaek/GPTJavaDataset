package com.newweb.model.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.newweb.model.base.Bxg;

@Entity
@Table(name = "t_order_bxgs")
public class OrderBxg {

    private int ID;
    private Order order;
    private Bxg bxg;
    private double count;
    private String operation; // Data operation type (create: initial order creation, add: added during order modification, update: updated during order modification)

    @Column
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    @ManyToOne
    @JoinColumn(name = "orderID")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "bxgID")
    public Bxg getBxg() {
        return bxg;
    }

    public void setBxg(Bxg bxg) {
        this.bxg = bxg;
    }

    @Column
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
        OrderBxg o = (OrderBxg) obj;
        return bxg != null && bxg.getID() == o.getBxg().getID();
    }

    @Override
    public int hashCode() {
        return bxg != null ? bxg.getID() : 0;
    }
}
