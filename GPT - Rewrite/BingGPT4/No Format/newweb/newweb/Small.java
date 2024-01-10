package com.newweb.model.base;

import com.newweb.model.business.OrderSmall;
import com.newweb.model.business.SmallPriceCut;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="t_small")
public class Small implements Cloneable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", columnDefinition="int default 0 ")
    private int ID;

    @Column
    private String name;

    @Column
    private String type;

    @Column(columnDefinition="int default 0 ")
    private double lsprice;

    @Column(columnDefinition="int default 0 ")
    private double pfprice;

    @ManyToOne
    @JoinColumn(name="supplierID")
    private Supplier supplier;

    @Column
    private String norms;

    @Column
    private String unit;

    @Column(columnDefinition="int default 0 ")
    private int buycount;

    @OneToMany(mappedBy = "small", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderSmall> orderSmalls;

    @OneToMany(mappedBy = "small", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SmallPriceCut> smallPriceCuts;

    @Column(columnDefinition="boolean default true")
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Set<SmallPriceCut> getSmallPriceCuts() {
        return smallPriceCuts;
    }

    public void setSmallPriceCuts(Set<SmallPriceCut> smallPriceCuts) {
        this.smallPriceCuts = smallPriceCuts;
    }

    public Set<OrderSmall> getOrderSmalls() {
        return orderSmalls;
    }

    public void setOrderSmalls(Set<OrderSmall> orderSmalls) {
        this.orderSmalls = orderSmalls;
    }

    public int getBuycount() {
        return buycount;
    }

    public void setBuycount(int buycount) {
        this.buycount = buycount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLsprice() {
        return lsprice;
    }

    public void setLsprice(double lsprice) {
        this.lsprice = lsprice;
    }

    public double getPfprice() {
        return pfprice;
    }

    public void setPfprice(double pfprice) {
        this.pfprice = pfprice;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getNorms() {
        return norms;
    }

    public void setNorms(String norms) {
        this.norms = norms;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public Object clone() {
        try {
            Small small = (Small) super.clone();
            small.supplier = (Supplier) supplier.clone();
            return small;
        } catch (Exception e) {
            return null;
        }
    }
}
