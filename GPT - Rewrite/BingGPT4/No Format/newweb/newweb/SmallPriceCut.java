package com.newweb.model.business;

import com.newweb.model.base.Customer;
import com.newweb.model.base.Small;

import javax.persistence.*;

@Entity
@Table(name="t_smallpricecut")
public class SmallPriceCut {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="smallid")
    private Small small;

    @Column
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
