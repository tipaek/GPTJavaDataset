package com.newweb.model.business;

import javax.persistence.*;

import com.newweb.model.base.Customer;
import com.newweb.model.base.LhjPrice;

@Entity
@Table(name = "t_lhjpricecut")
public class LhjPriceCut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "lhjpriceid")
    private LhjPrice lhjPrice;

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

    public LhjPrice getLhjPrice() {
        return lhjPrice;
    }

    public void setLhjPrice(LhjPrice lhjPrice) {
        this.lhjPrice = lhjPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
